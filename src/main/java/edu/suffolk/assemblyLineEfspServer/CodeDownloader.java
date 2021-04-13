package edu.suffolk.assemblyLineEfspServer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class CodeDownloader {

    private static final String PATH_TO_KEYSTORE = "Suffolk.pfx";
    private static final String SIGNATUREALGO = "SHA256withRSA";

    byte[] signPkcs7(final byte[] content, final CMSSignedDataGenerator generator) throws Exception {
        CMSTypedData cmsdata = new CMSProcessableByteArray(content);
        CMSSignedData signeddata = generator.generate(cmsdata, true);
        return signeddata.getEncoded();
    }

    KeyStore loadKeyStore() throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        InputStream is = new FileInputStream(PATH_TO_KEYSTORE);
        keystore.load(is, System.getenv("X509_PASSWORD").toCharArray()); 
        return keystore;
    }

    CMSSignedDataGenerator setUpProvider(final KeyStore keystore) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String alias = (String) keystore.aliases().nextElement();

        Certificate[] certchain = (Certificate[]) keystore.getCertificateChain(alias);
        final List<Certificate> certlist = new ArrayList<Certificate>();

        for (int i = 0, length = certchain == null ? 0 : certchain.length; i < length; i++) {
            certlist.add(certchain[i]);
        }

        JcaCertStore certstore = new JcaCertStore(certlist);
        Certificate cert = keystore.getCertificate(alias);

        ContentSigner signer = new JcaContentSignerBuilder(SIGNATUREALGO).setProvider("BC").
                build((PrivateKey) (keystore.getKey(alias, System.getenv("X509_PASSWORD").toCharArray()))); 

        CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

        generator.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC").
                build()).build(signer, (X509Certificate) cert));

        generator.addCertificates(certstore);
        return generator;
    }
    
    public static String signedBase64(CodeDownloader signer, String content) throws Exception {
        byte[] signedBytes = signer.signPkcs7(content.getBytes("UTF-8"), signer.setUpProvider(signer.loadKeyStore()));
        return Base64.getEncoder().encodeToString(signedBytes);
    }
    
    
    public static Document LoadCodesXML(String fileName) throws Exception {
    	File file = new File(fileName);
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	DocumentBuilder db = dbf.newDocumentBuilder();
    	Document doc = db.parse(file);
    	doc.getDocumentElement().normalize();
    	return doc;
    }
    
    public static Optional<Node> GetSubElement(Node node, String subelementName) {
    	if (!node.hasChildNodes()) {
    		return Optional.empty();
    	}
    	for (int i = 0; i < node.getChildNodes().getLength(); i++) {
    		Node childNode = node.getChildNodes().item(i);
    		if (childNode.getNodeName() != null && childNode.getNodeName().equals(subelementName)) {
    			return Optional.of(childNode);
    		}
    	}
    	return Optional.empty();
    }
    
    public static List<Node> GetAllSubElements(Node node, String subelementName) {
    	List<Node> fullList = new ArrayList<Node>();
    	if (!node.hasChildNodes()) {
    		return fullList; 
    	}

    	for (int i = 0; i < node.getChildNodes().getLength(); i++) {
    		Node childNode = node.getChildNodes().item(i);
    		if (childNode.getNodeName() != null && childNode.getNodeName().equals(subelementName)) {
    			fullList.add(childNode);
    		}
    	}
    	return fullList; 
    }
    
    public static Optional<String> GetAttribute(Node node, String attrName) {
    	if (node.getAttributes() != null && node.getAttributes().getLength() == 0) {
    		return Optional.empty();
    	}
        Node attr = node.getAttributes().getNamedItem(attrName);
        if (attr != null) {
        	return Optional.of(attr.getNodeValue());
        }
        return Optional.empty();
    }
    
    public static void WriteCSV(Document codeXml, String outFileName) throws IOException {
    	File outFile = new File(outFileName);
    	BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

    	// Write all the Columns to the CSV
    	NodeList nodeList = codeXml.getElementsByTagName("CodeList").item(0).getChildNodes(); 
    	Optional<NodeList> maybeColumns = Optional.empty(); 
    	Optional<NodeList> maybeRows = Optional.empty();
    	for (int i = 0; i < nodeList.getLength(); i++) {
    		String name = nodeList.item(i).getNodeName();
    		System.out.println("Val: " + name + ", " + nodeList.item(i).getNodeName() + ", " + nodeList.item(i).getNodeType());
            if (name != null && name.equals("ColumnSet")) {
                maybeColumns = Optional.of(nodeList.item(i).getChildNodes()); 
            } else if (name != null && name.equals("SimpleCodeList")) {
        	    maybeRows = Optional.of(nodeList.item(i).getChildNodes());
            }
    	}

    	// TODO(brycew): would like to do something more functional, but NodeList is lacking constructors or functional items
        NodeList columnsList = maybeColumns.orElseThrow();
    	
        Map<String, Integer> columnIndices = new HashMap<String, Integer>();
        ArrayList<String> defaultColValues = new ArrayList<String>();
    	for (int i = 0; i < columnsList.getLength(); i++) {
    		Node node = columnsList.item(i);
    		if (node.getNodeType() == Node.ELEMENT_NODE) {
    			System.out.println("Cols: " + node.getNodeName() + ", " + node.getNodeValue() + ", " + node.getNodeType());
    			Optional<Node> maybeChild = GetSubElement(node, "ShortName");
    			Optional<String> maybeId = GetAttribute(node, "Id");
    			maybeId.ifPresent((id) -> {
    				columnIndices.put(id,  defaultColValues.size()); 
    				defaultColValues.add(id);
    			});

    			if (maybeChild.isPresent()) {
    				Node nameNode = maybeChild.get();
    				writer.append(nameNode.getTextContent());
        			if (i < columnsList.getLength() - 1) {
        				writer.append(';');
        			}
    			}
    		}
    	}
    	writer.newLine();
    	
    	// Write each row
    	NodeList rowList = maybeRows.orElseThrow();

        for (int i = 0; i < rowList.getLength(); i++) {
        	ArrayList<String> theseColValues = new ArrayList<String>(defaultColValues); 
        	Node node = rowList.item(i);
        	if (node.getNodeType() != Node.ELEMENT_NODE) {
        		continue;
        	}
        	List<Node> allValues = GetAllSubElements(node, "Value");
        	for (Node n : allValues) {
        		Optional<String> maybeId = GetAttribute(n, "ColumnRef");
        		Optional<Node> maybeVal = GetSubElement(n, "SimpleValue");
        		if (maybeId.isPresent() && maybeVal.isPresent()) {
        			int idx = columnIndices.get(maybeId.get());
        			theseColValues.set(idx, maybeVal.get().getTextContent()); 
        		}
        	}
        	writer.append(String.join(";", theseColValues));
        	writer.newLine();
        }
        
        writer.close();
    }
    
    public static void readCodes() throws Exception {
    	// TODO(brycew): ready directly from zip as well
    	Document doc = LoadCodesXML("testing_codes/locations.xml");
    	WriteCSV(doc, "testing_codes/locations.csv");
    }
    
    /**
     * https://stackoverflow.com/a/1485730/11416267
     * @param urlToRead
     * @return
     * @throws Exception
     */
    public static InputStream getHTML(String urlToRead, String auth_header) throws Exception {
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("tyl-efm-api", auth_header);
        return conn.getInputStream();
    }
    
    public static void download() throws Exception {
        CodeDownloader signer = new CodeDownloader();
        // TODO(brycew): use the current time
        String b64_out = signedBase64(signer, "2021-02-22T18:08:00.775Z"); 
        // TODO(brycew): make this an env variable somehow
        String base_url = "https://illinois-stage.tylerhost.net";
        InputStream urlStream = getHTML(base_url + "/CodeService/codes/location", b64_out);
        
        // Write out the zip file
        FileOutputStream file_out = new FileOutputStream("testing_codes.zip");
        long length = urlStream.transferTo(file_out); 
        System.out.println(length + " bytes transfered");
        // TODO(brycew): read back in that zip file
    }

    public static void main(String[] args) throws Exception {
    	readCodes();
    }
}