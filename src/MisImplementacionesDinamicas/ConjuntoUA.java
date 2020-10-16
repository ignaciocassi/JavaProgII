package MisImplementacionesDinamicas;

import MisApis.ConjuntoTDA;
import java.util.Scanner;

public class ConjuntoUA implements ConjuntoTDA {
	
	Nodo primerNodo;
	
	class Nodo {
		int presente;
		Nodo sigNodo;
	}

	public void inicializarConjunto() {
		primerNodo=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingrese el máximo para el Conj universo acotado: ");
		int N=sc.nextInt();
		sc.close();
	}

	public boolean conjuntoVacio() {
		return false;
	}

	public void agregar(int valor) {
		Nodo nodoActual=new Nodo();
		nodoActual=primerNodo;
		int i=0;
		for ( ; i<valor; i++) {
			nodoActual=nodoActual.sigNodo;
			i++;
		}
		if (valor==i && valor>=0) {
			nodoActual.presente=1;
		}
	}

	public int elegir() {
		return primerNodo.presente;
	}

	public void sacar(int valor) {
		Nodo nodoActual=new Nodo();
		nodoActual=primerNodo;
		int i=0;
		for ( ; i<valor; i++) {
			nodoActual=nodoActual.sigNodo;
			i++;
		}
		if (valor==i && valor>=0) {
			nodoActual.presente=0;
		}
	}

	public boolean pertenece(int valor) {
		
		return false;
	}

}
