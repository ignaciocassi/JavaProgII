package MisImplementacionesDinamicas;

import MisApis.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	NodoPrioridad mayorPrioridad;
	
	class NodoPrioridad {
		int valor;
		int prioridad;
		NodoPrioridad sigNodo;
	}

	public void InicializarCola() {
		mayorPrioridad=null;
	}

	public void Acolar(int valor, int prioridad) {
		
	}

	public void Desacolar() {

	}

	public int Primero() {
		return 0;
	}

	public boolean ColaVacia() {
		return false;
	}

	public int Prioridad() {
		return 0;
	}

}
