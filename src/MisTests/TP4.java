package MisTests;

import MisApis.ABBTDA;
import MisImplementacionesDinamicas.ABB;
import MisMetodos.metodosABBconInstancia;

public class TP4 {

	public static void main(String[] args) {
		/**Dado que los metodos externos solicitados de Arbol Binario utilizan la palabra clave this, que no puede ser utilizada en una clase estática,
		cree una nueva clase MisMetodos.metodosABBconInstancia, la cual será instanciada para resolver los ejercicios de este TP4**/
		 
		//EjecutarElementoEstaEnABB();            //E3A
		//EjecutarElementoEsHojaEnABB();          //E3B
		//EjecutarCalcularProfundidadElemEnABB(); //E3C
		//EjecutarObtenerMenorElemABB();          //E3D
		//EjecutarContarElemABB();                //E3E
		//EjecutarSumarElemABB();                 //E3F
		//EjecutarContarHojasABB();               //E3G
		//EjecutarMostrarABBPreOrder();           //ELI
		//EjecutarMostrarABBInOrder();            //ELII
		//EjecutarMostrarABBPostOrder();          //ELIII
		
		
	}

	public static void EjecutarMostrarABBPostOrder() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		System.out.println("Pre order: ");
		metodosABBconInstancia.preOrder(abb);
		
	}

	public static void EjecutarMostrarABBInOrder() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		System.out.println("In order: ");
		metodosABBconInstancia.inOrder(abb);
		
	}

	public static void EjecutarMostrarABBPreOrder() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		System.out.println("Post order: ");
		metodosABBconInstancia.postOrder(abb);
		
	}

	public static void EjecutarContarHojasABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		int canthojas;
		canthojas=metodosABBconInstancia.contarHojasABB(abb);
		System.out.println("La cantidad de hojas en el ABB es: "+canthojas);
		
	}

	public static void EjecutarSumarElemABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		int sumaelem;
		sumaelem=metodosABBconInstancia.sumarElemABB(abb);
		System.out.println("La suma de los elementos del ABB es: "+sumaelem);
		
	}

	public static void EjecutarContarElemABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		int cantelem;
		cantelem=metodosABBconInstancia.contarElemABB(abb);
		System.out.println("La cantidad de elementos en el ABB es: "+cantelem+".");
		
	}

	public static void EjecutarObtenerMenorElemABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		int menorelem=metodosABBconInstancia.menorElemABB(abb);
		System.out.println("El menor elemento del ABB es: "+menorelem+".");
	}

	public static void EjecutarCalcularProfundidadElemEnABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		int elemento=10;
		metodosABBconInstancia metabb=new metodosABBconInstancia();
		int profundidad=metabb.calcularProfundidadElemABB(abb, elemento);
		System.out.println("La profundidad del elemento "+elemento+" es "+profundidad+".");
		
	}

	public static void EjecutarElementoEsHojaEnABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
		
		abb.AgregarElem(5);
		abb.AgregarElem(10);
		abb.AgregarElem(15);
		abb.AgregarElem(8);
		
		int elemento=10;
		metodosABBconInstancia metabb=new metodosABBconInstancia();
		boolean eselemento=metabb.elementoEsHojaEnABB(abb, elemento);
		if (eselemento==true) {
			System.out.println("El elemento "+elemento+" es hoja en el ABB.");
		} else {
			System.out.println("El elemento no es hoja en el ABB");
		}
	}

	public static void EjecutarElementoEstaEnABB() {
		ABBTDA abb=new ABB();
		abb.InicializarArbol();
			
		abb.AgregarElem(100);
		abb.AgregarElem(200);
		abb.AgregarElem(50);
		abb.AgregarElem(150);
		abb.AgregarElem(250);
		abb.AgregarElem(25);
		abb.AgregarElem(75);
			
		int elemento=150;
		
		boolean presente;
		metodosABBconInstancia metABB=new metodosABBconInstancia();
		presente=metABB.elementoEstaEnABB(abb, elemento);
		if (presente) {
			System.out.println("El elemento "+elemento+" está en el ABB.");
		} else {
			System.out.println("El elemento "+elemento+" no está en el ABB.");
		}
		
	}
	
}
