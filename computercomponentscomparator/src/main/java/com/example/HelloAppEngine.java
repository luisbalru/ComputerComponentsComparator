package com.example;

import java.io.IOException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

	public ScrappingPCC scrapPCC = new ScrappingPCC();
	public ScrappingGS scrapGS = new ScrappingGS();
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    // BUSQUEDA EN PCCOMPONENTES
    //response.getWriter().print(scrapPCC.getNPages(request.getParameter("busqueda")));
    
    // BUSQUEDA EN GOOGLE SHOPPING
    response.getWriter().print(scrapGS.getPage(request.getParameter("busqueda")));
    
  }
}