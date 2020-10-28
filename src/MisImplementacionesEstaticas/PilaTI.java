package MisImplementacionesEstaticas;

import MisApis.PilaTDA;

/**Costos PilaPI:
 * InicializarPila(): Constante
 * Apilar(): Lineal
 * Desapilar(): Lineal
 * PilaVacia(): Constante
 * Tope(): Constante
 */

public class PilaTI implements PilaTDA {

	int[] arreglo;
	int indice;
	
	public void InicializarPila() {
		arreglo=new int[100];
		indice=0;
	}

	public void Apilar(int valor) {
		for (int i=indice-1;i>=0;i--) {
			arreglo[i+1]=arreglo[i];
		}
		arreglo[0]=valor;
		indice++;
	}

	public void Desapilar() {
		for (int i=0;i<indice;i++) {
			arreglo[i]=arreglo[i+1];
		}
		indice--;
	}

	public boolean PilaVacia() {
		return (indice==0);
	}

	public int Tope() {
		return arreglo[indice-1];
	}


}
