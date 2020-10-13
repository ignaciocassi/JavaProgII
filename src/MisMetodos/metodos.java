package MisMetodos;

import MisApis.ColaPrioridadTDA;
import MisApis.ColaTDA;
import MisApis.PilaTDA;
import MisImplementacionesEstaticas.ColaPI;
import MisImplementacionesEstaticas.ColaPrioridad;
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
	public static PilaTDA copiarPila(PilaTDA pilaOriginal, PilaTDA pilaCopia) {
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
		return pilaCopia;
	}
	
	//2c. Invierte una pila, mediante una pila auxiliar
	public static void invertirPila(PilaTDA pila) {
		PilaTDA pilaAux=new Pila();
		pilaAux.InicializarPila();
		int tope;
		while (!pila.PilaVacia()) {
			tope=pila.Tope();
			pilaAux.Apilar(tope);
			pila.Desapilar();
		}
		while (!pilaAux.PilaVacia()) {
			tope=pilaAux.Tope();
			pila.Apilar(tope);
			pilaAux.Desapilar();
		}
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
	
	//4c. Invierte una cola sin una pila axiliar
	public static void invertirColaSinAux(ColaTDA colaOrigen) {
		//IMPLEMENTAR
		
		
		
		
		
		
		
	}
	
	//4e. Determinar si una cola es capicúa o no.
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
		ColaPrioridadTDA nuevaColaP=new ColaPrioridad();
		nuevaColaP.InicializarCola();
		while (!colaP1.ColaVacia()) {
			nuevaColaP.Acolar(colaP1.Primero(), colaP1.Prioridad());
			colaP1.Desacolar();
		}
		while (!colaP2.ColaVacia()) {
			nuevaColaP.Acolar(colaP2.Primero(), colaP2.Prioridad());
			colaP2.Desacolar();
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
}
