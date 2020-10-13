package MisTests;

import MisApis.ColaPrioridadTDA;
import MisImplementacionesEstaticas.ColaPrioridad;
import MisMetodos.metodos;

public class E6AcombinarDosColasP {

	public static void main(String[] args) {
		ColaPrioridadTDA CP1=new ColaPrioridad();
		ColaPrioridadTDA CP2=new ColaPrioridad();
		CP1.InicializarCola();
		CP2.InicializarCola();

		metodos.llenarColaPrioridad(CP1, 1, 5, 1);
		metodos.llenarColaPrioridad(CP2, 6, 10, 1);
		
		System.out.println("CP1: ");
		metodos.mostrarColaPrioridad(CP1);
		
		System.out.println("CP2: ");
		metodos.mostrarColaPrioridad(CP2);
		
		ColaPrioridadTDA colaPComb=new ColaPrioridad();
		colaPComb.InicializarCola();
		colaPComb=metodos.combinarColasPrioridad(CP1, CP2);
		
		System.out.println("ColaPComb: ");
		metodos.mostrarColaPrioridad(colaPComb);
	}

}
