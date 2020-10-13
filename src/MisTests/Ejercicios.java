package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesEstaticas.Pila;
import MisMetodos.metodos;

public class Ejercicios {

	public static void main(String[] args) {
		PilaTDA pila=new Pila();
		pila.InicializarPila();
		ejecutarLlenarPila(pila);    //Llena la pila con 10 elementos
		ejecutarMostrarPila(pila);
	}
	
	public static PilaTDA ejecutarLlenarPila(PilaTDA pila) {
		metodos.llenarPila(pila);
		return pila;
	}
	
	public static void ejecutarMostrarPila(PilaTDA p) {
		metodos m = new metodos();
		m.mostrarPila(p);
	}
}
