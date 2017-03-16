package com.iesvirgendelcarmen.io.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* programa para probar la clase Scanner
 * usando ficheros de entrada
 */
public class Ficheros16 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner (new File(
					"ficherosEntrada/personas.txt"));)
		{
			in.useDelimiter("(\\s*,\\s*)|(\\n)");  //la coma
			String nombre =  in.next();
			int edad = 		 in.nextInt();
			boolean hombre = in.nextBoolean();
			System.out.printf("%s---%d---%b%n",nombre, edad, hombre);
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

	}

}
