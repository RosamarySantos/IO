package com.iesvirgendelcarmen.io.ejercicios;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Libro implements Serializable{
	private String isbn;
	private String titulo;
	private double precio;
	public Libro(String isbn, String titulo, double precio) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "ISBN=" + isbn + ", titulo=" + titulo + ", precio=" + precio + "\n";
	}
	
}
