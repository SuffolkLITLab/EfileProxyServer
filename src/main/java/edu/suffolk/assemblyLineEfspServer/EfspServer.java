/**
 * 
 */
package edu.suffolk.assemblyLineEfspServer;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;

import org.apache.cxf.headers.Header;

/**
 * @author brycew
 *
 */
public final class EfspServer {

	/**
	 * @param args
	 */
	
	private static final QName SERVICE_NAME = new QName("urn:tyler:efm:services", "EfmUserService");
	
	public static void main(String[] args) throws JAXBException {
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
		ctx.put("security.username", "bwilley@suffolk.edu");
		ctx.put("security.password", "can-be-anything?");
		ctx.put("security.signature.properties", "client_sign.properties");
		ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
		ctx.put("security.signature.username", "1");

		AuthenticateRequestType authReq = new AuthenticateRequestType();
		authReq.setEmail("bwilley@suffolk.edu");
		authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
		AuthenticateResponseType authRes = port.authenticateUser(authReq);
		System.out.println(authRes.getError().getErrorCode());
		System.out.println(authRes.getError().getErrorText());
		System.out.println(authRes.getEmail());
		System.out.println(authRes.getUserID());
		System.out.println(authRes.getPasswordHash());

		GetUserRequestType getUserReq = new GetUserRequestType();
		getUserReq.setUserID(authRes.getUserID());
		ArrayList<Header> headersList = new ArrayList<Header>();
		headersList.add(TylerUserNamePassword.MakeHeader(authRes.getEmail(), authRes.getPasswordHash())); 
		ctx.put(Header.HEADER_LIST, headersList);
		GetUserResponseType getUserResp = port.getUser(getUserReq);
		System.out.println(getUserResp.getError().getErrorCode());
		System.out.println(getUserResp.getError().getErrorText());
		System.out.println(getUserResp.getUser());
		if (getUserResp.getUser() != null) {
			System.out.println(getUserResp.getUser().getEmail());
			System.out.println(getUserResp.getUser().getFirstName());
			System.out.println(getUserResp.getUser().getFirmID());
			System.out.println(getUserResp.getUser().isIsLockedOut());
			System.out.println(getUserResp.getUser().getLastLoginDate());
		}
	}

}
