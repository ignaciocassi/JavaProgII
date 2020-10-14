package MisImplementacionesDinamicas;

import MisApis.ColaTDA;

public class Cola implements ColaTDA {
	
	Nodo primero;
	Nodo ultimo;
	
	class Nodo {
		int valor;
		Nodo sigNodo;
	}

	public void InicializarCola() {
		primero=null;
		ultimo=null;
	}

	public void Acolar(int valor) {
		Nodo nuevoNodo= new Nodo();
		nuevoNodo.valor=valor;
		nuevoNodo.sigNodo=null;
		if (ultimo!=null) {
			ultimo.sigNodo=nuevoNodo;
		}
		ultimo=nuevoNodo;
		if (primero==null) {
			primero=ultimo;
		}
	}

	public void Desacolar() {
		primero=primero.sigNodo;
		if (primero==null) {
			ultimo=null;
		}
	}

	public boolean ColaVacia() {
		return (ultimo==null);
	}


	public int Primero() {
		return primero.valor;
	}

}
