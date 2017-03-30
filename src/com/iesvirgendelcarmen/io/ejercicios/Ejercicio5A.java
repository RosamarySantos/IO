package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5A {
	static Mapa mapa = new Mapa();
	public static void main(String[] args) {
		
		leerFichero("ficherosEntrada/geografia.csv");
		//System.out.println(mapa);
		escribirEnFicheroObjetoMapa();
	}
	
	public static void leerFichero(String rutaFichero){
		List<String> coleccionLineas = new ArrayList<>();
		try (Scanner in = new Scanner(
				new File (rutaFichero));)
		{
			in.nextLine();  //elimino la leyenda csv
			while (in.hasNextLine())
				coleccionLineas.add(in.nextLine());
			rellenarDatosMapa(coleccionLineas);
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		
	}
	
	public static void rellenarDatosMapa(List<String> coleccionLineas){
		
		for(String linea : coleccionLineas){
			String[] datos = linea.split(",");
			/*String idLocalidad = datos[0];
			double latitudLocalidad = Double.parseDouble(datos[1]);
			double longitudLocalidad = Double.parseDouble(datos[2]);
			double altitudLocalidad = Double.parseDouble(datos[3]);
			String nombreLocalidad = datos[4];
			String urlLocalidad = datos[5];
			int anno = Integer.parseInt(datos[6]);
			Localidad localidad = new Localidad(
					idLocalidad, latitudLocalidad, longitudLocalidad, 
					altitudLocalidad, nombreLocalidad, urlLocalidad, anno);
			//System.out.println(localidad);
			mapa.addLocalidad(localidad);*/
			mapa.addLocalidad(new Localidad(datos[0], Double.parseDouble(datos[1]),
					Double.parseDouble(datos[2]), Double.parseDouble(datos[3]),
					datos[4], datos[5], Integer.parseInt(datos[6])));
		}
	}
	
	public static void escribirEnFicheroObjetoMapa(){
		try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									"ficherosSalida/mapa.dat")));)
		{
			out.writeObject(mapa);
			out.flush();
		} catch (IOException e) {
			System.out.println("Error I/O");
		}
		
	}

}
