package com.iesvirgendelcarmen.io.ejercicios;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio1 {

	public static void main(String[] args) {
		//vamos a llamar a un método que va a devolver 
		//un array de 20 int generados de forma aleatoria
		int[] arrayNumeros  = generar20NumerosAleatoriosEntre20y40();
		System.out.println(Arrays.toString(arrayNumeros));
		/*for (int numero : arrayNumeros)
			System.out.println(numero);*/
		generarFicheroBinario(arrayNumeros);
		generarFicheroTexto(arrayNumeros);
	}
	
	
	public static int[] generar20NumerosAleatoriosEntre20y40(){
		int[] numerosAleatorios = new int[20];
		for (int i = 0; i < 20; i++){
			//generamos nº desde el 20 al 40 inclusive
			int numero = (int) (Math.random() * 21) + 20 ;
			numerosAleatorios[i] = numero;
		}
		return numerosAleatorios;
	}
	
	
	public static void generarFicheroBinario(int[] arrayNumeros){
		try (DataOutputStream out =  new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(
							"ficherosSalida/numeros.dat")));)
		{
			for (int numero : arrayNumeros){
				out.writeInt(numero);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con el fichero");
		} catch (IOException e1) {
			System.out.println("Problemas I/O");
		}
	}
	
	public static void generarFicheroTexto(int[] arrayNumeros){
		try (BufferedWriter out = new BufferedWriter(
					new FileWriter(
							"ficherosSalida/numeros.txt"));)
		{
			String cadenaSalida = "";
			for (int numero : arrayNumeros){
				cadenaSalida += numero + "-";
			}
			out.write(cadenaSalida.substring(0, cadenaSalida.length() -1));
			out.flush();
		} catch (IOException e) {
			System.out.println("Problemas I/O");
		}
	}
	
	
	
	
	
	
	
}
