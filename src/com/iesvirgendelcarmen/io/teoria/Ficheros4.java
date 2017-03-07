package com.iesvirgendelcarmen.io.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*Vamos a escribir en un fichero los bytes de
 * un String. Volcamos bytes a bytes los caracteres
 * de dicho String
 */
public class Ficheros4 {

	public static void main(String[] args) {
		//Cadena a volcar en el fichero de texto
		String cadena = "\nEsto es una cadena\nAñado caracter "
				+ "con acento á Ó";
		
		//convertirmos la cadena a un array de bytes byte[]
		//ya que el método write de FileInputStrean está definido
		//para write(byte[])
		byte[] bytesString = cadena.getBytes();
		System.out.println(Arrays.toString(bytesString));
		//descriptor para el fichero de salida
		File outFile = new File("ficherosSalida/salida1.txt");
		//creamos el flujo de salida
		//con la opción true, añade al final del fichero
		//si es false o no existe, machaca el contenido
		//del fichero
		try (FileOutputStream out = new FileOutputStream(outFile, true);){
			out.write(72); //H
			out.write(79); //O
			out.write(76); //L
			out.write(65); //A
			out.write(bytesString);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
