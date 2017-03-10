package com.iesvirgendelcarmen.io.teoria;

import java.io.Serializable;

//clase ejemplo, para que convertirla en un flujo (stream)
//como la clase genera objetos sería Objetc[Input/Output]Stream
//para que se pueda hacer dicha claser debe implementar una interfaz
//llamada Serializable
public class Persona implements Serializable{
	//atributos
	private String nombreCompleto; 
	private int edad;
	private boolean sexo; //true si es hombre, false si es mujer
	//constructor
	public Persona(String nombreCompleto, int edad, boolean sexo) {
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.sexo = sexo;
	}
	//getters y setters
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return nombreCompleto + ", " + edad + " años, hombre=" + sexo;
	}
	
}
