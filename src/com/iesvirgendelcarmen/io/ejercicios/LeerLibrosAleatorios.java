package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LeerLibrosAleatorios {

	public static void main(String[] args) {
		try (ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									"ficherosSalida/libros.dat")));)
		{
			@SuppressWarnings("unchecked")
			List<Libro> librosAleatorios = 
					(List<Libro>) in.readObject();
			System.out.println(librosAleatorios);
		} catch (FileNotFoundException e) {
			System.out.println("Error en el archivo");
		} catch (IOException e) {
			System.out.println("Error I/O");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en clase");

		}

	}

}
