package edu.suffolk.litlab.efspserver.services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Request;

/** Most of this class taken from the below blog post: https://dalelane.co.uk/blog/?p=1871 */
public class EndpointReflection {

  private final String baseUrl;

  public EndpointReflection(String startUrl) {
    baseUrl = ServiceHelpers.EXTERNAL_URL + startUrl;
  }

  /** Returns REST endpoints defined in Java classes in the specified package. */
  @SuppressWarnings("rawtypes")
  public List<Endpoint> findRESTEndpoints(List<Class> classes) {
    var endpoints = new ArrayList<Endpoint>();

    for (Class<?> clazz : classes) {
      Path annotation = clazz.getAnnotation(Path.class);
      String basePath = "/";
      if (annotation != null) {
        basePath = getRESTEndpointPath(clazz);
      }
      Method[] methods = clazz.getMethods();
      endpoints.addAll(makeRestEndpoints(methods, clazz, basePath));
    }
    return endpoints;
  }

  public List<Endpoint> makeRestEndpoints(List<Method> methods, Class<?> clazz) {
    String basePath = getRESTEndpointPath(clazz);
    return makeRestEndpoints(methods.toArray(new Method[0]), clazz, basePath);
  }

  private List<Endpoint> makeRestEndpoints(Method[] methods, Class<?> clazz, String basePath) {
    var endpoints = new ArrayList<Endpoint>();
    for (Method method : methods) {
      if (method.isAnnotationPresent(GET.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.GET, clazz, basePath));
      } else if (method.isAnnotationPresent(PUT.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.PUT, clazz, basePath));
      } else if (method.isAnnotationPresent(POST.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.POST, clazz, basePath));
      } else if (method.isAnnotationPresent(DELETE.class)) {
        endpoints.add(createEndpoint(method, MethodEnum.DELETE, clazz, basePath));
      } else if (method.isAnnotationPresent(Path.class)) {
        // This happens when we return a whole object to handle that endpoint. Sholud have a root
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
      toDisplay.put(clazz.getSimpleName(), baseUrl + annotation.value());
    }
    return toDisplay;
  }

  public static List<Endpoint> replacePathParam(
      List<Endpoint> endpoints, Map<String, String> paramVals) {
    for (Endpoint endpoint : endpoints) {
      for (Map.Entry<String, String> paramVal : paramVals.entrySet()) {
        endpoint.uri = endpoint.uri.replace("{" + paramVal.getKey() + "}", paramVal.getValue());
        endpoint.pathParameters.removeIf(ep -> ep.name.equals(paramVal.getKey()));
      }
    }
    return endpoints;
  }

  public Map<String, Map<String, String>> endPointsToMap(List<Endpoint> endpoints) {
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
          || (parameter == javax.servlet.http.HttpServletResponse.class)
          || (parameter == javax.servlet.http.HttpServletRequest.class)) {
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
    DELETE
  }

  enum ParameterType {
    QUERY,
    PATH,
    PAYLOAD
  }

  public class Endpoint {
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

  public class EndpointParameter {
    ParameterType parameterType = ParameterType.PAYLOAD;
    String javaType;
    String defaultValue;
    String name;
  }
}
