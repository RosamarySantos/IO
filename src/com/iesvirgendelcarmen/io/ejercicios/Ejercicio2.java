package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.DataInputStream;

public class Ejercicio2 {

	public static void main(String[] args) {
		int[] arrayEnteros = leerArraydeIntdeFicheroBinario(
				"ficherosSalida/numeros.dat");
		//System.out.println(Arrays.toString(arrayEnteros));
		System.out.printf("El valor medio de los datos del array "
				+ "vale %.2f%n", calcularValorMedio(arrayEnteros));
	}

	public static int[] leerArraydeIntdeFicheroBinario(String nombreFichero){
		int[] numeros = new int[20];
		try (DataInputStream in = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(nombreFichero)));) 
		{
			int numero;
			int contador = 0;
			while ( in.available() != 0 ){
				numero = in.readInt();
				//System.out.println(numero);
				numeros[contador] = numero;
				contador++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
		return numeros;
	}
	
	public static double calcularValorMedio(int[] arrayEnteros){
		double suma = 0;
		for (int numero : arrayEnteros)
			suma += numero;
		return 1.0 * suma / arrayEnteros.length;
	}
	
	
	
}
