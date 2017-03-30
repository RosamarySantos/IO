package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio5B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mapa mapa = leerFicheroMapa("ficherosSalida/mapa.dat");
		System.out.println("Introduce el nombre de una localidad:");
		Scanner in = new Scanner(System.in);
		String nombreLocalidad = in.nextLine();
		double[] posiciones = mapa.obtenerPosicion(nombreLocalidad.toUpperCase().trim());
		System.out.println(Arrays.toString(posiciones));
	}
	
	public static Mapa leerFicheroMapa(String rutaFichero){
		Mapa mapa = null;
		try (ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(rutaFichero)));)
		{
			mapa = (Mapa) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Error en lectura del fichero");
		} catch (IOException e) {
			System.out.println("Error I/O");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en clases");
		}
		return mapa;
	}
}
