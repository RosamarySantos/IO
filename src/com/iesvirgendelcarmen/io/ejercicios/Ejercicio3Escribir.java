package com.iesvirgendelcarmen.io.ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Ejercicio3Escribir {
	public static void main(String[] args) {
		int[] arrayNumeros  = 
				Ejercicio1.generar20NumerosAleatoriosEntre20y40();
		System.out.println(Arrays.toString(arrayNumeros));
		try (RandomAccessFile out = new RandomAccessFile(
					"ficherosSalida/numeros2.dat", "rw");)
		{
			for (int numero : arrayNumeros)
				out.writeInt(numero);
				
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
	}
}
