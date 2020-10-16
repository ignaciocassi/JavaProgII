package MisImplementacionesEstaticas;

import java.util.Scanner;

import MisApis.ConjuntoTDA;

public class ConjuntoUA implements ConjuntoTDA {
	
	//Implementación estática de Conjunto Universo Acotado
	
	int[] arreglo;
	int N;

	public void inicializarConjunto() {
		N=solicitarCotaMax();
		arreglo=new int[N];                   //Dimensiona el arreglo a 6 posiciones, representando (0-5)
		for (int i=0;i<N;i++) {              //Recorre el arreglo e inicializa los valores en 0 (vacío)
			arreglo[i]=0;
		}
	}

	public boolean conjuntoVacio() {
		int i=0;
		boolean vacio=true;
		while (i<=N && vacio==true) {
			if (arreglo[i]==1) {
				vacio=false;
			}
			i++;
		}
		return vacio;
	}

	public void agregar(int valor) {
		if (valor<=N && valor>=0) {
			int i=0;
			while (i!=valor) {
				i++;
			}
			arreglo[i]=1;
		}
	}

	public int elegir() {
		int presente=0;
		int i=0;
		while (arreglo[i]!=1 && i<=N) {
			if (arreglo[i]==1) {
				presente=1;
			}
			i++;
		}
		return presente;
	}

	public void sacar(int valor) {
		int i=0;
		if (i>=0 && i<=N && i!=N) {
			i++;
		}
		arreglo[i]=0;
	}

	public boolean pertenece(int valor) {
		return false;
	}
	
	private int solicitarCotaMax() {            //Solicita por teclado el número máximo a representar en el Conjunto (0-N)
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.close();
		return N+1;
	}
	
}
