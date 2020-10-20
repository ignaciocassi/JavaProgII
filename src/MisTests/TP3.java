package MisTests;

import MisApis.ColaTDA;
import MisApis.ConjuntoTDA;
import MisApis.PilaTDA;
import MisImplementacionesDinamicas.Cola;
import MisImplementacionesDinamicas.Conjunto;
import MisImplementacionesDinamicas.Pila;
import MisMetodos.metodos;

public class TP3 {

	public static void main(String[] args) {
		//Ejecutar1aPilaCapicua();
		//EjecutarEliminarRepetidosPila();
		//EjecutarPartirPilaEnDos();
		//EjecutarObtenerRepetidosPila();
		//EjecutarSacarRepetidosCola();
		//EjecutarPartirColaEndos();
		//EjecutarObtenerRepetidosCola();
		//EjecutarObtenerDifSimetricaEntreConj();
		//EjecutarConjuntosIguales();
		//EjecutarCantElemConjunto();
		//EjecutarObtenerConjElementosComunesEntrePilayCola();
		EjecutarElementosIgualesPilayCola();
	}

	private static void EjecutarElementosIgualesPilayCola() {
		PilaTDA p=new Pila();
		p.InicializarPila();
		
		PilaTDA pCopia=new Pila();
		pCopia.InicializarPila();
		
		ConjuntoTDA conjPCopia=new Conjunto();
		conjPCopia.inicializarConjunto();
		
		ColaTDA c=new Cola();
		c.InicializarCola();
		
		ColaTDA cCopia=new Cola();
		cCopia.InicializarCola();
		
		ConjuntoTDA conjCCopia=new Conjunto();
		conjCCopia.inicializarConjunto();
		
		p.Apilar(1);
		p.Apilar(2);
		p.Apilar(3);
		c.Acolar(1);
		c.Acolar(2);
		c.Acolar(3);
		
		metodos.copiarCola(c, cCopia);
		metodos.copiarPila(p, pCopia);
		
		int elemento;
		while(!pCopia.PilaVacia()) {
			elemento=pCopia.Tope();
			conjPCopia.agregar(elemento);
			pCopia.Desapilar();
		}
		while(!cCopia.ColaVacia()) {
			elemento=cCopia.Primero();
			conjCCopia.agregar(elemento);
			cCopia.Desacolar();
		}
		
		boolean iguales;
		iguales=metodos.conjuntosIguales(conjPCopia, conjCCopia);
		System.out.println(iguales);
		
	}

	private static void EjecutarObtenerConjElementosComunesEntrePilayCola() {
		PilaTDA p=new Pila();
		p.InicializarPila();
		
		ColaTDA c=new Cola();
		c.InicializarCola();
		
		ConjuntoTDA conj=new Conjunto();
		conj.inicializarConjunto();
		
		p.Apilar(1);
		p.Apilar(2);
		p.Apilar(3);
		p.Apilar(4);
		p.Apilar(5);
		p.Apilar(12);
		p.Apilar(13);
		
		c.Acolar(5);
		c.Acolar(6);
		c.Acolar(7);
		c.Acolar(8);
		c.Acolar(9);
		c.Acolar(10);
		c.Acolar(765);
		c.Acolar(54);
		c.Acolar(12);
		c.Acolar(13);
		
		conj=metodos.obtenerConjElementosComunesEntrePilayCola(p,c);
		metodos.mostrarConjunto(conj);
		
	}

	private static void EjecutarCantElemConjunto() {
		ConjuntoTDA C=new Conjunto();
		C.inicializarConjunto();
		
		C.agregar(1);
		C.agregar(7);
		C.agregar(6);
		C.agregar(2);
		C.agregar(5);
		C.agregar(3);
		
		int cantidad=metodos.cantidadElemConjunto(C);
		System.out.println(cantidad);
		
	}

	private static void EjecutarConjuntosIguales() {
		ConjuntoTDA conjA=new Conjunto();
		conjA.inicializarConjunto();
		
		ConjuntoTDA conjB=new Conjunto();
		conjB.inicializarConjunto();
		
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		conjB.agregar(1);
		conjB.agregar(2);
		conjB.agregar(3);
		
		boolean iguales=metodos.conjuntosIguales(conjA,conjB);
		System.out.println(iguales);
		
	}

	private static void EjecutarObtenerDifSimetricaEntreConj() {
		ConjuntoTDA conjA=new Conjunto();
		conjA.inicializarConjunto();
		
		ConjuntoTDA conjB=new Conjunto();
		conjB.inicializarConjunto();
		
		ConjuntoTDA difSimetrica=new Conjunto();
		difSimetrica.inicializarConjunto();
		
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		conjA.agregar(4);
		
		conjB.agregar(4);
		conjB.agregar(5);
		conjB.agregar(6);
		
		difSimetrica=metodos.obtenerDifSimetricaEntreConj(conjA,conjB);
		metodos.mostrarConjunto(difSimetrica);
		
		
	}

	private static void EjecutarObtenerRepetidosCola() {
		ColaTDA c=new Cola();
		c.InicializarCola();
		
		ConjuntoTDA repetidos=new Conjunto();
		repetidos.inicializarConjunto();
		
		c.Acolar(1);
		c.Acolar(2);
		c.Acolar(3);
		c.Acolar(4);
		c.Acolar(4);
		c.Acolar(5);
		
		repetidos=metodos.obtenerRepetidosCola(c);
		metodos.mostrarConjunto(repetidos);
		
		
	}

	private static void EjecutarPartirColaEndos() {
		ColaTDA c=new Cola();
		c.InicializarCola();
		ColaTDA M1=new Cola();
		c.InicializarCola();
		ColaTDA M2=new Cola();
		c.InicializarCola();
		
		c.Acolar(1);
		c.Acolar(2);
		c.Acolar(3);
		c.Acolar(4);
		c.Acolar(5);
		c.Acolar(6);
		
		metodos.partirColaEnDos(c,M1,M2);
		metodos.mostrarcola(M1);
		metodos.mostrarcola(M2);
		
		
	}

	private static void EjecutarSacarRepetidosCola() {
		ColaTDA C=new Cola();
		C.InicializarCola();
		
		C.Acolar(1);
		C.Acolar(2);
		C.Acolar(3);
		C.Acolar(4);
		C.Acolar(4);
		C.Acolar(5);
		
		metodos.sacarRepetidosCola(C);
		
		metodos.mostrarcola(C);
		
		
	}

	private static void EjecutarObtenerRepetidosPila() {
		PilaTDA P=new Pila();
		P.InicializarPila();
		
		ConjuntoTDA repetidos=new Conjunto();
		repetidos.inicializarConjunto();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(4);
		P.Apilar(5);
		
		repetidos=metodos.obtenerRepetidosPila(P);
		metodos.mostrarConjunto(repetidos);
	}

	private static void EjecutarPartirPilaEnDos() {
		PilaTDA P=new Pila();
		PilaTDA M1=new Pila();
		PilaTDA M2=new Pila();
		P.InicializarPila();
		M1.InicializarPila();
		M2.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(5);
		P.Apilar(6);
		
		metodos.partirPilaEnDos(P, M1, M2);
		
		System.out.println("Pila P: ");
		metodos.mostrarPila(P);
		
		System.out.println("Pila M1: ");
		metodos.mostrarPila(M1);
		
		System.out.println("Pila M2: ");
		metodos.mostrarPila(M2);
	}

	private static void Ejecutar1aPilaCapicua() {
		PilaTDA P = new Pila();
		P.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(1);
		
		boolean capicua=metodos.pilaCapicua(P);
		
		if (capicua==true) {
			System.out.println("La pila es capicúa.");
		} else {
			System.out.println("La pila no es capicúa.");
		}
		
	}
	
	private static void EjecutarEliminarRepetidosPila() {
		PilaTDA P=new Pila();
		P.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		P.Apilar(5);
		
		System.out.println("Pila original: ");
		metodos.mostrarPila(P);
		
		
		metodos.eliminarRepetidosPila(P);
		System.out.println("Pila sin repetidos: ");
		metodos.mostrarPila(P);
	}
	
}
