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
		String words[] = query.split(" ");
		if(words.length > 1) {
			words[0] += " " + words[1];
			if(words.length > 2) {
				words[0] += " " + words[2];
			}
			if(words.length > 3) {
				words[0] += " " + words[3];
			}
		}
	    salida_amazon = amazon.query(words[0]);
	}
	
	public ArrayList<String> getInformacion() throws SAXException, IOException, ParserConfigurationException 
	{
		InputStream in = new ByteArrayInputStream(salida_amazon.getBytes("utf-8"));
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
        ArrayList<String> salida = new ArrayList<String>();

        // process
        NodeList urls = doc.getElementsByTagName("DetailPageURL");
        NodeList prices = doc.getElementsByTagName("Prices");
        NodeList rebajas = doc.getElementsByTagName("LowestNewPrice");
        
        
        
        
        Node url = urls.item(0);
        Element e_url = (Element) url;
        	
        
        Node rprice = rebajas.item(0);
        
        Node hijo_rprice = rprice.getLastChild();
       
        
        Node price = prices.item(0);
        Node hijo_price = price.getLastChild();
        
        
        Element e_price = (Element) price;
        if(hijo_price!=null && e_url!=null) {
        	salida.add("Id desconocido");
        	salida.add(e_url.getTextContent());
        	if(hijo_rprice != null)
        		salida.add(hijo_rprice.getTextContent()+"€");
        	else
        		salida.add(hijo_price.getTextContent()+"€");
        }
        return salida;
	}

}
