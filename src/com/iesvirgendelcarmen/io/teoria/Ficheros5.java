package com.iesvirgendelcarmen.io.teoria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*programa que lee un fichero y escribe su contenido
 * en otro fichero cambiando los saltos de líneas
 * y espacios en blanco por guiones
 */
public class Ficheros5 {

	public static void main(String[] args) {
		//no uso referencias para los objetos File
		try (FileInputStream in = new FileInputStream (new File(
					"ficherosEntrada/dos.txt"));
			 FileOutputStream out = new FileOutputStream(
					 new File("ficherosSalida/salida2.txt"));)
		{
			//comienzo la lectura del fichero
			int c; //recoje los bytes del fichero de entrada
			while ((c = in.read()) != -1){
				if ( c == 10 || c == 32) //si es espacio en blanco o salto de línea
					out.write(45); //escribimos guión
				else
					out.write(c);  //escribimos el caracter
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
