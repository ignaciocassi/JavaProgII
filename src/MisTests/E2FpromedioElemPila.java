package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesEstaticas.Pila;
import MisMetodos.metodos;
public class E2FpromedioElemPila {

	public static void main(String[] args) {
		PilaTDA pila=new Pila();
		pila.InicializarPila();
		metodos.llenarPila(pila);
		metodos.mostrarPila(pila);
		int promedio;
		promedio=metodos.promedioElemPila(pila);
		System.out.println("Promedio de los elem de la pila: "+promedio);
		
	}

}
