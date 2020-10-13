package MisImplementacionesEstaticas;

import MisApis.ColaTDA;

public class ColaPI implements ColaTDA {
	
	int [] arreglo;
	int indice;
	
	public void InicializarCola() {
		arreglo=new int[100];
		indice=0;
	}

	public void Acolar(int x) {
		arreglo[indice]=x;
		indice++;
	}

	public void Desacolar() {
		for (int i=0; i<indice-1; i++) {
			arreglo[i]=arreglo[i+1];
		}
		indice--;
	}

	public boolean ColaVacia() {
		return (indice==0);
	}
	
	public int Primero() {
		return arreglo[0];
	}

}
