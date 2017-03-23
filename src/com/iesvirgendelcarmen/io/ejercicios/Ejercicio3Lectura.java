package com.iesvirgendelcarmen.io.ejercicios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3Lectura {

	public static void main(String[] args) {
		try (RandomAccessFile in = new RandomAccessFile(
					"ficherosSalida/numeros2.dat", "r");)
		{
			int numeroLeido;
			while (true){
				try{
					numeroLeido = in.readInt();
					System.out.println(numeroLeido);
				}
				catch (EOFException e){
					System.out.println("Fin del fichero");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}

	}

}
