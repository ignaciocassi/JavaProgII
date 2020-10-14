package MisImplementacionesDinamicas;

import MisApis.PilaTDA;

public class Pila implements PilaTDA {
	
	Nodo primero;

	class Nodo {
		int valor;
		Nodo sigNodo;
	}
	
	public void InicializarPila() {
		primero=null;
	}

	public void Apilar(int valor) {
		Nodo nuevoNodo=new Nodo();
		nuevoNodo.valor=valor;
		nuevoNodo.sigNodo=primero;
		primero=nuevoNodo;
	}

	public void Desapilar() {
		primero=primero.sigNodo;
	}

	public boolean PilaVacia() {
		return (primero==null);
	}

	public int Tope() {
		return primero.valor;
	}

}
