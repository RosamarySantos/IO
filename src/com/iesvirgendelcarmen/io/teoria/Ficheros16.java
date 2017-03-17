package com.iesvirgendelcarmen.io.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* programa para probar la clase Scanner
 * usando ficheros de entrada
 */
public class Ficheros16 {

	public static void main(String[] args) {
		//Creo una lista dinámica para guardar objetos Persona
		List<Persona> listaPersonas = new ArrayList<>(); //vacía
		try (Scanner in = new Scanner (new File(
					"ficherosEntrada/personas.txt"));)
		{
			in.useDelimiter("(\\s*,\\s*)|(\\n)");  //la coma
			while (in.hasNext())
				listaPersonas.add(new Persona( in.next(),
						in.nextInt(),in.nextBoolean()));
				
			System.out.println(listaPersonas);
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

	}

}
