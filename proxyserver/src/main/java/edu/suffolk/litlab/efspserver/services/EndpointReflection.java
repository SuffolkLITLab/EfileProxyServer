package edu.suffolk.litlab.efspserver.services;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Most of this class taken from the below blog post: https://dalelane.co.uk/blog/?p=1871 */
public class EndpointReflection {
  private static Logger log = LoggerFactory.getLogger(EndpointReflection.class);

  private final String baseUrl;

  public EndpointReflection(String startUrl) {
    baseUrl = ServiceHelpers.EXTERNAL_URL + startUrl;
  }

  /** Returns REST endpoints defined in Java classes in the specified package. */
  @SuppressWarnings("rawtypes")
  public List<Endpoint> findRESTEndpoints(List<Class> classes) {
    var endpoints = new HashSet<Endpoint>();

    Deque<Class> classQueue = new ArrayDeque<>();
    classQueue.addAll(classes);
    while (!classQueue.isEmpty()) {
      Class<?> clazz = classQueue.pop();
      if (clazz == null) {
        continue;
      }
      classQueue.addAll(List.of(clazz.getInterfaces()));
      if (clazz.getSuperclass() != null) {
        classQueue.add(clazz.getSuperclass());
      }
      Path annotation = clazz.getAnnotation(Path.class);
      String basePath = "/";
      if (annotation != null) {
        basePath = getRESTEndpointPath(clazz);
      }
      Method[] methods = clazz.getMethods();
      endpoints.addAll(makeRestEndpoints(methods, clazz, basePath));
    }
    return endpoints.stream().toList();
  }

  public Set<Endpoint> makeRestEndpoints(List<Method> methods, Class<?> clazz) {
    String basePath = getRESTEndpointPath(clazz);
    return makeRestEndpoints(methods.toArray(new Method[0]), clazz, basePath);
  }

  private Set<Endpoint> makeRestEndpoints(Method[] methods, Class<?> clazz, String basePath) {
    var endpoints = new HashSet<Endpoint>();
    for (Method method : methods) {
      if (method.isAnnotationPresent(GET.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.GET, clazz, basePath));
      } else if (method.isAnnotationPresent(PUT.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.PUT, clazz, basePath));
      } else if (method.isAnnotationPresent(POST.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.POST, clazz, basePath));
      } else if (method.isAnnotationPresent(DELETE.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.DELETE, clazz, basePath));
      } else if (method.isAnnotationPresent(OPTIONS.class)) {
        // Skip, there is no need to document OPTIONS, only used for CORS stuff
      } else if (method.isAnnotationPresent(Path.class)) {
        // This happens when we return a whole object to handle that endpoint. Should have a root
        // GET on each of those.
        endpoints.add(createEndpoint(method, MethodEnum.GET, clazz, basePath));
      }
    }
    return endpoints;
  }

  @SuppressWarnings("rawtypes")
  public Map<String, String> getClassPaths(List<Class> classes) {
    Map<String, String> toDisplay = new HashMap<>();
    for (Class<?> clazz : classes) {
      Path annotation = clazz.getAnnotation(Path.class);
      if (annotation != null) {
        toDisplay.put(clazz.getSimpleName(), baseUrl + annotation.value());
      } else {
        log.warn("No @Path annotation found on {}, was expected", clazz.getSimpleName());
      }
    }
    return toDisplay;
  }

  public static Collection<Endpoint> replacePathParam(
      Collection<Endpoint> endpoints, Map<String, String> paramVals) {
    for (Endpoint endpoint : endpoints) {
      for (Map.Entry<String, String> paramVal : paramVals.entrySet()) {
        endpoint.uri = endpoint.uri.replace("{" + paramVal.getKey() + "}", paramVal.getValue());
        endpoint.pathParameters.removeIf(ep -> ep.name.equals(paramVal.getKey()));
      }
    }
    return endpoints;
  }

  public Map<String, Map<String, String>> endPointsToMap(Collection<Endpoint> endpoints) {
    return endpoints.stream()
        .collect(
            Collectors.toMap(
                e -> e.javaMethodName,
                e -> {
                  return Map.of(
                      "url", baseUrl + e.uri,
                      "method", e.method.name(),
                      "query_params",
                          e.queryParameters.stream()
                              .map(qp -> qp.name)
                              .collect(Collectors.toList())
                              .toString());
                }));
  }

  public Map<String, String> pathParamsToMap(Stream<String> params) {
    return params.collect(Collectors.toMap(p -> p, p -> baseUrl + "/" + p));
  }

  /**
   * Create an endpoint object to represent the REST endpoint defined in the specified Java method.
   */
  private Endpoint createEndpoint(
      Method javaMethod, MethodEnum restMethod, Class<?> clazz, String classUri) {
    Endpoint newEndpoint = new Endpoint();
    newEndpoint.method = restMethod;
    newEndpoint.javaMethodName = javaMethod.getName();
    newEndpoint.javaClass = clazz.getName();

    Path path = javaMethod.getAnnotation(Path.class);
    if (path != null) {
      if (path.value().startsWith("/")) {
        newEndpoint.uri = classUri + path.value().substring(1);
      } else {
        newEndpoint.uri = classUri + path.value();
      }
    } else {
      newEndpoint.uri = classUri;
    }
    discoverParameters(javaMethod, newEndpoint);
    return newEndpoint;
  }

  /** Get the parameters for the specified endpoint from the provided java method. */
  @SuppressWarnings("rawtypes")
  private void discoverParameters(Method method, Endpoint endpoint) {

    Annotation[][] annotations = method.getParameterAnnotations();
    Class[] parameterTypes = method.getParameterTypes();

    for (int i = 0; i < parameterTypes.length; i++) {
      Class parameter = parameterTypes[i];

      // ignore parameters used to access context
      if ((parameter == Request.class)
          || (parameter == jakarta.servlet.http.HttpServletResponse.class)
          || (parameter == jakarta.servlet.http.HttpServletRequest.class)) {
        continue;
      }

      EndpointParameter nextParameter = new EndpointParameter();
      nextParameter.javaType = parameter.getName();

      Annotation[] parameterAnnotations = annotations[i];
      for (Annotation annotation : parameterAnnotations) {
        if (annotation instanceof PathParam) {
          nextParameter.parameterType = ParameterType.PATH;
          PathParam pathparam = (PathParam) annotation;
          nextParameter.name = pathparam.value();
        } else if (annotation instanceof QueryParam) {
          nextParameter.parameterType = ParameterType.QUERY;
          QueryParam queryparam = (QueryParam) annotation;
          nextParameter.name = queryparam.value();
        } else if (annotation instanceof DefaultValue) {
          DefaultValue defaultvalue = (DefaultValue) annotation;
          nextParameter.defaultValue = defaultvalue.value();
        }
      }

      switch (nextParameter.parameterType) {
        case PATH:
          endpoint.pathParameters.add(nextParameter);
          break;
        case QUERY:
          endpoint.queryParameters.add(nextParameter);
          break;
        case PAYLOAD:
          endpoint.payloadParameters.add(nextParameter);
          break;
      }
    }
  }

  /**
   * Get the REST endpoint path for the specified class. This involves (recursively) looking
   * for @Parent annotations and getting the path for that class before appending the location in
   * the @Path annotation.
   */
  private static String getRESTEndpointPath(Class<?> clazz) {
    String path = "";
    Annotation annotation = clazz.getAnnotation(Path.class);
    if (annotation != null) {
      path = ((Path) annotation).value() + path;
    }
    if (path.endsWith("/") == false) {
      path = path + "/";
    }
    return path;
  }

  enum MethodEnum {
    PUT,
    POST,
    GET,
    DELETE,
  }

  enum ParameterType {
    QUERY,
    PATH,
    PAYLOAD
  }

  public static class Endpoint {
    String uri;
    MethodEnum method;

    String javaClass;
    String javaMethodName;

    List<EndpointParameter> queryParameters = new ArrayList<>();
    List<EndpointParameter> pathParameters = new ArrayList<>();
    List<EndpointParameter> payloadParameters = new ArrayList<>();

    @Override
    public String toString() {
      return method + " " + uri + ", triggering " + javaMethodName;
    }
  }

  public static class EndpointParameter {
    ParameterType parameterType = ParameterType.PAYLOAD;
    String javaType;
    String defaultValue;
    String name;
  }
}
