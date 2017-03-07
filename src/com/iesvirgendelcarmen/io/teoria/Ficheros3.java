package com.iesvirgendelcarmen.io.teoria;
/*Programa que lee un archivo byte a bye
 * y  muestrea en consola el valor del los bytes
 * leidos en decimal, hexadecimal y caracter
 * Usamos excepciones con bloques try-catch-finally
 * Este último para cerrar el flujo del FileInputStream
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ficheros3 {

	public static void main(String[] args) {
		//crear el descriptor al fichero
		File inFile = new File("ficherosEntrada/dos.txt");
		//crear el stream de entrada
		FileInputStream in = null;
		try {  //trabajo de forma clásica
			in = new FileInputStream(inFile);
			int c, contador = 0; //esta variable recoje los bytes del fichero
			while ((c = in.read()) != -1){
				System.out.println("Valor en decimal " + c);
				System.out.printf("Valor en hexadecimal %x%n",c);
				System.out.println("Caracter " + (char)c);
				contador++;
			}
			System.out.println("Tamaño del fichero contado"
					+ " byte a byte: " + contador);
			System.out.println("Usando método de la clase File " +
					inFile.length());
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero");
		} catch (IOException e) {
			System.out.println("Error en lectura del fichero");
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
