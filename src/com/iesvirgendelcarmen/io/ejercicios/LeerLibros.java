package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LeerLibros {

	public static void main(String[] args) {
		List<Libro> listaLibros = new ArrayList<>();
		
		listaLibros = leerCSV("ficherosEntrada/carpeta1/Libros.csv");
		if (listaLibros.size() > 10) {
			generarFicheroBinario(
					generarLista10LibrosAleatoriamente(listaLibros));
		}
		else
			generarFicheroBinario(listaLibros);
	}
	public static List<Libro> leerCSV(String rutaCSV){
		List<Libro> listaLibros = new ArrayList<>();
		List<String> coleccionLineas = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(rutaCSV), "iso-8859-1"));)
		{
			String linea;
			while ((linea = in.readLine()) != null)
				coleccionLineas.add(linea);
			coleccionLineas.remove(0); //quitamos la leyenda del CSV
			listaLibros = parsearColeccionLineas(coleccionLineas);
		} catch (UnsupportedEncodingException e) {
			System.out.println("No soportada codificación");
		} catch (FileNotFoundException e) {
			System.out.println("Fichero  no encontrado");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
		return listaLibros;
	}
	
	public static List<Libro> parsearColeccionLineas(List<String> coleccionLineas){
		List<Libro> listaLibros = new ArrayList<>();
		for (String linea : coleccionLineas){
			String[] campos = linea.split(";");
			 listaLibros.add(new Libro(campos[0],campos[2], Double.parseDouble(
							campos[10].substring(2).replace(',','.'))));
			
		}
		return listaLibros;
	}
	
	public static List<Libro> generarLista10LibrosAleatoriamente(
			List<Libro> listaLibros) {
		List<Libro> lista10Libros = new ArrayList<>();
		for (int i = 0; i < 10; i++ ){
			int posicionAleatoria = (int) (Math.random() *
					listaLibros.size());
			lista10Libros.add(listaLibros.get(posicionAleatoria));
			listaLibros.remove(posicionAleatoria);
		}
		return lista10Libros;
	}
	
	public static void generarFicheroBinario(List<Libro> listaLibros){
		//usamos un ObjectOutputStream pues vamos a guardar un objeto 
		//tipo List
		try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream (
							new FileOutputStream(
									"ficherosSalida/libros.dat")));)
		{
			out.writeObject(listaLibros);
			out.flush();
		} catch (IOException e) {
			System.out.println("Error I/O");
		}
	}
	
	
}
