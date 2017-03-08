package com.iesvirgendelcarmen.io.teoria;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*vamos a leer un fichero, volcamos los datos a un fichero de salida
 * y lo hacemos primero sin usar un buffer y posteriormente usamos
 * buffer, uno para la entrada y otro para la salida
 * Vamos a analizar el tiempo de ejucución
 */
public class Ficheros6 {

	public static void main(String[] args) {
		//Usando buffer de entrada y otro de salida
		// Marcamos un tiempo inicial, llamado inicialConBuffer
		long inicialConBuffer = System.currentTimeMillis();
		try (BufferedInputStream in = new BufferedInputStream(
					new FileInputStream("ficherosEntrada/textoGrande.txt"));
			 BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(
							"ficherosSalida/textoGrandeConBuffer.txt"));)
		{ //leemos el fichero
			int c; //donde leemos los bytes
			while ((c = in.read()) != -1)
				//System.out.print((char)c);
				out.write(c);
				out.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No puedo leer/escribir el fichero");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error IO");
		}
		long finalConBuffer = System.currentTimeMillis();
		long tiempoEjecucionBuffer = finalConBuffer - inicialConBuffer;
		System.out.printf("Terminada IO con buffer en %d milisegundos%n", 
				tiempoEjecucionBuffer);
		//***********************************************************
		//Sin usar un buffer de entrada ni de salida
				// Marcamos un tiempo inicial, llamado inicialSinBuffer
				long inicialSinnBuffer = System.currentTimeMillis();
				try (FileInputStream in = new FileInputStream(
						"ficherosEntrada/textoGrande.txt");
						FileOutputStream out = new FileOutputStream(
							"ficherosSalida/textoGrandeSinBuffer.txt");)
				{ //leemos el fichero
					int c; //donde leemos los bytes
					while ((c = in.read()) != -1)
						//System.out.print((char)c);
						out.write(c);
						out.flush();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("No puedo leer/escribir el fichero");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error IO");
				}
				long finalSinBuffer = System.currentTimeMillis();
				long tiempoEjecucionSinBuffer = finalSinBuffer - inicialSinnBuffer;
				System.out.printf("Terminada IO con buffer en %d milisegundos%n", 
						tiempoEjecucionSinBuffer);

	}

}
