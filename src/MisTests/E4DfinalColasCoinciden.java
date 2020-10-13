package MisTests;

import MisApis.ColaTDA;
import MisImplementacionesEstaticas.ColaPI;
import MisMetodos.metodos;

public class E4DfinalColasCoinciden {

	public static void main(String[] args) {
		ColaTDA cola1 = new ColaPI();
		ColaTDA cola2 = new ColaPI();
		cola1.InicializarCola();
		cola2.InicializarCola();
		metodos.llenarCola(cola1);
		metodos.llenarCola(cola2);
		System.out.println(metodos.finalColasCoinciden(cola1,cola2));
	}
}
