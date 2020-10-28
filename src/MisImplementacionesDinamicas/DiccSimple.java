package MisImplementacionesDinamicas;

import MisApis.ConjuntoTDA;
import MisApis.DiccSimpleTDA;

/** Costos DiccSimpleL:
 * InicializarDiccionario(): Constante
 * Agregar(): Lineal
 * Eliminar(): Lineal
 * Recuperar(): Lineal
 * Claves(): Lineal
 * @author Nacho
 *
 */

public class DiccSimple implements DiccSimpleTDA {
	
	NodoClave origen;
	
	class NodoClave {
		int clave;
		int valor;
		NodoClave sigNodo;
	}

	public void inicializarDiccionario() {
		origen=null;
	}

	public void agregar(int clave, int valor) {
		NodoClave nodoActual=Clave2NodoClave(clave);             //Busca el nodo con la clave
		if (nodoActual==null) {                                  //si no lo encontró, lo crea
			nodoActual=new NodoClave();
			nodoActual.clave=clave;
			nodoActual.sigNodo=origen;
			origen=nodoActual;                                     //Origen pasa a ser el nuevoNodo
		}
		nodoActual.valor=valor;                                   //Si existe la clave en un nodo, reemplaza su valor por el nuevo
	}

	private NodoClave Clave2NodoClave(int clave) {                //Recibe una clave, busca el nodo que contenga la clave, si la encuentra la devuelve, sino devuelve null
		NodoClave nodoAux=origen;
		while (nodoAux!=null && nodoAux.clave!=clave) {
			nodoAux=nodoAux.sigNodo;
		}
		return nodoAux;
	}

	public void eliminar(int clave) {
		if (origen!=null) {                                        //Si no esta vacío
			if (origen.clave==clave) {                             //Si es el primero
				origen=origen.sigNodo;                             //Origen pasa a ser el sigNodo de origen
			} else {                                               //Si no es el primero
				NodoClave nodoAux=origen;                          //Usa un nodoAux copiando a origen
				while(nodoAux.sigNodo!=null && nodoAux.sigNodo.clave!=clave) {
					nodoAux=nodoAux.sigNodo;
				}
				if(nodoAux.sigNodo!=null) {                        //Si el sigNodo de nodoAux no es null (nodoAux no es el último), encontró el nodo con la clave buscada
					nodoAux.sigNodo=nodoAux.sigNodo.sigNodo;       //El sigNodo del nodoAux (que tiene la clave) pasa a ser el sigNodo del sigNodo
				}
			}
		}
	}

	public int recuperar(int clave) {
		NodoClave nodoAux=Clave2NodoClave(clave);
		return nodoAux.valor;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA claves=new Conjunto();
		claves.inicializarConjunto();
		NodoClave nodoAux=origen;
		while(nodoAux!=null) {
			claves.agregar(nodoAux.clave);
			nodoAux=nodoAux.sigNodo;
		}
		return claves;
	}

}
