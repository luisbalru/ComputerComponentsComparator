package com.example;

import java.util.ArrayList;

public class Producto{
  private String nombre;
  private String category;
  private String marca;
  private String img;
  private String descripcion;
  private String ean;
  private ArrayList<Oferta> ofertas;
  
  /**
   * Función que devuelve el nombre del producto.
   * @return String con el nombre del producto.
   */
  public String getNombre() {
    return nombre;
  }
  
  /**
   * Establece el nombre del producto.
   * @param nombre String.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  
  /**
   * Getter de la url de la imagen del producto.
   * @return String con la url de la imagen del producto.
   */
  public String getImg() {
    return img;
  }
  
  /**
   * Setter de la url de la imagen del producto.
   * @param img String con la url de la imagen del producto.
   */
  public void setImg(String img) {
    this.img = img;
  }
  
  /**
   * Getter de la descripción del producto.
   * @return String con la descripción del producto.
   */
  public String getDescripcion() {
    return descripcion;
  }
  
  /**
   * Setter de la descripción del producto.
   * @param descripcion String con la descripción del producto.
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Getter de la categoría del producto
   * @return String con la categoría
   */
  public String getCategory() {
	return category;
  }

  /**
   * Setter de la categoría del producto
   * @param category
   */
  public void setCategory(String category) {
	 this.category = category;
  }

  /**
   * Getter de la marca del producto
   * @return String con la marca
   */
  public String getMarca() {
	return marca;
  }

  /**
   * Setter de la marca del producto
   * @param marca
   */
  public void setMarca(String marca) {
	this.marca = marca;
  }

  public ArrayList<Oferta> getOfertas() {
	return ofertas;
  }

  public void setOfertas(ArrayList<Oferta> ofertas) {
	this.ofertas = ofertas;
  }

public String getEan() {
	return ean;
}

public void setEan(String ean) {
	this.ean = ean;
}
  
  
}