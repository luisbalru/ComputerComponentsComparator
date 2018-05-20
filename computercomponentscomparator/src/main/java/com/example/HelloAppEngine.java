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
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	
	public ScrappingPCC scrapPCC = new ScrappingPCC();
	//En desuso    public ScrappingGS scrapGS = new ScrappingGS();
	
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    // BUSQUEDA EN PCCOMPONENTES
    //response.getWriter().print(scrapPCC.getNPages(request.getParameter("busqueda")));
    
    ArrayList<Producto> productos = new ArrayList<Producto>();
    IntegracionDatos intDatos = new IntegracionDatos(productos,scrapPCC.getNPages(request.getParameter("busqueda")),120);
    
    // BUSQUEDA EN GOOGLE SHOPPING
    //response.getWriter().print(scrapGS.getPage(request.getParameter("busqueda")));
    
  }
}