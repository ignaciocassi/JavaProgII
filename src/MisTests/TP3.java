package MisTests;

import MisApis.ABBTDA;

import MisApis.ColaTDA;
import MisApis.ConjuntoTDA;
import MisApis.DiccMultipleTDA;
import MisApis.DiccSimpleTDA;
import MisApis.PilaTDA;
import MisImplementacionesDinamicas.ABB;
import MisImplementacionesDinamicas.Cola;
import MisImplementacionesDinamicas.Conjunto;
import MisImplementacionesDinamicas.DiccMultiple;
import MisImplementacionesDinamicas.DiccSimple;
import MisImplementacionesDinamicas.Pila;
import MisMetodos.metodos;
import MisMetodos.metodosABBconInstancia;


public class TP3 {

	public static void main(String[] args) {
		//Ejecutar1aPilaCapicua();                              //E1A
		//EjecutarEliminarRepetidosPila();                      //E1B
		//EjecutarPartirPilaEnDos();                            //E1C
		//EjecutarObtenerRepetidosPila();                       //E1D
		//EjecutarSacarRepetidosCola();                         //E2A
		//EjecutarPartirColaEndos();                            //E2B
		//EjecutarObtenerRepetidosCola();                       //E2C
		//EjecutarObtenerDifSimetricaEntreConjSinUID();         //E3(B)
		//EjecutarObtenerDifSimetricaEntreConj();               //E3(C)
		//EjecutarConjuntosIguales();                           //E3D
		//EjecutarCantElemConjunto();                           //E3E
		//EjecutarObtenerConjElementosComunesEntrePilayCola();  //E3F
		//EjecutarElementosIgualesPilayCola();                  //E3G
		//Ejercicio 4A en MisTests.E4AprioridadesDeValores
		//EjecutarObtenerDiccMultipleD1yD2();                   //E5A
		//EjecutarObtenerConjClavesComunesEntreDM();            //E5C
		//EjecutarObtenerSinonimos();                           //E5.2
	}

	public static void EjecutarCalcularProfundidadElemABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(100);
		abb.AgregarElem(200);
		abb.AgregarElem(50);
		abb.AgregarElem(150);
		abb.AgregarElem(250);
		abb.AgregarElem(25);
		abb.AgregarElem(75);
		
		int elemento=100;
		metodosABBconInstancia metABB=new metodosABBconInstancia();
		int profundidad=metABB.calcularProfundidadElemABB(abb, elemento);
		System.out.println("La profundidad del elemento en el árbol es: "+profundidad);
		
	}

	

	public static void EjecutarObtenerSinonimos() {
		DiccSimpleTDA diccS=new DiccSimple();
		diccS.inicializarDiccionario();
		
		DiccMultipleTDA diccM=new DiccMultiple();
		diccM.inicializarDiccionario();
		
		diccS.agregar(1, 1);
		diccS.agregar(2, 1);
		diccS.agregar(3, 4);
		diccS.agregar(4, 4);
		diccS.agregar(5, 6);
		diccS.agregar(7, 8);
		diccS.agregar(9, 4);
		
		metodos.mostrarDiccSimple(diccS);
		diccM=metodos.obtenerSinonimos(diccS);
		metodos.mostrarDiccMultiple(diccM);
	}

	public static void EjecutarObtenerDifSimetricaEntreConjSinUID() {
		ConjuntoTDA conjA=new Conjunto();
		conjA.inicializarConjunto();
		
		ConjuntoTDA conjB=new Conjunto();
		conjB.inicializarConjunto();
		
		ConjuntoTDA difSim=new Conjunto();
		difSim.inicializarConjunto();
		
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		
		conjB.agregar(3);
		conjB.agregar(4);
		conjB.agregar(5);
		
		difSim=metodos.obtenerDifSimetricaEntreConjSinUID(conjA, conjB);
		metodos.mostrarConjunto(difSim);
		
	}

	public static void EjecutarObtenerClavesComunesySusValDiccMultipleD1yD2() {
		ConjuntoTDA clavesComunes=new Conjunto();
		clavesComunes.inicializarConjunto();
		
		DiccMultipleTDA D1=new DiccMultiple();
		D1.inicializarDiccionario();
		
		DiccMultipleTDA D2=new DiccMultiple();
		D2.inicializarDiccionario();
		
		DiccMultipleTDA diccSuma=new DiccMultiple();
		diccSuma.inicializarDiccionario();
		
		D1.agregar(1, 1);
		D1.agregar(1, 2);
		D1.agregar(1, 3);
		D1.agregar(2, 4);
		D1.agregar(2, 5);
		D1.agregar(2, 6);
		
		D2.agregar(1, 3);
		D2.agregar(1, 4);
		D2.agregar(1, 5);
		D2.agregar(2, 6);
		D2.agregar(2, 7);
		D2.agregar(2, 8);
		
		
		clavesComunes=metodos.obtenerConjClavesComunesEntreDM(D1, D2);
		diccSuma=metodos.obtenerDiccSumaClavesComunesD1D2(D1,D2,clavesComunes);
		metodos.mostrarDiccMultiple(diccSuma);
		
		
	}

	public static void EjecutarObtenerDiccMultipleD1yD2() {
		DiccMultipleTDA D1=new DiccMultiple();
		DiccMultipleTDA D2=new DiccMultiple();
		DiccMultipleTDA diccSuma=new DiccMultiple();
		D1.inicializarDiccionario();
		D2.inicializarDiccionario();
		diccSuma.inicializarDiccionario();
		
		D1.agregar(1, 1);
		D1.agregar(1, 2);
		D1.agregar(2, 1);
		D1.agregar(2, 2);
		D1.agregar(3, 1);
		D1.agregar(3, 2);
		D1.agregar(4, 1);
		D1.agregar(4, 2);
		
		D2.agregar(1, 3);
		D2.agregar(1, 4);
		D2.agregar(2, 3);
		D2.agregar(2, 4);
		D2.agregar(3, 3);
		D2.agregar(3, 4);
		D2.agregar(5, 3);
		D2.agregar(5, 4);
		
		System.out.println("Dicc D1: ");
		metodos.mostrarDiccMultiple(D1);
		
		System.out.println("Dicc D2: ");
		metodos.mostrarDiccMultiple(D2);
		
		diccSuma=metodos.obtenerDiccSumaD1D2(D1,D2);
		System.out.println("Dicc diccSuma D1 y D2 con todos las claves y valores de ambos: ");
		metodos.mostrarDiccMultiple(diccSuma);
		
		
		
	}

	public static void EjecutarObtenerConjClavesComunesEntreDM() {
		//E5C
		DiccMultipleTDA D1=new DiccMultiple();
		D1.inicializarDiccionario();
		
		DiccMultipleTDA D2=new DiccMultiple();
		D2.inicializarDiccionario();
		
		DiccMultipleTDA ClavesyValoresComunes=new DiccMultiple();
		ClavesyValoresComunes.inicializarDiccionario();
		
		ConjuntoTDA clavesComunes=new Conjunto();
		clavesComunes.inicializarConjunto();
		
		D1.agregar(1, 1);
		D1.agregar(1, 2);
		D1.agregar(2, 1);
		D1.agregar(2, 2);
		D1.agregar(3, 1);
		D1.agregar(3, 2);
		D1.agregar(4, 1);
		D1.agregar(4, 2);
		
		D2.agregar(1, 3);
		D2.agregar(1, 4);
		D2.agregar(2, 3);
		D2.agregar(2, 4);
		D2.agregar(3, 3);
		D2.agregar(3, 4);
		D2.agregar(5, 3);
		D2.agregar(5, 4);
		
		clavesComunes=metodos.obtenerConjClavesComunesEntreDM(D1,D2);
		System.out.println("Claves comunes: ");
		metodos.mostrarConjunto(clavesComunes);
		
		ClavesyValoresComunes=metodos.obtenerClavesyValoresComunes(D1,D2,clavesComunes);
		metodos.mostrarDiccMultiple(ClavesyValoresComunes);
	}

	public static void EjecutarElementosIgualesPilayCola() {
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

	public static void EjecutarObtenerConjElementosComunesEntrePilayCola() {
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

	public static void EjecutarCantElemConjunto() {
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

	public static void EjecutarConjuntosIguales() {
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

	public static void EjecutarObtenerDifSimetricaEntreConj() {
		// AuB - AiB
		ConjuntoTDA conjA=new Conjunto();
		conjA.inicializarConjunto();
		
		ConjuntoTDA conjB=new Conjunto();
		conjB.inicializarConjunto();
		
		ConjuntoTDA difSimetrica=new Conjunto();
		difSimetrica.inicializarConjunto();
		
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		
		conjB.agregar(3);
		conjB.agregar(4);
		conjB.agregar(5);
		
		difSimetrica=metodos.diferenciaConjuntos(metodos.unionConjuntos(conjA, conjB), metodos.interseccionConjuntos(conjA, conjB));
		metodos.mostrarConjunto(difSimetrica);
		
		
	}

	public static void EjecutarObtenerRepetidosCola() {
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

	public static void EjecutarPartirColaEndos() {
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

	public static void EjecutarSacarRepetidosCola() {
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

	public static void EjecutarObtenerRepetidosPila() {
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

	public static void EjecutarPartirPilaEnDos() {
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

	public static void Ejecutar1aPilaCapicua() {
		PilaTDA P = new Pila();
		P.InicializarPila();
		
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(2);
		P.Apilar(1);
		
		boolean capicua=metodos.pilaCapicua(P);
		
		if (capicua==true) {
			System.out.println("La pila es capicúa.");
		} else {
			System.out.println("La pila no es capicúa.");
		}
		
	}
	
	public static void EjecutarEliminarRepetidosPila() {
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
