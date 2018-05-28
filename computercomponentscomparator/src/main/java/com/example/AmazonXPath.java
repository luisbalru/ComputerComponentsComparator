package com.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AmazonXPath {
	private String salida_amazon;
	
	public AmazonXPath(String query) {
		AmazonAPI amazon = new AmazonAPI();
	    salida_amazon = amazon.query(query);
	}
	
	public ArrayList<String> getInformacion() throws SAXException, IOException, ParserConfigurationException 
	{
		InputStream in = new ByteArrayInputStream(salida_amazon.getBytes("utf-8"));
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
        ArrayList<String> salida = new ArrayList<String>();

        // process
        NodeList urls = doc.getElementsByTagName("DetailPageURL");
        NodeList prices = doc.getElementsByTagName("FormattedPrice");
        
        Node url = urls.item(0);
        Element e_url = (Element) url;
        if(e_url!=null)
        	salida.add(e_url.getTextContent());
        
        Node price = prices.item(0);
        Element e_price = (Element) price;
        if(e_price!=null)
        	salida.add(e_price.getTextContent());
        
        return salida;
	}

}
