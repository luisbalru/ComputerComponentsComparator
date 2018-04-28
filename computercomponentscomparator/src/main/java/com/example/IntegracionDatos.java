package com.example;


import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class IntegracionDatos {
	private Document doc_pcc;
	private Document doc_gs;
	private Elements links_pcc;
	private Elements media_pcc;
	
	// Representación de los datos para Amazon con la API por determinar
	
	/**
	 * Constructor de la clase IntegracionDatos. Genera productos e integra la información sobre el producto
	 *  de las distintas fuentes de datos.
	 * 
	 * @param html_pcc String resultado del scrapping en PCComponentes
	 * @param html_gs String resultado del scrapping en Google Shopping
	 * @param num_prod Entero que indica el número de productos a almacenar
	 */
	public IntegracionDatos(String html_pcc, String html_gs, int num_prod) {
		doc_pcc = Jsoup.parse(html_pcc);
		doc_gs = Jsoup.parse(html_gs);
		// Amazon
		for(int i=0; i<num_prod; ++i) {
			Producto prod = new Producto();
			procesarDatosPCC(prod);
			procesarDatosGS(prod);
			// Amazon
		}
	}
	
	/**
	 * Método que incorpora al producto la información referente a PCComponentes
	 * @param prod Producto a procesar
	 */
	private void procesarDatosPCC(Producto prod) {
		
	}
	
	private void procesarDatosGS(Producto prod) {
		
	}
	
	
	

}
