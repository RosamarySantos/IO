package com.iesvirgendelcarmen.io.ejercicios;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Ejercicio3LecturaV2 {
	public static void main(String[] args) {
		
		
		try (RandomAccessFile in = new RandomAccessFile(
					"ficherosSalida/numeros2.dat", "r");)
		{
			int numeroEnteros = (int) (in.length() / 4);
			int[] arrayEnteros = new int[numeroEnteros];
			int contador = 0;
			int numeroLeido;
			while (contador < numeroEnteros){
				numeroLeido = in.readInt();
				arrayEnteros[contador] = numeroLeido;
				contador ++;
			}
			
			
			System.out.printf("El valor medio de los datos del array "
					+ "vale %.2f%n",
					Ejercicio2.calcularValorMedio(arrayEnteros));
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
	
	}

}

