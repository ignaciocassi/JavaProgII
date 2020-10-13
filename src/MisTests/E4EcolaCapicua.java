package MisTests;

import MisApis.ColaTDA;
import MisImplementacionesEstaticas.ColaPI;
import MisMetodos.metodos;

public class E4EcolaCapicua {
	public static void main(String[] args) {
		ColaTDA cola = new ColaPI();
		cola.InicializarCola();
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		cola.Acolar(2);
		cola.Acolar(1);
		System.out.println(metodos.colaCapicua(cola));
	}
}
