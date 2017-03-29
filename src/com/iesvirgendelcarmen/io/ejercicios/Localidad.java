package com.iesvirgendelcarmen.io.ejercicios;

public class Localidad {
//atributos: id,latitude,longitude,elevation,name,url,year
	private String idLocalidad;
	private double latitudLocalidad;
	private double longitudLocalidad;
	private double altitudLocalidad;
	private String nombreLocalidad;
	private String urlLocalidad;
	private int anno;
	public Localidad(String idLocalidad, double latitudLocalidad, double longitudLocalidad, double altitudLocalidad,
			String nombreLocalidad, String urlLocalidad, int anno) {
		this.idLocalidad = idLocalidad;
		this.latitudLocalidad = latitudLocalidad;
		this.longitudLocalidad = longitudLocalidad;
		this.altitudLocalidad = altitudLocalidad;
		this.nombreLocalidad = nombreLocalidad;
		this.urlLocalidad = urlLocalidad;
		this.anno = anno;
	}
	
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	
	public double getLatitudLocalidad() {
		return latitudLocalidad;
	}

	public double getLongitudLocalidad() {
		return longitudLocalidad;
	}

	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", latitudLocalidad=" + latitudLocalidad
				+ ", longitudLocalidad=" + longitudLocalidad + ", altitudLocalidad=" + altitudLocalidad
				+ ", nombreLocalidad=" + nombreLocalidad + ", urlLocalidad=" + urlLocalidad + ", anno=" + anno + "]";
	}
	
	
}
