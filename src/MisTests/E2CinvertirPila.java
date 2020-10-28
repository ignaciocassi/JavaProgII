package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesDinamicas.Pila;
import MisMetodos.metodos;

public class E2CinvertirPila {

	public static void main(String[] args) {
		PilaTDA pila=new Pila();
		pila.InicializarPila();
		
		PilaTDA pilaInvertida=new Pila();
		pilaInvertida.InicializarPila();
		
		pila.Apilar(1);
		pila.Apilar(2);
		pila.Apilar(3);
		
		System.out.println("Pila original: ");
		metodos.mostrarPila(pila);
		
		System.out.println("Pila invertida: ");
		pila=metodos.invertirPila(pila);
		metodos.mostrarPila(pilaInvertida);

	}

}
