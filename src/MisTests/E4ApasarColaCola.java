package MisTests;

import MisApis.ColaTDA;
import MisImplementacionesDinamicas.Cola;
import MisMetodos.metodos;

public class E4ApasarColaCola {

	public static void main(String[] args) {
		ColaTDA colaA=new Cola();
		colaA.InicializarCola();
		
		ColaTDA colaB=new Cola();
		colaB.InicializarCola();
		
		colaA.Acolar(1);
		colaA.Acolar(2);
		colaA.Acolar(3);
		
		System.out.println("Cola A: ");
		metodos.mostrarcola(colaA);
		metodos.pasarColaCola(colaA, colaB);
		System.out.println("Cola B: ");
		metodos.mostrarcola(colaB);

	}

}
