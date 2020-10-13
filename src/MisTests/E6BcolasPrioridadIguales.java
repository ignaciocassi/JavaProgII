package MisTests;

import MisApis.ColaPrioridadTDA;
import MisImplementacionesEstaticas.ColaPrioridad;
import MisMetodos.metodos;

public class E6BcolasPrioridadIguales {

	public static void main(String[] args) {
		ColaPrioridadTDA CP1=new ColaPrioridad();
		ColaPrioridadTDA CP2=new ColaPrioridad();
		CP1.InicializarCola();
		CP2.InicializarCola();
		metodos.llenarColaPrioridad(CP1,1,5,1);
		metodos.llenarColaPrioridad(CP2,1,5,1);
		System.out.println(metodos.colasPrioridadIguales(CP1, CP2));
	}

}
