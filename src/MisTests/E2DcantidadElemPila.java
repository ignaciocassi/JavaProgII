package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesEstaticas.Pila;
import MisMetodos.metodos;

public class E2DcantidadElemPila {
	
	public static void main(String[] args) {
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		metodos.llenarPila(pila); //Carga la pila con 10 elementos
		metodos.mostrarPila(pila); //Muestra la pila
		System.out.println("Cantidad de elementos de la pila: "+metodos.cantidadElemPila(pila));
	}
}
