package MisTests;

import MisApis.ColaTDA;
import MisImplementacionesEstaticas.ColaPI;
import MisMetodos.metodos;

public class E4BinvertirColaConAux {

	public static void main(String[] args) {
		System.out.println("Invierte una colaOrigen pasandola a una pilaAux y luego vuelve a pasarla a la colaOrigen");
		ColaTDA cola=new ColaPI();
		cola.InicializarCola();
		metodos.llenarCola(cola);
		System.out.println("Cola original: ");
		metodos.mostrarcola(cola);
		System.out.println("Cola invertida: ");
		metodos.invertirColaConAux(cola);
		metodos.mostrarcola(cola);
	}

}
