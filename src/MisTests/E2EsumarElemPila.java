package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesEstaticas.Pila;
import MisMetodos.metodos;

public class E2EsumarElemPila {

	public static void main(String[] args) {
		PilaTDA pila=new Pila();
		pila.InicializarPila();
		metodos.llenarPila(pila);
		metodos.mostrarPila(pila);
		System.out.println("Suma de los elementos de la pila: "+metodos.sumarElemPila(pila));
	}
}
