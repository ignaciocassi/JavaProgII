package MisImplementacionesEstaticas;

import MisApis.ColaPrioridadTDA;

/**Costos ColaPrioridadDA:
 * InicializarCola(): Constante
 * Acolar(): Lineal (2*n)
 * Desacolar(): Constante
 * ColaVacia(): Constante
 * Primero(): Constante
 */

public class ColaPrioridad implements ColaPrioridadTDA {

	int[] valores;
	int[] prioridades;
	int indice;
	
	public void InicializarCola() {
		indice=0;
		valores=new int[100];
		prioridades=new int[100];
	}

	public void Acolar(int valor, int prioridad) {
		int j = indice;
		for ( ; j>0 && prioridades[j-1]>= prioridad; j-- ){
			valores[j] = valores[j-1];
			prioridades[j] = prioridades[j-1];
		}
		valores[j] = valor;
		prioridades[j] = prioridad;
		indice++;
	}

	public void Desacolar() {
		indice--;
	}

	public int Primero() {
		return valores[indice-1];
	}

	public boolean ColaVacia() {
		return (indice==0);
	}

	public int Prioridad() {
		return prioridades[indice-1];
	}

}
