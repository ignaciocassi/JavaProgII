package MisMetodos;

import MisApis.ABBTDA;
import MisApis.ColaPrioridadTDA;
import MisApis.ColaTDA;
import MisApis.ConjuntoTDA;
import MisApis.DiccMultipleTDA;
import MisApis.DiccSimpleTDA;
import MisApis.PilaTDA;
import MisImplementacionesDinamicas.Cola;
import MisImplementacionesDinamicas.DiccMultiple;
import MisImplementacionesEstaticas.ColaPI;
import MisImplementacionesEstaticas.ColaPrioridad;
import MisImplementacionesEstaticas.Conjunto;
import MisImplementacionesEstaticas.Pila;

public class metodos {
	
	//Llena una pila con 10 elementos
	public static void llenarPila(PilaTDA pila) {
		for (int i=1;i<=10;i++) {
			pila.Apilar(i);
		}
	}
	
	//Muestra una pila, no destructivo
	public static void mostrarPila(PilaTDA pilaOriginal) {
		System.out.println("Mostrar pila:");
		PilaTDA pilaCopia=new Pila();
		pilaCopia.InicializarPila();
		int tope;
		copiarPila(pilaOriginal,pilaCopia);
		while(!pilaCopia.PilaVacia()) {
			tope=pilaCopia.Tope();
			System.out.println(tope);
			pilaCopia.Desapilar();
		}
	}
	
	//2a. Pasa de una pila Original a una pila Copia, dejando la primera vacía y la segunda en orden inverso
	public static PilaTDA pasarPilaPila(PilaTDA pilaOriginal) {
		PilaTDA pilaCopia = new Pila();
		pilaCopia.InicializarPila();
		int ultimo;
		while (!pilaOriginal.PilaVacia()) {
			ultimo=pilaOriginal.Tope();
			pilaCopia.Apilar(ultimo);
			pilaOriginal.Desapilar();
		}
		return pilaCopia;
	}
	
	//2b. Copia una pila Original a una pila Copia, no destructivo, en el mismo orden que la original
	public static void copiarPila(PilaTDA pilaOriginal, PilaTDA pilaCopia) {
		PilaTDA pilaAux=new Pila();
		pilaAux.InicializarPila();
		int tope;
		while (!pilaOriginal.PilaVacia()) {
			tope=pilaOriginal.Tope();
			pilaAux.Apilar(tope);
			pilaOriginal.Desapilar();
		}
		while (!pilaAux.PilaVacia()) {
			tope=pilaAux.Tope();
			pilaOriginal.Apilar(tope);
			pilaCopia.Apilar(tope);
			pilaAux.Desapilar();
		}
	}
	
	//2c. Invierte una pila, mediante una pila auxiliar
	public static PilaTDA invertirPila(PilaTDA pila) {
		PilaTDA pilaInvertida=new Pila();
		pilaInvertida.InicializarPila();
		
		PilaTDA pilaCopia = new Pila();
		pilaCopia.InicializarPila();
		
		copiarPila(pila,pilaCopia);
		
		int tope;
		while (!pilaCopia.PilaVacia()) {
			tope=pilaCopia.Tope();
			pilaInvertida.Apilar(tope);
			pilaCopia.Desapilar();
		}
		return pilaInvertida;
	}
	
	//2d. Cuenta los elementos de una pila, no destructiva
	public static int cantidadElemPila(PilaTDA pila) {
		int cantidad=0;
		PilaTDA pilaCopia = new Pila();
		pilaCopia.InicializarPila();
		copiarPila(pila,pilaCopia);
		while (!pilaCopia.PilaVacia()) {
			cantidad++;
			pilaCopia.Desapilar();
		}
		return cantidad;
	}
	
	//2e. Devuelve la suma de los elementos de una pila
	public static int sumarElemPila(PilaTDA pila) {
		int suma=0;
		int tope;
		PilaTDA pilaCopia=new Pila();
		pilaCopia.InicializarPila();
		copiarPila(pila,pilaCopia);
		while(!pilaCopia.PilaVacia()) {
			tope=pilaCopia.Tope();
			suma=suma+tope;
			pilaCopia.Desapilar();
		}
		return suma;
	}
	
	//2f. Devuelve el promedio de los elementos de una pila
	public static int promedioElemPila(PilaTDA pila) {
		PilaTDA pilaCopia=new Pila();
		pilaCopia.InicializarPila();
		int cantelem;
		int suma;
		cantelem=cantidadElemPila(pila);
		suma=sumarElemPila(pila);
		return (suma/cantelem);
	}
	
	//4a. Pasa de una cola a otra, es destructivo
	public static void pasarColaCola(ColaTDA colaOrigen, ColaTDA colaDestino) {
		int primero;
		while(!colaOrigen.ColaVacia()) {
			primero=colaOrigen.Primero();
			colaDestino.Acolar(primero);
		};
	}
	 //4c. Invierte una colaOrigen mediante recursividad
	public static void invertirColaRecursividad(ColaTDA colaOrigen) {
		if (!colaOrigen.ColaVacia()) {
			int primero = colaOrigen.Primero();
	        colaOrigen.Desacolar();
	        invertirColaRecursividad(colaOrigen);
	       colaOrigen.Acolar(primero);
	     }
	}
	
	//4b. Invierte una colaOrigen pasandola a una pilaAux y luego vuelve a pasarla a la colaOrigen
	public static void invertirColaConAux(ColaTDA colaOrigen) {
		PilaTDA pilaAux=new Pila();
		pilaAux.InicializarPila();
		int primero;
		while(!colaOrigen.ColaVacia()) {
			primero = colaOrigen.Primero();
			pilaAux.Apilar(primero);
			colaOrigen.Desacolar();
		}
		while(!pilaAux.PilaVacia()) {
			primero = pilaAux.Tope();
			colaOrigen.Acolar(primero);
			pilaAux.Desapilar();
		}
	}
	
	
	//Copia una cola, recibiendo cola Origen y Destino como parámetros
	public static void copiarCola(ColaTDA colaOrigen, ColaTDA colaDestino) {
		ColaTDA colaAux=new ColaPI();
		colaAux.InicializarCola();
		int primero;
		while (!colaOrigen.ColaVacia()) {
			primero=colaOrigen.Primero();
			colaAux.Acolar(primero);
			colaOrigen.Desacolar();
		}
		while (!colaAux.ColaVacia()) {
			primero=colaAux.Primero();
			colaOrigen.Acolar(primero);
			colaDestino.Acolar(primero);
			colaAux.Desacolar();
		}
	}
	
	public static void mostrarcola(ColaTDA colaOrigen) {
		System.out.println("Mostrar cola: ");
		ColaTDA colaCopia=new ColaPI();
		colaCopia.InicializarCola();
		copiarCola(colaOrigen,colaCopia);
		int primero;
		while(!colaCopia.ColaVacia()) {
			primero=colaCopia.Primero();
			System.out.println(primero);
			colaCopia.Desacolar();
		}
	}
	
	public static void llenarCola(ColaTDA colaOrigen) {
		for (int i=1;i<=10;i++) {
			colaOrigen.Acolar(i);
		}
	}
	
	public static boolean colaCapicua(ColaTDA cola) {
		ColaTDA colaAux=new Cola();
		colaAux.InicializarCola();
		
		int cant=0;
		
		PilaTDA pila=new Pila();
		pila.InicializarPila();
		
		while(!cola.ColaVacia()) {
			pila.Apilar(cola.Primero());
			cant++;
			cola.Desacolar();
		}
		
		int mitad=cant/2;
		
		while(!colaAux.ColaVacia() && mitad>0) {
			pila.Apilar(colaAux.Primero());
			colaAux.Desacolar();
			mitad--;
		}
		
		if((cant%2)!=0) {
			colaAux.Desacolar();
		}
		
		while(!pila.PilaVacia() && !colaAux.ColaVacia()) {
			if (pila.Tope()!=colaAux.Primero()) {
				return false;
			}
			pila.Desapilar();
			colaAux.Desacolar();
		}
		return (pila.PilaVacia() && colaAux.ColaVacia());
	}
	
	/**4e. Determinar si una cola es capicúa o no.
	public static boolean colaCapicua(ColaTDA colaOrigen) {
		boolean capicua=false;
		int cantidad=0;
		double dos=2.0;
		double mitad=0.0;
		double partedecimal=0.0;
		double resto=0.0;
		ColaTDA colaCopia=new ColaPI();
		colaCopia.InicializarCola();
		ColaTDA colaCopiaInvertida=new ColaPI();
		colaCopiaInvertida.InicializarCola();
		copiarCola(colaOrigen,colaCopia);
		while(!colaCopia.ColaVacia()) {
			cantidad++;
			colaCopia.Desacolar();
		}
		copiarCola(colaOrigen,colaCopia);
		copiarCola(colaOrigen,colaCopiaInvertida);
		invertirColaConAux(colaCopiaInvertida);
		mitad=(double)cantidad/dos;
		partedecimal=mitad-(double)((int)cantidad/2);
		resto=1.0-partedecimal;
		System.out.println(mitad);
		mitad=mitad+resto;
		for (int i=1;i<=(int)mitad;i++) {
			if (colaCopia.Primero()==colaCopiaInvertida.Primero()) {
				capicua=true;
			} else {
				capicua=false;
				break;
			}
			colaCopia.Desacolar();
			colaCopiaInvertida.Desacolar();
		}
		return capicua;
	}
	**/
	
	//4d. Determinar si el final de la Cola C1 coincide o no con la Cola C2.
	public static boolean finalColasCoinciden(ColaTDA cola1, ColaTDA cola2) {
		ColaTDA cola1copia = new ColaPI();
		ColaTDA cola2copia = new ColaPI();
		cola1copia.InicializarCola();
		cola2copia.InicializarCola();
		copiarCola(cola1,cola1copia);
		copiarCola(cola2,cola2copia);
		boolean finalCoincide=false;
		int ultimocola1copia = 0;
		int ultimocola2copia = 0;
		while(!cola1copia.ColaVacia()) {
			ultimocola1copia=cola1copia.Primero();
			cola1copia.Desacolar();
		}
		while(!cola2copia.ColaVacia()) {
			ultimocola2copia=cola2copia.Primero();
			cola2copia.Desacolar();
		}
		if (ultimocola1copia==ultimocola2copia) {
			finalCoincide=true;
		} else {
			finalCoincide=false;
		}
		return finalCoincide;
	}
	
	//4f. determina si dos colas son inversas
	public static boolean colasInversas(ColaTDA cola1,ColaTDA cola2) {
		boolean inversas=true;
		ColaTDA cola1copia=new ColaPI();
		ColaTDA cola2copia=new ColaPI();
		cola1copia.InicializarCola();
		cola2copia.InicializarCola();
		copiarCola(cola1,cola1copia);
		copiarCola(cola2,cola2copia);
		invertirColaConAux(cola2copia);
		while(!cola1copia.ColaVacia()&&!cola2copia.ColaVacia()&&inversas==true) {
			if (cola1copia.Primero()!=cola2copia.Primero())
				inversas=false;
			cola1copia.Desacolar();
			cola2copia.Desacolar();
		}
		return inversas;
	}
	
	//Llena una colaPrioridadTDA
	public static void llenarColaPrioridad(ColaPrioridadTDA colaP, int desdevalor, int hastavalor, int desdeprioridad) {
		int prioridadactual=desdeprioridad;
		for (int valoractual=desdevalor;valoractual<=hastavalor;valoractual++) {
			colaP.Acolar(valoractual, prioridadactual);
			prioridadactual++;
		}
	}
	
	//6a. Combina dos colas con prioridad colaP1 y colaP2, y devuelve una nueva.
	public static ColaPrioridadTDA combinarColasPrioridad(ColaPrioridadTDA colaP1, ColaPrioridadTDA colaP2) {
		ColaPrioridadTDA colaP1Copia=new ColaPrioridad();
		colaP1Copia.InicializarCola();
		
		ColaPrioridadTDA colaP2Copia=new ColaPrioridad();
		colaP2Copia.InicializarCola();
		
		ColaPrioridadTDA nuevaColaP=new ColaPrioridad();
		nuevaColaP.InicializarCola();
		
		metodos.copiarColaPrioridad(colaP1, colaP1Copia);
		metodos.copiarColaPrioridad(colaP2, colaP2Copia);
		
		while (!colaP1Copia.ColaVacia()) {
			nuevaColaP.Acolar(colaP1Copia.Primero(), colaP1Copia.Prioridad());
			colaP1Copia.Desacolar();
		}
		while (!colaP2Copia.ColaVacia()) {
			nuevaColaP.Acolar(colaP2Copia.Primero(), colaP2Copia.Prioridad());
			colaP2Copia.Desacolar();
		}
		return nuevaColaP;
	}
	
	public static void copiarColaPrioridad(ColaPrioridadTDA colaPOrigen, ColaPrioridadTDA colaPDestino) {
		ColaPrioridad colaPAux=new ColaPrioridad();
		colaPAux.InicializarCola();
		while(!colaPOrigen.ColaVacia()) {
			colaPAux.Acolar(colaPOrigen.Primero(), colaPOrigen.Prioridad());
			colaPOrigen.Desacolar();
		}
		while(!colaPAux.ColaVacia()) {
			colaPOrigen.Acolar(colaPAux.Primero(), colaPAux.Prioridad());
			colaPDestino.Acolar(colaPAux.Primero(), colaPAux.Prioridad());
			colaPAux.Desacolar();
		}
	}
	
	public static void mostrarColaPrioridad(ColaPrioridadTDA colaP) {
		ColaPrioridadTDA colaPCopia=new ColaPrioridad();
		colaPCopia.InicializarCola();
		copiarColaPrioridad(colaP,colaPCopia);
		while(!colaPCopia.ColaVacia()) {
			System.out.println("Valor: "+Integer.toString(colaPCopia.Primero())+" Prioridad: "+Integer.toString(colaPCopia.Prioridad())+".");
			colaPCopia.Desacolar();
		}
	}
	
	//6b. Determina si dos colasPrioridad son iguales
	public static boolean colasPrioridadIguales(ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {
		boolean iguales=true;
		ColaPrioridadTDA CP1copia=new ColaPrioridad();
		CP1copia.InicializarCola();
		ColaPrioridadTDA CP2copia=new ColaPrioridad();
		CP2copia.InicializarCola();
		copiarColaPrioridad(CP1,CP1copia);
		copiarColaPrioridad(CP2,CP2copia);
		while(!CP1copia.ColaVacia()&&!CP2copia.ColaVacia()&&iguales==true) {
			if (CP1copia.Primero()!=CP2copia.Primero()||CP1copia.Prioridad()!=CP2copia.Prioridad()) {
				iguales=false;
			}
			if(CP1copia.ColaVacia()||CP2copia.ColaVacia()) {
				iguales=false;
			}
			CP1copia.Desacolar();
			CP2copia.Desacolar();
		}
		return iguales;
	}
	
	public static void copiarConjunto(ConjuntoTDA conjOriginal, ConjuntoTDA conjCopia) {
		ConjuntoTDA conjAux=new Conjunto();
		conjAux.inicializarConjunto();
		int valor;
		while(!conjOriginal.conjuntoVacio()) {
			valor=conjOriginal.elegir();
			conjAux.agregar(valor);
			conjOriginal.sacar(valor);
		}
		while(!conjAux.conjuntoVacio()) {
			valor=conjAux.elegir();
			conjOriginal.agregar(valor);
			conjCopia.agregar(valor);
			conjAux.sacar(valor);
		}
	}
	
	public static DiccMultipleTDA prioridadesDeCadaValor(ColaPrioridadTDA C) {
		
		DiccMultipleTDA listaDePrioridades=new DiccMultiple();
		listaDePrioridades.inicializarDiccionario();
		
		ColaPrioridadTDA colaCopia=new ColaPrioridad();
		colaCopia.InicializarCola();
		
		copiarColaPrioridad(C,colaCopia);
		
		int elemento;
		int prioridad;
		
		while(!colaCopia.ColaVacia()) {
			elemento=colaCopia.Primero();
			prioridad=colaCopia.Prioridad();
			listaDePrioridades.agregar(elemento, prioridad);
			colaCopia.Desacolar();
		}
		return listaDePrioridades;
	}
	
	public static void mostrarConjunto(ConjuntoTDA conj) {
		System.out.println("Mostrando conjunto: ");
		ConjuntoTDA conjCopia=new Conjunto();
		conjCopia.inicializarConjunto();
		copiarConjunto(conj,conjCopia);
		int valor;
		while(!conjCopia.conjuntoVacio()) {
			valor=conjCopia.elegir();
			System.out.println(valor);
			conjCopia.sacar(valor);
		}
	}
	
	public static ConjuntoTDA unionConjuntos(ConjuntoTDA conjA, ConjuntoTDA conjB) {
		ConjuntoTDA conjUnion=new Conjunto();
		ConjuntoTDA conjACopia=new Conjunto();
		ConjuntoTDA conjBCopia=new Conjunto();
		conjACopia.inicializarConjunto();
		conjBCopia.inicializarConjunto();
		conjUnion.inicializarConjunto();
		copiarConjunto(conjA,conjACopia);
		copiarConjunto(conjB,conjBCopia);
		
		int valorA;
		int valorB;
		
		while(!conjACopia.conjuntoVacio() && !conjBCopia.conjuntoVacio()) {
			valorA=conjACopia.elegir();
			valorB=conjBCopia.elegir();
			conjUnion.agregar(valorA);
			conjUnion.agregar(valorB);
			conjACopia.sacar(valorA);
			conjBCopia.sacar(valorB);
		}
		return conjUnion;
	}
	
	public static ConjuntoTDA interseccionConjuntos(ConjuntoTDA conjA, ConjuntoTDA conjB) {
		ConjuntoTDA conjInterseccion=new Conjunto();
		conjInterseccion.inicializarConjunto();
		ConjuntoTDA conjACopia=new Conjunto();
		conjACopia.inicializarConjunto();
		ConjuntoTDA conjBCopia=new Conjunto();
		conjBCopia.inicializarConjunto();
		
		metodos.copiarConjunto(conjA,conjACopia);
		metodos.copiarConjunto(conjB,conjBCopia);
		
		int valorA;
		int valorB;
		
		while(!conjACopia.conjuntoVacio() && !conjBCopia.conjuntoVacio()) {
			valorA=conjACopia.elegir();
			valorB=conjBCopia.elegir();
			if (conjBCopia.pertenece(valorA)) {
				conjInterseccion.agregar(valorA);
			}
			if (conjACopia.pertenece(valorB)) {
				conjInterseccion.agregar(valorB);
			}
			conjACopia.sacar(valorA);
			conjBCopia.sacar(valorB);
		}
		return conjInterseccion;
	}
	
	public static ConjuntoTDA diferenciaConjuntos(ConjuntoTDA conjA, ConjuntoTDA conjB) {
		ConjuntoTDA conjDiferencia=new Conjunto();
		ConjuntoTDA conjUnion=new Conjunto();
		ConjuntoTDA conjInterseccion=new Conjunto();
		conjDiferencia.inicializarConjunto();
		conjUnion.inicializarConjunto();
		conjInterseccion.inicializarConjunto();
		
		conjUnion=unionConjuntos(conjA,conjB);
		conjInterseccion=interseccionConjuntos(conjA,conjB);
		int valorU;
		while(!conjUnion.conjuntoVacio()) {
			valorU=conjUnion.elegir();
			if (!conjInterseccion.pertenece(valorU)) {
				conjDiferencia.agregar(valorU);
			}
			conjUnion.sacar(valorU);
		}
		return conjDiferencia;
		
	}
	
	//TP3.1a 
	public static boolean pilaCapicua(PilaTDA P) {
		boolean capicua=true;
		
		PilaTDA Pcopia=new Pila();
		Pcopia.InicializarPila();
		
		PilaTDA PcopiaInvertida=new Pila();
		PcopiaInvertida.InicializarPila();
		
		copiarPila(P,Pcopia);
		copiarPila(Pcopia,PcopiaInvertida);
		PcopiaInvertida=invertirPila(Pcopia);
		
		while(!Pcopia.PilaVacia() && !PcopiaInvertida.PilaVacia() && capicua==true) {
			if (Pcopia.Tope()!=PcopiaInvertida.Tope()) {
				capicua=false;
			}
			Pcopia.Desapilar();
			PcopiaInvertida.Desapilar();
		}
		return capicua;
	}
	
	//TP3.1b
	public static void eliminarRepetidosPila(PilaTDA P) {
		PilaTDA Paux=new Pila();
		Paux.InicializarPila();
		
		ConjuntoTDA insertados=new Conjunto();
		insertados.inicializarConjunto();
		
		int tope;
		while(!P.PilaVacia()) {
			tope=P.Tope();
			Paux.Apilar(tope);
			P.Desapilar();
		}
		while(!Paux.PilaVacia()) {
			tope=Paux.Tope();
			if(!insertados.pertenece(tope)) {
				P.Apilar(tope);
				insertados.agregar(tope);
			}
			Paux.Desapilar();
		}
	}
	
	//TP3.1c
	public static void partirPilaEnDos(PilaTDA P, PilaTDA M1, PilaTDA M2) {
		PilaTDA pilaAux=new Pila();
		pilaAux.InicializarPila();
		int elementos=0;
		int contador=0;
		int tope;
		
		while(!P.PilaVacia()) {
			tope=P.Tope();
			pilaAux.Apilar(tope);
			elementos++;
			P.Desapilar();
		}
		while(!pilaAux.PilaVacia()) {
			tope=pilaAux.Tope();
			if(contador<elementos/2) {
				M1.Apilar(tope);
			} else {
				M2.Apilar(tope);
			}
			P.Apilar(tope);
			contador++;
			pilaAux.Desapilar();
		}
		
	}
	
	//TP3.1d
	public static ConjuntoTDA obtenerRepetidosPila(PilaTDA P) {
		ConjuntoTDA cAgregados=new Conjunto();
		cAgregados.inicializarConjunto();
		
		ConjuntoTDA cRepetidos=new Conjunto();
		cRepetidos.inicializarConjunto();
		
		PilaTDA pCopia=new Pila();
		pCopia.InicializarPila();
		
		metodos.copiarPila(P, pCopia);
		
		int tope;
		while(!pCopia.PilaVacia()) {
			tope=pCopia.Tope();
			if(!cAgregados.pertenece(tope)) {
				cAgregados.agregar(tope);
			} else if (cAgregados.pertenece(tope)){
				cRepetidos.agregar(tope);
			}
			pCopia.Desapilar();
		}
		return cRepetidos;
	}

	//TP3.2a
	public static void sacarRepetidosCola(ColaTDA c) {
		ConjuntoTDA cAgregados=new Conjunto();
		cAgregados.inicializarConjunto();
		
		ColaTDA colaAux=new Cola();
		colaAux.InicializarCola();
		
		int primero;
		while(!c.ColaVacia()) {
			primero=c.Primero();
			if (!cAgregados.pertenece(primero)) {
				cAgregados.agregar(primero);
				colaAux.Acolar(primero);
				c.Desacolar();
			} else if(cAgregados.pertenece(primero)) {
				c.Desacolar();
			}
		}
		while(!colaAux.ColaVacia()) {
			primero=colaAux.Primero();
			c.Acolar(primero);
			colaAux.Desacolar();
		}
	}

	public static void partirColaEnDos(ColaTDA c, ColaTDA m1, ColaTDA m2) {
		ColaTDA colaAux=new Cola();
		colaAux.InicializarCola();
		
		int primero;
		int cantidad=0;
		int contador=0;
		while(!c.ColaVacia()) {
			primero=c.Primero();
			colaAux.Acolar(primero);
			cantidad++;
			c.Desacolar();
		}
		while(!colaAux.ColaVacia()) {
			primero=colaAux.Primero();
			if (contador<(cantidad/2)) {
				m1.Acolar(primero);
			} else if (contador>=(cantidad/2)){
				m2.Acolar(primero);
			}
			contador++;
			colaAux.Desacolar();
		}
	}

	public static ConjuntoTDA obtenerRepetidosCola(ColaTDA c) {
		ColaTDA cCopia=new Cola();
		cCopia.InicializarCola();
		
		ConjuntoTDA conjAgregados=new Conjunto();
		conjAgregados.inicializarConjunto();
		
		ConjuntoTDA conjRepetidos=new Conjunto();
		conjRepetidos.inicializarConjunto();
		
		metodos.copiarCola(c, cCopia);
		
		int primero;
		while(!cCopia.ColaVacia()) {
			primero=cCopia.Primero();
			if(!conjAgregados.pertenece(primero)) {
				conjAgregados.agregar(primero);
			} else if (conjAgregados.pertenece(primero)) {
				cCopia.Desacolar();
				conjRepetidos.agregar(primero);
			}
			cCopia.Desacolar();
		}
		return conjRepetidos;
	}

	public static ConjuntoTDA obtenerDifSimetricaEntreConj(ConjuntoTDA conjA, ConjuntoTDA conjB) {
		ConjuntoTDA conjACopia=new Conjunto();
		conjACopia.inicializarConjunto();
		
		ConjuntoTDA conjBCopia=new Conjunto();
		conjBCopia.inicializarConjunto();
		
		ConjuntoTDA conjUnion=new Conjunto();
		conjUnion.inicializarConjunto();
		
		ConjuntoTDA conjInterseccion=new Conjunto();
		conjInterseccion.inicializarConjunto();
		
		ConjuntoTDA conjDifSim=new Conjunto();
		conjDifSim.inicializarConjunto();
		
		metodos.copiarConjunto(conjA, conjACopia);
		metodos.copiarConjunto(conjB, conjBCopia);
		
		int elemento;
		while(!conjACopia.conjuntoVacio()) {
			elemento=conjACopia.elegir();
			conjUnion.agregar(elemento);
			conjACopia.sacar(elemento);
		}
		while(!conjBCopia.conjuntoVacio()) {
			elemento=conjBCopia.elegir();
			conjUnion.agregar(elemento);
			conjBCopia.sacar(elemento);
		}
		
		metodos.copiarConjunto(conjA, conjACopia);
		metodos.copiarConjunto(conjB, conjBCopia);
		
		while(!conjACopia.conjuntoVacio() && !conjBCopia.conjuntoVacio()) {
			elemento=conjACopia.elegir();
			if(conjBCopia.pertenece(elemento)) {
				conjInterseccion.agregar(elemento);
			}
			conjACopia.sacar(elemento);
			elemento=conjBCopia.elegir();
			if(conjACopia.pertenece(elemento)) {
				conjInterseccion.agregar(elemento);
			}
			conjBCopia.sacar(elemento);
		}
		
		while(!conjUnion.conjuntoVacio()) {
			elemento=conjUnion.elegir();
			if(!conjInterseccion.pertenece(elemento)) {
				conjDifSim.agregar(elemento);
			}
			conjUnion.sacar(elemento);
		}
		return conjDifSim;
	}

	public static boolean conjuntosIguales(ConjuntoTDA conjA, ConjuntoTDA conjB) {
		ConjuntoTDA conjACopia=new Conjunto();
		conjACopia.inicializarConjunto();
		
		ConjuntoTDA conjBCopia=new Conjunto();
		conjBCopia.inicializarConjunto();
		
		copiarConjunto(conjA,conjACopia);
		copiarConjunto(conjB,conjBCopia);
		
		boolean iguales=true;
		int elemento;
		while(!conjACopia.conjuntoVacio() && !conjBCopia.conjuntoVacio() && iguales==true) {
			elemento=conjACopia.elegir();
			if(!conjBCopia.pertenece(elemento)) {
				iguales=false;
			} else {
				conjACopia.sacar(elemento);
				conjBCopia.sacar(elemento);
			}
		}
		if(conjACopia.conjuntoVacio() && conjBCopia.conjuntoVacio()) {
			return true;
		} else {
			return false;
		}
	}

	public static int cantidadElemConjunto(ConjuntoTDA c) {
		ConjuntoTDA cCopia=new Conjunto();
		cCopia.inicializarConjunto();
		copiarConjunto(c,cCopia);
		int contador=0;
		
		while(!cCopia.conjuntoVacio()) {
			cCopia.sacar(cCopia.elegir());
			contador++;
		}
		
		return contador;
	}

	public static ConjuntoTDA obtenerConjElementosComunesEntrePilayCola(PilaTDA p, ColaTDA c) {
		PilaTDA pCopia=new Pila();
		pCopia.InicializarPila();
		
		ColaTDA cCopia=new Cola();
		cCopia.InicializarCola();
		
		ConjuntoTDA elemPila=new Conjunto();
		elemPila.inicializarConjunto();
		
		ConjuntoTDA elemCola=new Conjunto();
		elemCola.inicializarConjunto();
		
		ConjuntoTDA elemComunes=new Conjunto();
		elemComunes.inicializarConjunto();
		
		copiarPila(p,pCopia);
		copiarCola(c,cCopia);
		
		int elemento;
		while(!pCopia.PilaVacia()) {
			elemento=pCopia.Tope();
			elemPila.agregar(elemento);
			pCopia.Desapilar();
		}
		while(!cCopia.ColaVacia()) {
			elemento=cCopia.Primero();
			elemCola.agregar(elemento);
			cCopia.Desacolar();
		}
		
		while(!elemPila.conjuntoVacio() && !elemCola.conjuntoVacio()) {
			elemento=elemPila.elegir();
			if (!elemCola.pertenece(elemento)) {
				elemPila.sacar(elemento);
			} else {
				elemComunes.agregar(elemento);
				elemPila.sacar(elemento);
				elemCola.sacar(elemento);
			}
			elemento=elemCola.elegir();
			if (!elemPila.pertenece(elemento)) {
				elemCola.sacar(elemento);
			} else {
				elemComunes.agregar(elemento);
				elemCola.sacar(elemento);
				elemPila.sacar(elemento);
			}
		}
		return elemComunes;
	}

	public static ConjuntoTDA obtenerConjClavesComunesEntreDM(DiccMultipleTDA d1, DiccMultipleTDA d2) {
		//Obtiene las claves comunes entre D1 y D2
		ConjuntoTDA clavesD1=new Conjunto();
		clavesD1.inicializarConjunto();
		
		ConjuntoTDA clavesD2=new Conjunto();
		clavesD2.inicializarConjunto();
		
		ConjuntoTDA clavesComunes=new Conjunto();
		clavesComunes.inicializarConjunto();
		
		clavesD1=d1.claves();
		clavesD2=d2.claves();
		
		int clave;
		while(!clavesD1.conjuntoVacio() && !clavesD2.conjuntoVacio()) {
			clave=clavesD1.elegir();
			if(clavesD2.pertenece(clave)) {
				clavesComunes.agregar(clave);
			}
			clavesD1.sacar(clave);
			clavesD2.sacar(clave);
		}
		return clavesComunes;
	}

	public static DiccMultipleTDA obtenerClavesyValoresComunes(DiccMultipleTDA d1, DiccMultipleTDA d2, ConjuntoTDA clavesComunes) {
		//Obtiene las claves comunes entre D1 y D2, con todos los valores que aparecen en dichas claves
		ConjuntoTDA conjValoresD1=new Conjunto();
		conjValoresD1.inicializarConjunto();
		
		ConjuntoTDA conjValoresD2=new Conjunto();
		conjValoresD2.inicializarConjunto();
		
		DiccMultipleTDA clavesYValoresComunes=new DiccMultiple();
		clavesYValoresComunes.inicializarDiccionario();
		
		int clave;
		int valorD1;
		int valorD2;
		while(!clavesComunes.conjuntoVacio()) {
			clave=clavesComunes.elegir();
			conjValoresD1=d1.recuperar(clave);
			conjValoresD2=d2.recuperar(clave);
			while(!conjValoresD1.conjuntoVacio() && !conjValoresD2.conjuntoVacio()) {
				valorD1=conjValoresD1.elegir();
				clavesYValoresComunes.agregar(clave, valorD1);
				valorD2=conjValoresD2.elegir();
				clavesYValoresComunes.agregar(clave, valorD2);
				conjValoresD1.sacar(valorD1);
				conjValoresD2.sacar(valorD2);
			}
			clavesComunes.sacar(clave);
		}
		return clavesYValoresComunes;
	}

	public static void mostrarDiccMultiple(DiccMultipleTDA dicc) {
		DiccMultipleTDA diccCopia=new DiccMultiple();
		diccCopia.inicializarDiccionario();
		
		ConjuntoTDA claves=new Conjunto();
		claves.inicializarConjunto();
		
		ConjuntoTDA valores=new Conjunto();
		valores.inicializarConjunto();
		
		copiarDiccMultiple(dicc,diccCopia);
		
		System.out.println("Mostrando DiccMultiple: ");
		
		int clave;
		int valor;
		claves=diccCopia.claves();
		while(!claves.conjuntoVacio()) {
			clave=claves.elegir();
			valores=diccCopia.recuperar(clave);
			while(!valores.conjuntoVacio()) {
				valor=valores.elegir();
				System.out.println("Clave: "+clave+" Valor: "+valor+".");
				valores.sacar(valor);
			}
			claves.sacar(clave);
		}
		
	}

	private static void copiarDiccMultiple(DiccMultipleTDA diccOriginal, DiccMultipleTDA diccCopia) {
		DiccMultipleTDA diccAux=new DiccMultiple();
		diccAux.inicializarDiccionario();
		
		ConjuntoTDA claves=new Conjunto();
		claves.inicializarConjunto();
		
		ConjuntoTDA valores=new Conjunto();
		valores.inicializarConjunto();
		
		
		int clave;
		int valor;
		claves=diccOriginal.claves();
		while(!claves.conjuntoVacio()) {
			clave=claves.elegir();
			valores=diccOriginal.recuperar(clave);
			while(!valores.conjuntoVacio()) {
				valor=valores.elegir();
				diccCopia.agregar(clave, valor);
				valores.sacar(valor);
			}
			claves.sacar(clave);
		}
		claves=diccAux.claves();
		while(!claves.conjuntoVacio()) {
			clave=claves.elegir();
			valores=diccAux.recuperar(clave);
			while(!valores.conjuntoVacio()) {
				valor=valores.elegir();
				diccOriginal.agregar(clave, valor);
				diccCopia.agregar(clave, valor);
				valores.sacar(valor);
			}
			claves.sacar(clave);
		}
	}

	public static DiccMultipleTDA obtenerDiccSumaD1D2(DiccMultipleTDA D1, DiccMultipleTDA D2) {
		DiccMultipleTDA D1Copia=new DiccMultiple();
		D1Copia.inicializarDiccionario();
		
		DiccMultipleTDA D2Copia=new DiccMultiple();
		D2Copia.inicializarDiccionario();
		
		DiccMultipleTDA diccSuma=new DiccMultiple();
		diccSuma.inicializarDiccionario();
		
		ConjuntoTDA conjClavesD1=new Conjunto();
		conjClavesD1.inicializarConjunto();
		
		ConjuntoTDA conjValoresD1=new Conjunto();
		conjValoresD1.inicializarConjunto();
		
		ConjuntoTDA conjClavesD2=new Conjunto();
		conjClavesD2.inicializarConjunto();
		
		ConjuntoTDA conjValoresD2=new Conjunto();
		conjValoresD2.inicializarConjunto();
		
		
		copiarDiccMultiple(D1,D1Copia);
		copiarDiccMultiple(D2,D2Copia);
		
		int clave;
		int valor;
		conjClavesD1=D1Copia.claves();
		while(!conjClavesD1.conjuntoVacio()) {
			clave=conjClavesD1.elegir();
			conjValoresD1=D1.recuperar(clave);
			while(!conjValoresD1.conjuntoVacio()) {
				valor=conjValoresD1.elegir();
				diccSuma.agregar(clave, valor);
				conjValoresD1.sacar(valor);
			}
			conjClavesD1.sacar(clave);
		}
		conjClavesD2=D2Copia.claves();
		while(!conjClavesD2.conjuntoVacio()) {
			clave=conjClavesD2.elegir();
			conjValoresD2=D2.recuperar(clave);
			while(!conjValoresD2.conjuntoVacio()) {
				valor=conjValoresD2.elegir();
				diccSuma.agregar(clave, valor);
				conjValoresD2.sacar(valor);
			}
			conjClavesD2.sacar(clave);
		}
		return diccSuma;
	}

	public static DiccMultipleTDA obtenerDiccSumaClavesComunesD1D2(DiccMultipleTDA D1, DiccMultipleTDA D2, ConjuntoTDA clavesComunes) {
		
		DiccMultipleTDA D1Copia=new DiccMultiple();
		DiccMultipleTDA D2Copia=new DiccMultiple();
		DiccMultipleTDA diccSuma=new DiccMultiple();
		diccSuma.inicializarDiccionario();
		D1Copia.inicializarDiccionario();
		D2Copia.inicializarDiccionario();
		
		ConjuntoTDA valoresD1=new Conjunto();
		valoresD1.inicializarConjunto();
		
		ConjuntoTDA valoresD2=new Conjunto();
		valoresD2.inicializarConjunto();
		
		metodos.copiarDiccMultiple(D1, D1Copia);
		metodos.copiarDiccMultiple(D2, D2Copia);
		
		int clave;
		int valorD1;
		int valorD2;
		while(!clavesComunes.conjuntoVacio()) {
			clave=clavesComunes.elegir();
			valoresD1=D1Copia.recuperar(clave);
			valoresD2=D2Copia.recuperar(clave);
			while(!valoresD1.conjuntoVacio() && !valoresD2.conjuntoVacio()) {
				valorD1=valoresD1.elegir();
				valorD2=valoresD2.elegir();
				if (valoresD2.pertenece(valorD1)) {
					diccSuma.agregar(clave, valorD1);
					valoresD1.sacar(valorD1);
				} else if(valoresD1.pertenece(valorD2)) {
					diccSuma.agregar(clave, valorD2);
					valoresD2.sacar(valorD2);
				} else {
					valoresD1.sacar(valorD1);
					valoresD2.sacar(valorD2);
				}

			}
			clavesComunes.sacar(clave);
			
		}
		return diccSuma;
	}
	public static void sumarDiccionariosMultiples(DiccMultipleTDA D1,DiccMultipleTDA D12) {
		ConjuntoTDA clavesD1=new Conjunto();
		clavesD1.inicializarConjunto();
	}

	public static ConjuntoTDA obtenerDifSimetricaEntreConjSinUID(ConjuntoTDA conjA, ConjuntoTDA conjB) {
		//Todos los que no estan repetidos
		
		ConjuntoTDA difSim=new Conjunto();
		difSim.inicializarConjunto();
		
		ConjuntoTDA conjACopia=new Conjunto();
		conjACopia.inicializarConjunto();
		
		ConjuntoTDA conjBCopia=new Conjunto();
		conjBCopia.inicializarConjunto();
		
		copiarConjunto(conjA,conjACopia);
		copiarConjunto(conjB,conjBCopia);
		
		int elemento;
		while(!conjACopia.conjuntoVacio()) {
			elemento=conjACopia.elegir();                 //Tomo elemento de A
			if(!conjBCopia.pertenece(elemento)) {         //Si no pertenece a B, lo agrego
				difSim.agregar(elemento);
			} else {                                      //Si pertenece a B, lo saco de ambos
				conjBCopia.sacar(elemento);
			}
			conjACopia.sacar(elemento);
		}
		                                                  //A quedó vacío, si quedan en b, forman parte de la dif sim, los agrego a todos
		while(!conjBCopia.conjuntoVacio()) {
			elemento=conjBCopia.elegir();
			difSim.agregar(elemento);
			conjBCopia.sacar(elemento);
		}
		return difSim;
		
	}

	public static DiccMultipleTDA obtenerSinonimos(DiccSimpleTDA diccS) {
		DiccMultipleTDA diccM=new DiccMultiple();
		diccM.inicializarDiccionario();
		
		ConjuntoTDA palabras=new Conjunto();
		palabras.inicializarConjunto();
		
		ConjuntoTDA significados=new Conjunto();
		significados.inicializarConjunto();
		
		palabras=diccS.claves();
		int palabra;
		while(!palabras.conjuntoVacio()) {
			palabra=palabras.elegir();
			diccM.agregar(diccS.recuperar(palabra), palabra);
			palabras.sacar(palabra);
			}
		return diccM;
		}

	public static void mostrarDiccSimple(DiccSimpleTDA diccS) {
		ConjuntoTDA claves=new Conjunto();
		claves.inicializarConjunto();
		
		System.out.println("Mostrando DiccSimple: ");
		int clave;
		claves=diccS.claves();
		while(!claves.conjuntoVacio()) {
			clave=claves.elegir();
			System.out.println("Clave: "+clave+" Valor: "+diccS.recuperar(clave)+".");
			claves.sacar(clave);
		}
	}

	public static void copiarDiccSimple(DiccSimpleTDA diccS, DiccSimpleTDA diccSCopia) {
		ConjuntoTDA claves=new Conjunto();
		claves.inicializarConjunto();
		
		claves=diccS.claves();
		int clave;
		while(!claves.conjuntoVacio()) {
			clave=claves.elegir();
			diccSCopia.agregar(clave, diccSCopia.recuperar(clave));
			claves.sacar(clave);
		}
	}
	
	//Métodos para mostrar Arboles Binarios
	
	//Pre-Order
	public static void preOrder(ABBTDA a) {
		System.out.println(a.Raiz());
		preOrder(a.HijoIzq());
		preOrder(a.HijoDer());
	}
	
	//In-Order
	public static void inOrder(ABBTDA a) {
		preOrder(a.HijoIzq());
		System.out.println(a.Raiz());
		preOrder(a.HijoDer());
	}
		
	//Post-Order
	public static void postOrder(ABBTDA a) {
		preOrder(a.HijoIzq());
		preOrder(a.HijoDer());
		System.out.println(a.Raiz());
	}
	
}


	
