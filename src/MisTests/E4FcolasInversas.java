package MisTests;

import MisApis.ColaTDA;
import MisImplementacionesEstaticas.ColaPI;
import MisMetodos.metodos;

public class E4FcolasInversas {

	public static void main(String[] args) {
		ColaTDA cola1=new ColaPI();
		ColaTDA cola2=new ColaPI();
		cola1.InicializarCola();
		cola2.InicializarCola();
		cola1.Acolar(1);
		cola1.Acolar(2);
		cola1.Acolar(3);
		cola2.Acolar(3);
		cola2.Acolar(2);
		cola2.Acolar(1);
		System.out.print(metodos.colasInversas(cola1, cola2));

	}

}
