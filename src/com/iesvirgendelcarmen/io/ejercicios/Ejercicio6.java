package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio6 {

	public static void main(String[] args) {
		// comprobar que entran solo dos argumentos
		if (args.length != 2){
			System.err.println("Error en le nº de argumentos");
			System.exit(1);
		}
		// vamos a crear el path con el argumento 1
		// comprobamos si existe el fichero
		String path = args[0];
		File fileIn = new File(path);
		if (!fileIn.exists()){
			System.err.println("Error, no existe el fichero " + path);
			System.exit(2);
		}
		// comprobamos que el segundo argumento sea un nº
		// y ese nº está comprendido entre 1 y el tamaño del fichero
		int pesoFichero = (int) fileIn.length();
		String argumentosTrozos = args[1];
		int numeroTrozos = Integer.parseInt(argumentosTrozos);
		if ( !argumentosTrozos.matches("[0-9]+") || 
				numeroTrozos > pesoFichero || numeroTrozos < 1){
			System.err.println("Error, en el nº de trozos a dividir el fichero");
			System.exit(3);
		}
		//generar una coleccion de nombre de ficheros de salida
		String[] nombreTrozos = nombrarTrozos(numeroTrozos);
		//comprobamos que se generan correctamente nombre de los trozos
		//System.out.println(Arrays.toString(nombreTrozos));
		//generar una coleccion de tamaños de los trozos
		//Ejemplo [20,20,20,20,20] [20,20,20,20,21] [19,19,19,19,23]
		int[] tamanoTrozos = generarTamanoTrozos(pesoFichero , numeroTrozos);
		//comprobamos que se generan correctamente el tamaño de los trozos
		//System.out.println(Arrays.toString(tamanoTrozos));
		//generamos los trozos (son ficheros de salida)
		generarTrozos(fileIn, nombreTrozos, tamanoTrozos);
	}
	
	public static void generarTrozos(File inFile, String[] nombreTrozos, int[] tamanoTrozos ){
		//preparamos los stream de entrada
		try (BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(inFile));) 
		{
			int c;
			int[] bytesFichero = new int[(int) inFile.length()];
			int contador = 0;
			while ((c = in.read()) != -1){
				//System.out.print((char) c);
				bytesFichero[contador] = c;
				contador++;
			}
			for (int i = 0; i < nombreTrozos.length -1; i++ ){
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(nombreTrozos[i]));
				//rellenamos los trozos con igual tamaño
				for (int j = 0; j < tamanoTrozos[i]; j++){
					out.write(bytesFichero[j + i * tamanoTrozos[i]]);
					out.flush();
				}
				out.close();
			}
			//rellenamos el último
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(
							nombreTrozos[nombreTrozos.length -1]));
			for ( int i = bytesFichero.length -
					tamanoTrozos[tamanoTrozos.length -1];
					i < bytesFichero.length ; i ++) {
				out.write(i);
				out.flush();
			}
			out.close();
				
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
	}
	
	public static int[] generarTamanoTrozos(int pesoFichero, int numeroTrozos){
		int[] tamanoTrozos = new int[numeroTrozos];
		int tamanoNormal = pesoFichero / numeroTrozos ;
		int tamanoUltimo = pesoFichero - tamanoNormal * (numeroTrozos -1);
		for (int i = 0; i < numeroTrozos -1; i++)
			tamanoTrozos[i] = tamanoNormal;
		tamanoTrozos[numeroTrozos -1] = tamanoUltimo; 
		return tamanoTrozos;
	}
	
	public static String[] nombrarTrozos(int numeroTrozos){
		String[] nombreTrozos = new String[numeroTrozos];
		for (int i = 0; i < numeroTrozos; i++)
			nombreTrozos[i] = "ficherosSalida/trozo" + i + ".txt";
		return nombreTrozos;
	}

}
