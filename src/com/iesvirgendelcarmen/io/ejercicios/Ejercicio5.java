package com.iesvirgendelcarmen.io.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(
					new File ("ficherosEntrada/geografia.csv"));){
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

	}

}
