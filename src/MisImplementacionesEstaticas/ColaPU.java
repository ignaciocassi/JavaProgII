package MisImplementacionesEstaticas;

import MisApis.ColaTDA;

/**Costos ColaPU:
 * InicializarCola(): Constante
 * Acolar(): Lineal
 * Desacolar(): Constante
 * ColaVacia(): Constante
 * Primero(): Constante
 */

public class ColaPU implements ColaTDA {
	
	int[] arreglo;
	int indice;

	public void InicializarCola() {
		arreglo=new int[100];
		indice=0;
	}

	public void Acolar(int valor) {
		for(int i=indice-1;i>=0;i--) {
			arreglo[i]=arreglo[i-1];
		}
		arreglo[0]=valor;
		indice++;
	}

	public void Desacolar() {
		indice--;
	}

	public boolean ColaVacia() {
		return false;
	}

	public int Primero() {
		return 0;
	}

}
