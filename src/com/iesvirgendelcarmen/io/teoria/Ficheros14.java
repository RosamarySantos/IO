package com.iesvirgendelcarmen.io.teoria;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* programa donde vamos a trabajar con ficheros
 * con distitinta codificación, utf y iso-8856-1
 */
public class Ficheros14 {
//new FileReader("ficherosEntrada/unoISO.txt"));)
	public static void main(String[] args) {
		//vamos a leer ficheros con bufferedreader
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
						  "ficherosEntrada/unoISO.txt"),"iso-8859-1"));
		)		
		{
			String linea;
			while ((linea = in.readLine()) != null)
				System.out.println(linea);
		} catch (FileNotFoundException e) {
			System.out.println("Error con el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}

	}

}
