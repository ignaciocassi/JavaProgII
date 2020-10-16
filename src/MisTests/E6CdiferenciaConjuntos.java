package MisTests;

import MisApis.ConjuntoTDA;
import MisImplementacionesDinamicas.Conjunto;
import MisMetodos.metodos;

public class E6CdiferenciaConjuntos {

	public static void main(String[] args) {
		ConjuntoTDA conjA=new Conjunto();
		ConjuntoTDA conjB=new Conjunto();
		ConjuntoTDA conjDiferencia=new Conjunto();
		conjDiferencia.inicializarConjunto();
		conjA.inicializarConjunto();
		conjB.inicializarConjunto();
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		conjB.agregar(3);
		conjB.agregar(4);
		conjB.agregar(5);
		
		System.out.println("ConjuntoA: ");
		metodos.mostrarConjunto(conjA);
		
		System.out.println("ConjuntoB: ");
		metodos.mostrarConjunto(conjB);
		
		System.out.println("Conjunto diferencia: ");
		conjDiferencia=metodos.diferenciaConjuntos(conjA, conjB);
		metodos.mostrarConjunto(conjDiferencia);

	}

}
