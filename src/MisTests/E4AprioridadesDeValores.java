package MisTests;

import MisApis.ColaPrioridadTDA;
import MisApis.ConjuntoTDA;
import MisApis.DiccMultipleTDA;
import MisImplementacionesDinamicas.ColaPrioridad;
import MisImplementacionesDinamicas.Conjunto;
import MisImplementacionesDinamicas.DiccMultiple;
import MisMetodos.metodos;

public class E4AprioridadesDeValores {

	public static void main(String[] args) {
		
		ColaPrioridadTDA C=new ColaPrioridad();
		C.InicializarCola();
		
		C.Acolar(1, 1);
		C.Acolar(1, 2);
		C.Acolar(1, 3);
		C.Acolar(2, 1);
		C.Acolar(2, 2);
		C.Acolar(2, 3);
		C.Acolar(3, 1);
		C.Acolar(3, 2);
		C.Acolar(3, 3);
		
		System.out.println("ColaPrioridad: ");
		metodos.mostrarColaPrioridad(C);
		
		DiccMultipleTDA listaDePrioridades=prioridadesDeCadaValor(C);
		System.out.println("DiccMultiple lista de prioridades de valores: ");
		mostrarDiccMultiple(listaDePrioridades);
		
	}

	private static void mostrarDiccMultiple(DiccMultipleTDA diccMultiple) {
		
		DiccMultipleTDA diccMCopia=new DiccMultiple();
		diccMCopia.inicializarDiccionario();
		
		copiarDiccMultiple(diccMultiple,diccMCopia);
		
		ConjuntoTDA claves=new Conjunto();
		claves.inicializarConjunto();
		
		ConjuntoTDA valores=new Conjunto();
		valores.inicializarConjunto();
		
		int clave;
		int valor;
		
		claves=diccMCopia.claves();
		while(!claves.conjuntoVacio()) {
			clave=claves.elegir();
			valores=diccMCopia.recuperar(clave);
			while(!valores.conjuntoVacio()) {
				valor=valores.elegir();
				System.out.println("Clave: "+clave+" Valor: "+valor+".");
				valores.sacar(valor);
			}
			claves.sacar(clave);
		}
		
	}

	private static void copiarDiccMultiple(DiccMultipleTDA diccMOrigen, DiccMultipleTDA diccMCopia) {
		DiccMultipleTDA diccMAux=new DiccMultiple();
		diccMAux.inicializarDiccionario();
		
		int clave;
		int valor;
		
		ConjuntoTDA conjClaves=diccMOrigen.claves();
		while(!conjClaves.conjuntoVacio()) {
			clave=conjClaves.elegir();
			ConjuntoTDA conjValores=diccMOrigen.recuperar(clave);
			while(!conjValores.conjuntoVacio()) {
				valor=conjValores.elegir();
				diccMAux.agregar(clave, valor);
				diccMOrigen.eliminarValor(clave, valor);
				conjValores.sacar(valor);
			}
			conjClaves.sacar(clave);
		}
		conjClaves=diccMAux.claves();
		while(!conjClaves.conjuntoVacio()) {
			clave=conjClaves.elegir();
			ConjuntoTDA conjValores=diccMAux.recuperar(clave);
			while(!conjValores.conjuntoVacio()) {
				valor=conjValores.elegir();
				diccMOrigen.agregar(clave, valor);
				diccMCopia.agregar(clave, valor);
				conjValores.sacar(valor);
			}
			conjClaves.sacar(clave);
		}
	}

	private static DiccMultipleTDA prioridadesDeCadaValor(ColaPrioridadTDA C) {
		
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
	
	private static void copiarColaPrioridad(ColaPrioridadTDA colaOrigen, ColaPrioridadTDA colaCopia) {
		ColaPrioridadTDA colaPAux=new ColaPrioridad();
		colaPAux.InicializarCola();
		int valor;
		int prioridad;
		while(!colaOrigen.ColaVacia()) {
			valor=colaOrigen.Primero();
			prioridad=colaOrigen.Prioridad();
			colaPAux.Acolar(valor, prioridad);
			colaOrigen.Desacolar();
		}
		while(!colaPAux.ColaVacia()) {
			valor=colaPAux.Primero();
			prioridad=colaPAux.Prioridad();
			colaOrigen.Acolar(valor, prioridad);
			colaCopia.Acolar(valor, prioridad);
			colaPAux.Desacolar();
		}
	}

}
