package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesDinamicas.Pila;
import MisMetodos.metodos;

public class E2BcopiarPila {

	public static void main(String[] args) {
		PilaTDA pila=new Pila();
		pila.InicializarPila();
		
		pila.Apilar(1);
		pila.Apilar(2);
		pila.Apilar(3);
		
		System.out.println("Pila original: ");
		metodos.mostrarPila(pila);
		
		PilaTDA pilaCopia=new Pila();
		pilaCopia.InicializarPila();
		
		System.out.println("Pila copia: ");
		metodos.copiarPila(pila, pilaCopia);
		metodos.mostrarPila(pilaCopia);

	}

}
