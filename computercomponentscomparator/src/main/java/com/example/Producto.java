package com.example;


public class Producto{
	private String nombre;
	private String precio_pcc;
	private String precio_gs;
	private String precio_amazon;
	private String pccomp_id;
	private String gs_id;
	private String amazon_id;
	private String img;
	private String descripcion;
	
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
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter para el precio en PCComponentes.
	 * @return String con el precio del producto en PCComponentes.
	 */
	public String getPrecio_pcc() {
		return precio_pcc;
	}
	
	/**
	 * Setter para el precio en PCComponentes.
	 * @param precio_pcc String con el precio del producto en PCComponentes.
	 */
	private void setPrecio_pcc(String precio_pcc) {
		this.precio_pcc = precio_pcc;
	}
	
	/**
	 * Getter del precio del producto en Amazon.
	 * @return String con el precio del producto en Amazon.
	 */
	public String getPrecio_amazon() {
		return precio_amazon;
	}
	
	/**
	 * Setter del precio del producto en Amazon.
	 * @param precio_amazon String con el precio del producto en Amazon.
	 */
	public void setPrecio_amazon(String precio_amazon) {
		this.precio_amazon = precio_amazon;
	}
	
	/**
	 * Getter del precio del producto en Google Shopping.
	 * @return String con el precio del producto en Google Shopping.
	 */
	public String getPrecio_gs() {
		return precio_gs;
	}
	
	/**
	 * Setter del precio del producto en Google Shopping.
	 * @param precio_gs String con el precio del producto en Google Shopping.
	 */
	public void setPrecio_gs(String precio_gs) {
		this.precio_gs = precio_gs;
	}
	
	/**
	 * Getter del id del producto en PCComponentes.
	 * @return String con el id del producto en PCComponentes.
	 */
	public String getPccomp_id() {
		return pccomp_id;
	}
	
	/**
	 * Setter del id del producto en PCComponentes.
	 * @param pccomp_id String con el id del producto en PCComponentes.
	 */
	public void setPccomp_id(String pccomp_id) {
		this.pccomp_id = pccomp_id;
	}
	
	/**
	 * Getter del id del producto en Google Shopping.
	 * @return String con el id del producto en Google Shopping.
	 */
	public String getGs_id() {
		return gs_id;
	}
	
	/**
	 * Setter del id del producto en Google Shopping.
	 * @param gs_id String con el id del producto en Google Shopping.
	 */
	public void setGs_id(String gs_id) {
		this.gs_id = gs_id;
	}
	
	/**
	 * Getter del id del producto en Amazon.
	 * @return String con el id del producto en Amazon.
	 */
	public String getAmazon_id() {
		return amazon_id;
	}
	
	/**
	 * Setter del id del producto en Amazon.
	 * @param amazon_id String con el id del producto en Amazon.
	 */
	public void setAmazon_id(String amazon_id) {
		this.amazon_id = amazon_id;
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
}