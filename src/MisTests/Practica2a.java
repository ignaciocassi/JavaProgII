package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesEstaticas.Pila;

public class Practica2a {

	public static void main(String[] args) {
		PilaTDA p1 = new Pila();
		PilaTDA p2 = new Pila();
		
		p1.InicializarPila();
		p2.InicializarPila();
		
		p1.Apilar(1);
		p1.Apilar(2);
		p1.Apilar(3);
		
		System.out.println("El tope de la pila p1 es: "+p1.Tope());
		
		while (!p1.PilaVacia()) {
			p2.Apilar(p1.Tope());
			System.out.println("Tope p1: "+p1.Tope());
			p1.Desapilar();
		}
		
		if (!p1.PilaVacia()) {
			System.out.println("Hay elementos");
		}
		
		while (!p2.PilaVacia()) {
			System.out.println("Tope p2: "+p2.Tope());
			p2.Desapilar();
		}
		
		if (p2.PilaVacia()) {
			System.out.println("No hay elementos en p2.");
		}
	}
}
