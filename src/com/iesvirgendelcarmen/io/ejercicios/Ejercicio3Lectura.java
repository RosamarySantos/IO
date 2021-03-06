package com.iesvirgendelcarmen.io.ejercicios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3Lectura {

	public static void main(String[] args) {
		int[] arrayEnteros = new int[20];
		double valorMedio = 0;
		try (RandomAccessFile in = new RandomAccessFile(
					"ficherosSalida/numeros2.dat", "r");)
		{
			int numeroLeido;
			int contador = 0;
			while (true){
				try{
					numeroLeido = in.readInt();
					arrayEnteros[contador] = numeroLeido;
					contador++;
				}
				catch (EOFException e){
					valorMedio = Ejercicio2.calcularValorMedio(arrayEnteros);
					break;
				}
				
			}
			System.out.printf("El valor medio de los datos del array "
					+ "vale %.2f%n", valorMedio);
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}

	}

}
