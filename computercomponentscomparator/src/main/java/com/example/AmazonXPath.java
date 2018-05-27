package com.example;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AmazonXPath {
	private String salida_amazon;
	
	public AmazonXPath(String query) {
		AmazonAPI amazon = new AmazonAPI();
	    salida_amazon = amazon.query(query);
	}
	
	public ArrayList<String> getInformacion() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(salida_amazon));
		Document doc = builder.parse(is); System.out.println(doc.toString()); 
        ArrayList<String> salida = new ArrayList<String>();
 
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        
        
        XPathExpression expr = xpath.compile("/ItemSearchResponse/Items/Item/ASIN/text()");
        Object result = expr.evaluate(doc, XPathConstants.NODESET); //System.out.println((String)result);
        NodeList nodes = (NodeList) result; System.out.println("Tamanio nodeList: " + nodes.getLength() + "\n");
        salida.add(nodes.item(0).getNodeValue());

        
        expr = xpath.compile("/Item/DetailPageURL/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        salida.add(nodes.item(0).getNodeValue());
        
        expr = xpath.compile("//Item/Offers/Offer/OfferListing/Price/FormattedPrice/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        salida.add(nodes.item(0).getNodeValue());
        
        return salida;
	}

}
