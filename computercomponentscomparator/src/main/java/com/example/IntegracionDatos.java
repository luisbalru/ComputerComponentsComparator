package com.example;

import java.io.BufferedReader;
import java.io.IOException;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class IntegracionDatos {
  private Document doc_pcc;
  private Document doc_gs;
  private Elements name_pcc;
  private Elements prices_pcc;
  private Elements links_gs;
  private Elements prices_gs;
  private Elements imgs;
  private Elements category;
  private Elements brands;
  private Elements pcc_id;
  private Elements links_pcc;
  
  // Representación de los datos para Amazon con la API por determinar
  
  /**
   * Constructor de la clase IntegracionDatos. Genera productos e integra la información sobre el producto
   *  de las distintas fuentes de datos.
   * 
   * @param html_pcc String resultado del scrapping en PCComponentes
   * @param html_gs String resultado del scrapping en Google Shopping
   * @param num_prod Entero que indica el número de productos a buscar (cuando sea necesario)
   */
  public IntegracionDatos(ArrayList<Producto> productos, String html_pcc, int num_prod) {
    doc_pcc = Jsoup.parse(html_pcc);
    name_pcc = doc_pcc.select("h3 > a");
    category = doc_pcc.select("h3 > a");
    brands = doc_pcc.select("h3 > a");
    pcc_id = doc_pcc.select("h3 > a");
    links_pcc = doc_pcc.select("h3 > a");
    prices_pcc = doc_pcc.select("div.tarjeta-articulo__precios");
    imgs = doc_pcc.select("img.img-fluid");    
    procesarDatosPCC(productos,num_prod);

  }
  
  public void integraDatosGS(ArrayList<Producto> productos, String html_gs, int num_prod)
  {
	  doc_gs = Jsoup.parse(html_gs);
	  procesarDatosGS(productos,num_prod);
  }
  
  public Elements getName()
  {
    return name_pcc;
  }
  
  public Elements getPricesPCC()
  {
	  return prices_pcc;
  }
  
  public Elements getLinksPCC()
  {
	  return links_pcc;
  }
  
  public Elements getImgs()
  {
	  return imgs;
  }
  
  public Elements getCategory()
  {
	  return category;
  }
  
  public Elements getBrands()
  {
	  return brands;
  }
  
  public Elements getPCC_id()
  {
	  return pcc_id;
  }
  
  /**
   * Método que incorpora al producto la información referente a PCComponentes
   * @param ArrayList de productos
   */
  private void procesarDatosPCC(ArrayList<Producto> prods,int num_prod) {
	  	Elements name = getName();
		Elements prices = getPricesPCC();
		Elements imgs = getImgs();
		Elements brands = getBrands();
		Elements category = getCategory();
		Elements pcc_ids = getPCC_id();
		Elements enlace = getLinksPCC();
		ArrayList<String> nombres_pcc = new ArrayList<String>();
		ArrayList<String> imagenes = new ArrayList<String>();
		ArrayList<String> precios_pcc = new ArrayList<String>(); 
		ArrayList<String> marcas = new ArrayList<String>();
		ArrayList<String> categorias = new ArrayList<String>();
		ArrayList<String> id_pcc = new ArrayList<String>();
		ArrayList<String> enlaces = new ArrayList<String>();
		
		for(Element e : name)
		{
          String aux = e.attr("data-name");
          nombres_pcc.add(aux);
		}
		
		for(Element l : enlace)
		{
			String aux = "www.pccomponentes.com"; 
			aux = aux+l.attr("href");
			enlaces.add(aux);
		}
		
		for(Element p : prices)
		{
			String aux = p.text();
			precios_pcc.add(aux);
		}
		
		for(Element i : imgs)
		{
			String aux = i.attr("src");
			aux=aux.substring(2);
			imagenes.add(aux);
		}
		
		for(Element b : brands)
		{
			String aux = b.attr("data-brand");
			marcas.add(aux);
		}
		
		for(Element c : category)
		{
			String aux = c.attr("data-category");
			categorias.add(aux);
		}
		
		for(Element i : pcc_ids)
		{
			String aux = i.attr("data-id");
			id_pcc.add(aux);
		}
		
		
		for(int i=0; i<id_pcc.size(); ++i) // Hasta el número de productos. En esta prueba, 2
		{
			Producto aux = new Producto();
			Oferta oferta = new Oferta();
			ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
			aux.setNombre(nombres_pcc.get(i));
			oferta.setPrecio(precios_pcc.get(i));
			aux.setImg(imagenes.get(i));
			aux.setCategory(categorias.get(i));
			aux.setMarca(marcas.get(i));
			oferta.setId(id_pcc.get(i));
			oferta.setMarket("PCC");
			oferta.setEnlace(enlaces.get(i));
			ofertas.add(oferta);
			aux.setOfertas(ofertas);
			prods.add(aux);
		} 
  }
  
  private void procesarDatosGS(ArrayList<Producto> prods, int num_prod) {
    
  }
  
}
