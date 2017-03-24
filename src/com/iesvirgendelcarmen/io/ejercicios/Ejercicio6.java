package com.iesvirgendelcarmen.io.ejercicios;

import java.io.File;

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
		if ( !argumentosTrozos.matches("[1-9]+") || 
				numeroTrozos > pesoFichero){
			System.err.println("Error, en el nº de trozos a dividir el fichero");
			System.exit(3);
		}
		//generar una coleccion de nombre de ficheros de salida
		String[] nombreTrozos = nombrarTrozos(numeroTrozos);
		//generar una coleccion de tamaños de los trozos
		//Ejemplo [20,20,20,20,20] [20,20,20,20,21] [19,19,19,19,23]
		
	}
	
	public static String[] nombrarTrozos(int numeroTrozos){
		String[] nombreTrozos = new String[numeroTrozos];
		for (int i = 1; i <= numeroTrozos; i++)
			nombreTrozos[i] = "ficherosSalida/trozo" + i + ".txt";
		return nombreTrozos;
	}

}
