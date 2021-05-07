package edu.suffolk.assemblyline.efspserver;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider; 

public class EfspServer {
  
  protected EfspServer() throws Exception {
    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(UserService.class);
    sf.setResourceProvider(UserService.class, new SingletonResourceProvider(new UserService()));
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
