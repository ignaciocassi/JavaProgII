package MisTests;

import MisApis.ConjuntoTDA;
import MisApis.PilaTDA;
import MisImplementacionesDinamicas.Conjunto;
import MisImplementacionesDinamicas.Pila;
import MisMetodos.metodos;

public class TP3 {

	public static void main(String[] args) {
		//Ejecutar1aPilaCapicua();
		//EjecutarEliminarRepetidosPila();
		//EjecutarPartirPilaEnDos();
		EjecutarObtenerRepetidosPila();
	}

	private static void EjecutarObtenerRepetidosPila() {
		PilaTDA P=new Pila();
		P.InicializarPila();
		
		ConjuntoTDA repetidos=new Conjunto();
		repetidos.inicializarConjunto();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(4);
		P.Apilar(5);
		
		repetidos=metodos.obtenerRepetidosPila(P);
		metodos.mostrarConjunto(repetidos);
	}

	private static void EjecutarPartirPilaEnDos() {
		PilaTDA P=new Pila();
		PilaTDA M1=new Pila();
		PilaTDA M2=new Pila();
		P.InicializarPila();
		M1.InicializarPila();
		M2.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(5);
		P.Apilar(6);
		
		metodos.partirPilaEnDos(P, M1, M2);
		
		System.out.println("Pila P: ");
		metodos.mostrarPila(P);
		
		System.out.println("Pila M1: ");
		metodos.mostrarPila(M1);
		
		System.out.println("Pila M2: ");
		metodos.mostrarPila(M2);
	}

	private static void Ejecutar1aPilaCapicua() {
		PilaTDA P = new Pila();
		P.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(1);
		
		boolean capicua=metodos.pilaCapicua(P);
		
		if (capicua==true) {
			System.out.println("La pila es capicúa.");
		} else {
			System.out.println("La pila no es capicúa.");
		}
		
	}
	
	private static void EjecutarEliminarRepetidosPila() {
		PilaTDA P=new Pila();
		P.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(5);
		
		System.out.println("Pila original: ");
		metodos.mostrarPila(P);
		
		
		metodos.eliminarRepetidosPila(P);
		System.out.println("Pila sin repetidos: ");
		metodos.mostrarPila(P);
	}
	
}
