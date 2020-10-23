package MisTests;

import MisApis.ColaTDA;
import MisImplementacionesDinamicas.Cola;
import MisMetodos.metodos;

public class E4BInvertirColaRecursividad {

	public static void main(String[] args) {
		ColaTDA cola=new Cola();
		cola.InicializarCola();
		
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		
		System.out.println("Cola original: ");
		metodos.mostrarcola(cola);
		
		System.out.println("Cola invertida: ");
		metodos.invertirColaRecursividad(cola);
		metodos.mostrarcola(cola);
	}

}
