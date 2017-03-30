package com.iesvirgendelcarmen.io.ejercicios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mapa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Localidad> listaLocalidades = 
			new ArrayList<Localidad>();

	public List<Localidad> getListaLocalidades() {
		return listaLocalidades;
	}

	public void setListaLocalidades(List<Localidad> listaLocalidades) {
		this.listaLocalidades = listaLocalidades;
	}
	public void addLocalidad(Localidad localidad){
		listaLocalidades.add(localidad);
	}

	@Override
	public String toString() {
		return "Mapa [listaLocalidades=" + listaLocalidades + "]";
	}
	public double[] obtenerPosicion(String nombreLocalidad){
		double[] posicion = new double[2];
		//inicializamos los valores por si no existe la localidad
		posicion[0] = Double.NaN;  
		posicion[1] = Double.NaN;

		for (Localidad localidad : listaLocalidades){
			if (nombreLocalidad.equals(localidad.getNombreLocalidad())){
				posicion[0] = localidad.getLatitudLocalidad();
				posicion[1] = localidad.getLongitudLocalidad();
			};
		}
		return posicion;
	}
}
