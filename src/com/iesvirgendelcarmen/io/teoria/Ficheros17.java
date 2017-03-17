package com.iesvirgendelcarmen.io.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* programa para probar la clase Scanner
 * usando ficheros de entrada
 * El programa hace igual que Ficheros16.java
 * pero no usa delimitador en el Scanner y
 * lee el fichero línea a línea
 * introducimos el tema de codificación de fichero
 */
public class Ficheros17 {

	public static void main(String[] args) {
		List<Persona> listaPersonas = new ArrayList<>();
		try (Scanner in = new Scanner (new File(
					"ficherosEntrada/personasISO.txt"),
				"iso-8859-1");)
		{
			while (in.hasNextLine()){
				
				String[] trozos = in.nextLine().split(",");
				listaPersonas.add(new Persona(trozos[0].trim(), 
						Integer.parseInt(trozos[1].trim()),
						Boolean.parseBoolean(trozos[2].trim())));
			}
			System.out.println(listaPersonas);
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

	}

}
