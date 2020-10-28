package MisTests;

import MisApis.PilaTDA;
import MisImplementacionesDinamicas.Pila;
import MisMetodos.metodos;

public class E2APasarPilaAP {

	public static void main(String[] args) {
		PilaTDA pilaA=new Pila();
		pilaA.InicializarPila();
		
		PilaTDA pilaB=new Pila();
		pilaB.InicializarPila();
		
		pilaA.Apilar(1);
		pilaA.Apilar(2);
		pilaA.Apilar(3);
		
		System.out.println("Pila A: ");
		metodos.mostrarPila(pilaA);
		metodos.pasarPilaPila(pilaA,pilaB);
		System.out.println("Pila B: ");
		metodos.mostrarPila(pilaB);
		}
	}


