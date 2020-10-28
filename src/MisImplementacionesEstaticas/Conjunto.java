package MisImplementacionesEstaticas;

import MisApis.ConjuntoTDA;

/** Costos Conjunto:
 * InicializarConjunto(): Constante
 * Agregar(): Lineal
 * Sacar(): Lineal
 * Pertenece(): Lineal
 * Elegir(): Constante
 * @author Nacho
 *
 */

public class Conjunto implements ConjuntoTDA {
	
	int[] arreglo;
	int indice;
	
	public void inicializarConjunto() {
		arreglo=new int[100];
		indice=0;
	}

	//Precond: El conjunto debe estar inicializado
	public boolean conjuntoVacio() {
		return (indice==0);
	}

	//Precond: El conjunto debe estar inicializado
	public void agregar(int valor) {
		if(!this.pertenece(valor)) {
			arreglo[indice]=valor;
			indice++;
		}
	}

	//Precond: El conjunto debe estar inicializado y no debe estar vacío
	public int elegir() {
		return arreglo[indice-1];
	}

	//Precond: El conjunto debe estar inicializado
	public void sacar(int valor) {
		int i=0;
		while(i<indice && arreglo[i]!=valor) {
			i++;
		}
		if (i<indice) {
			arreglo[i]=arreglo[indice-1];
			indice--;
		}
	}

	//Precond: El conjunto debe estar inicializado
	public boolean pertenece(int valor) {
		int i=0;
		while(i<indice && arreglo[i]!=valor) {
			i++;
		}
		return (i<indice);
	}

}
