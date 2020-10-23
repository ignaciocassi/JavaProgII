package MisTests;

//Importar las interfaces e implementaciones proveidas
import MisApis.PilaTDA;                       //import MisApis.*
import MisImplementacionesDinamicas.Pila;     //import MisImplementaciones.*

public class PlantillaEjExamen {

	public static void main(String[] args) {
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		
		pila.Apilar(1);
		pila.Apilar(2);
		pila.Apilar(3);
		
		System.out.println("Mostrando pila: ");
		metodoExternoMostrarPila(pila);
	}
	
	//Metodos externos estáticos y públicos
	public static void metodoExternoMostrarPila(PilaTDA pila) {
		PilaTDA pilaCopia=new Pila();
		pilaCopia.InicializarPila();
		
		copiarPila(pila,pilaCopia);
		
		int tope;
		while(!pilaCopia.PilaVacia()) {
			tope=pilaCopia.Tope();
			System.out.println(tope);
			pilaCopia.Desapilar();
		}
	}

	public static void copiarPila(PilaTDA pila, PilaTDA pilaCopia) {
		PilaTDA pilaAux=new Pila();
		pilaAux.InicializarPila();
		
		int tope;
		while(!pila.PilaVacia()) {
			tope=pila.Tope();
			pilaAux.Apilar(tope);
			pila.Desapilar();
		}
		while(!pilaAux.PilaVacia()) {
			tope=pilaAux.Tope();
			pila.Apilar(tope);
			pilaCopia.Apilar(tope);
			pilaAux.Desapilar();
		}
	}

}
