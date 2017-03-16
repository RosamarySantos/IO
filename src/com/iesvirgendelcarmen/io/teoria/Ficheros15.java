package com.iesvirgendelcarmen.io.teoria;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/* programa que va escribir el fichero de salida
 * con una codificación diferente a la que usa
 * el sistema operativo
 */
public class Ficheros15 {

	public static void main(String[] args) {
		String mensaje = "Línea uno con acentos àáÁ";
		mensaje += "\nOtra línea con eñes\n";
		
		try (BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(
					new FileOutputStream(
							"ficherosSalida/ficheroISO.txt"),
								"iso-8859-1"));)
		{
			out.write(mensaje);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Problemas de codificación");
		} catch (FileNotFoundException e) {
			System.out.println("Problema en el fichero");
		} catch (IOException e1) {
			System.out.println("Problema I/O");
		}

	}

}
