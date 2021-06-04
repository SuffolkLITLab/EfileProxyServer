package edu.suffolk.assemblyline.efspserver;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;

public class EfspServer {

  protected EfspServer() throws Exception {
    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(UserService.class);
    sf.setResourceProvider(UserService.class, new SingletonResourceProvider(new UserService()));
    Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
    extensionMappings.put("xml", MediaType.APPLICATION_XML);
    extensionMappings.put("json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<Object> providers = List.of(new JAXBElementProvider(), new JacksonJsonProvider());
    sf.setProviders(providers);
    sf.setAddress("http://localhost:9000");
    sf.create();
  }

  public static void main(String[] args) throws Exception {
    new EfspServer();
    System.out.println("Server ready...");

    Thread.sleep(5 * 6000 * 1000);
    System.out.println("Server exiting");
    System.exit(0);
  }

}
