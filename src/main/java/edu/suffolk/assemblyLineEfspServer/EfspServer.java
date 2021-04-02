/**
 * 
 */
package edu.suffolk.assemblyLineEfspServer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;

/**
 * @author brycew
 *
 */
public final class EfspServer {

	/**
	 * @param args
	 */
	
	private static final QName SERVICE_NAME = new QName("urn:tyler:efm:services", "EfmUserService");
	
	public static void main(String[] args) {
        URL wsdlURL = EfmUserService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
		
		EfmUserService ss = new EfmUserService(wsdlURL, SERVICE_NAME);
		IEfmUserService port = ss.getBasicHttpBindingIEfmUserService();
		BindingProvider bp = (BindingProvider) port;
		Map<String, Object> ctx = bp.getRequestContext();
		ctx.put("security.username", "bwilley");
		ctx.put("security.signature.properties", "client_sign.properties");
		ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
		ctx.put("security.signature.username", "1");

		
		//SOAPBinding binding = (SOAPBinding)bp.getBinding();
		//binding.setMTOMEnabled(true);
		//org.apache.cxf.endpoint.Client client = ClientProxy.getClient(port);
		//org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
		
		//Map<String, Object> inProps = new HashMap<String, Object>();
		
		//WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		//cxfEndpoint.getInInterceptors().add(wssIn);
		
		//Map<String, Object> outProps = new HashMap<String, Object>();
		
		//outProps.put(WSHandlerConstants.ACTION, 
		//		WSHandlerConstants.TIMESTAMP + " " +
		//        WSHandlerConstants.SIGNATURE);
		//outProps.put(WSHandlerConstants.INCLUDE_SIGNATURE_TOKEN, "true");
	    //outProps.put(WSHandlerConstants.USER, "bwilley");
	    //outProps.put(WSHandlerConstants.SIGNATURE_USER, "1");
	    //outProps.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");
	    //outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientCallbackHandler.class.getName());
		
		//WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		//cxfEndpoint.getOutInterceptors().add(wssOut);
		
		AuthenticateRequestType authReq = new AuthenticateRequestType();
		authReq.setEmail("bwilley@suffolk.edu");
		authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
		AuthenticateResponseType authRes = port.authenticateUser(authReq);
		System.out.println(authRes.getError().getErrorCode());
		System.out.println(authRes.getError().getErrorText());
		System.out.println(authRes.getEmail());
		System.out.println(authRes.getPasswordHash());
	}

}
