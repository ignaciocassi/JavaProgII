package MisImplementacionesEstaticas;

import MisApis.ColaPrioridadTDA;

/**Costos ColaPrioridadAO:
 * InicializarCola(): Constante
 * AcolarPrioridad(): Lineal (2*n)
 * Desacolar(): Constante
 * ColaVacia(): Constante
 * Primero(): Constante
 */

public class ColaPrioridadAO implements ColaPrioridadTDA {
	
	class Elemento{
		int valor;
		int prioridad;
	}
	
	Elemento[] elementos;
	int indice;
	
	public void InicializarCola() {
		elementos=new Elemento[100];
		indice=0;
	}
	
	public void Acolar(int valor, int prioridad) {
		int j=indice;
		for (; j>0 && elementos[j-1]. prioridad>=prioridad; j--) {
			elementos[j] = elementos[j-1];
		}
		elementos[j]= new Elemento();
		elementos[j].valor=valor;
		elementos[j].prioridad=prioridad;
		indice++;
	}

	public void Desacolar() {
		elementos[indice-1]= null ;
		indice --;
	}

	public int Primero() {
		return elementos[indice-1]. valor;
	}

	public boolean ColaVacia() {
		return (indice==0);
	}

	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}
	
}