package MisImplementacionesDinamicas;

import MisApis.ColaPrioridadTDA;

/**Costos ColaPrioridadLD:
 * InicializarCola(): Constante
 * Acolar(): Lineal (n)
 * Desacolar(): Constante
 * Primero(): Constante
 * ColaVacia(): Constante
 * Prioridad(): Constante
 * @author Nacho
 *
 */

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
		NodoPrioridad nuevoNodo=new NodoPrioridad();                                  //Crea el nuevo nodo
		nuevoNodo.valor=valor;
		nuevoNodo.prioridad=prioridad;
		if (mayorPrioridad==null || nuevoNodo.prioridad>mayorPrioridad.prioridad) {   //Si está vacía o tiene mayor prioridad que el primero (mayorPrioridad), lo coloca primero
			nuevoNodo.sigNodo=mayorPrioridad;
			mayorPrioridad=nuevoNodo; 
		} else {                                                                      //Si no está vacía (mayorPrioridad!=null) 
			NodoPrioridad nodoAux=new NodoPrioridad();                                //Usa un nodoAux, que copia al mayorPrioridad, como índice
			nodoAux=mayorPrioridad;
			while(nodoAux.sigNodo!=null && nodoAux.sigNodo.prioridad>=prioridad) {    //Mientras que el sigNodo de aux no sea null(no sea el ultimo) y la prioridad del sigNodo de aux sea mayor >= a la prioridad
				nodoAux=nodoAux.sigNodo;                                              //a agregar, nodoAux pasa a ser el sigNodo
			}                                                                         //avanza hasta que nodoAux.sigNodo.prioridad (el siguiente a nodoAux) sea menor que la prioridad a agregar. nodoAux
			nuevoNodo.sigNodo=nodoAux.sigNodo;                                        
			nodoAux.sigNodo=nuevoNodo;
		}
	}

	public void Desacolar() {
		mayorPrioridad=mayorPrioridad.sigNodo;
	}

	public int Primero() {
		return mayorPrioridad.valor;
	}

	public boolean ColaVacia() {
		return (mayorPrioridad==null);
	}

	public int Prioridad() {
		return mayorPrioridad.prioridad;
	}

}
