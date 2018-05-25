package com.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

@WebServlet(
    name = "ComputerComponetsComparator",
    urlPatterns = {"/ccc"}
)
public class CCC extends HttpServlet {
	
	public FuenteDato scrapPCC = new ScrappingPCC();
<<<<<<< HEAD
	//public FuenteDato scrapGS = new ScrappingGS();
	//public FuenteDato ebayasker = new EbayAsker();
	
=======
	public FuenteDato scrapWorten = new ScrappingWorten();
	public AmazonAPI amazon = new AmazonAPI();
>>>>>>> refs/remotes/origin/master
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<String> salida_amazon = new ArrayList<String>();
    IntegracionDatos intDatos = new IntegracionDatos(productos,scrapPCC.query(request.getParameter("busqueda")),120);
    AmazonXPath amazon;
    
<<<<<<< HEAD
    for(int i=0; i<productos.size(); i++) {
	    amazon = new AmazonXPath(productos.get(i).getNombre());
	    try {
			salida_amazon = amazon.getInformacion();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    productos.get(i).addOferta(salida_amazon, "Amazon");
    }
=======
    String salida_amazon = amazon.queryAmazon("cpu");
    response.getWriter().print(salida_amazon);
>>>>>>> refs/remotes/origin/master
    
<<<<<<< HEAD
    /*AmazonAPI amazon = new AmazonAPI();
    String salida_amazon = amazon.queryAmazon(request.getParameter("busqueda"));
    response.getWriter().print(salida_amazon);*/
    
    
=======
    // BUSQUEDA EN WORTEN
    response.getWriter().print(scrapWorten.query(request.getParameter("busqueda")));
>>>>>>> refs/remotes/origin/master
    
  }
}