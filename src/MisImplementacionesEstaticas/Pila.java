/**
 * 
 */
package MisImplementacionesEstaticas;

import MisApis.PilaTDA;

/**
 * @author Nacho
 *
 */
public class Pila implements PilaTDA {
	
	int [] arreglo;
	int indice;
	
	public void InicializarPila() {
		arreglo=new int[100];
		indice=0;
	}

	public void Apilar(int x) {
		arreglo[indice]=x;
		indice++;
	}

	public void Desapilar() {
		indice--;
	}

	public boolean PilaVacia() {
		return (indice==0);
	}

	public int Tope() {
		return arreglo[indice-1];
	}

}
