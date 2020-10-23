package MisTests;

import MisApis.ConjuntoTDA;
import MisImplementacionesDinamicas.Conjunto;
import MisMetodos.metodos;

public class E6CunionConjuntos {

	public static void main(String[] args) {
		ConjuntoTDA conjA=new Conjunto();
		ConjuntoTDA conjB=new Conjunto();
		conjA.inicializarConjunto();
		conjB.inicializarConjunto();
		
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		conjA.agregar(4);
		
		conjB.agregar(4);
		conjB.agregar(5);
		conjB.agregar(6);
		conjB.agregar(7);
		
		System.out.println("ConjuntoA: ");
		metodos.mostrarConjunto(conjA);
		
		System.out.println("ConjuntoB: ");
		metodos.mostrarConjunto(conjB);
		
		System.out.println("Conjunto union entre A y B: ");
		ConjuntoTDA conjUnion=new Conjunto();
		conjUnion.inicializarConjunto();
		conjUnion=metodos.unionConjuntos(conjA, conjB);
		metodos.mostrarConjunto(conjUnion);
	}

}
