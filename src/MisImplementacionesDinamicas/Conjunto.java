package MisImplementacionesDinamicas;

import MisApis.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	//Tamaño máximo no acotado
	
	Nodo c;

	class Nodo {
		int valor;
		Nodo sigNodo;
	}
	
	public void inicializarConjunto() {
		c=null;
	}

	public boolean conjuntoVacio() {
		return (c==null);
	}

	public void agregar(int valor) {
		if (!this.pertenece(valor)) {     //si el valor no pertenece
			Nodo nodoNuevo=new Nodo();    //crea un nuevo nodo
			nodoNuevo.valor=valor;        //le asigna el valor
			nodoNuevo.sigNodo=c;          //el siguiente al nuevo nodo es c(primero)
			c=nodoNuevo;                  //c pasa a ser el nuevo nodo
		}
	}

	public int elegir() {
		return c.valor;
	}

	public void sacar(int valor) {
		if (c!=null) {                     //si el conj no está vacío
			if (c.valor==valor) {          //si el primero es el nodo a sacar
				 c=c.sigNodo;              //el c(primero) pasa a ser el siguiente de c
			} else {                       //si no es el primero
				 Nodo aux=c;                                                  //copia el nodo c en aux
				 while (aux.sigNodo!=null && aux.sigNodo.valor!=valor) {      //mientras que el siguiente nodo del aux no sea null(no sea el ultimo) y el valor del siguiente nodo no se ael buscado
					 aux=aux.sigNodo;                                         //aux pasa a ser el siguiente nodo
				 }                                                            //termina el bucle, o llegó al fin (aux=null) o encontro el valor en el siguiente nodo del aux
				 if (aux.sigNodo!=null) {                                     //si no llegó al final (aux=null), es decir que lo encontró (el valor esta en el sigNodo del aux)
					 aux.sigNodo=aux.sigNodo.sigNodo;                         //el siguiente nodo del aux, es el siguiente de el siguiente
				 } 
			}
		}
	}

	public boolean pertenece(int valor) {
		Nodo aux=c;
		while((aux!=null) && (aux.valor!=valor)) {
			aux=aux.sigNodo;
		}
		return (aux!=null);
	}

}
