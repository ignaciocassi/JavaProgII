package MisImplementacionesEstaticas;

import MisApis.ConjuntoTDA;

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
