package com.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet(
    name = "ComputerComponetsComparator",
    urlPatterns = {"/ccc"}
)
public class CCC extends HttpServlet {
	
	public FuenteDato scrapPCC = new ScrappingPCC();
	public FuenteDato scrapCU = new ScrappingCU();
	public AmazonAPI amazon = new AmazonAPI();
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    // BUSQUEDA EN PCCOMPONENTES
    //response.getWriter().print(scrapPCC.getNPages(request.getParameter("busqueda"))); eeeeeeeeeeeeeeeeh
    
    ArrayList<Producto> productos = new ArrayList<Producto>();
    IntegracionDatos intDatos = new IntegracionDatos(productos,scrapPCC.query(request.getParameter("busqueda")),120);
    
   // String salida_amazon = amazon.queryAmazon("cpu");
    //response.getWriter().print(salida_amazon);
    
    // BUSQUEDA EN WORTEN
    response.getWriter().print(scrapCU.query(request.getParameter("busqueda")));
    
  }
}