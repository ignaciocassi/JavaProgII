package MisMetodos;

import MisApis.ABBTDA;

public class metodosABBconInstancia {
	public boolean elementoEstaEnABB(ABBTDA abb, int elemento) {
		if(abb.ArbolVacio()) {                                         //Si el arbol esta avacio, devuelve false
			return false;
		} else if (abb.Raiz()==elemento){                              //Si el elemento está en la raíz actual, devuelve true
			return true;
		} else if (abb.Raiz()>elemento) {                              //Si el elemento es menor que la raíz, lo busca en la izquierda
			return this.elementoEstaEnABB(abb.HijoIzq(), elemento); 
		} else {                                                       //Si el elemento es mayor que la raíz, lo busca en la derecha
			return this.elementoEstaEnABB(abb.HijoDer(), elemento);
		}
	}
	
	public boolean elementoEsHojaEnABB(ABBTDA abb, int elemento) {
		if(abb.ArbolVacio()) {                                         
			return false;
		} else if (abb.Raiz()==elemento){
			return (abb.HijoDer().ArbolVacio() && abb.HijoIzq().ArbolVacio());
		} else if (abb.Raiz()>elemento) {                              
			return this.elementoEstaEnABB(abb.HijoIzq(), elemento); 
		} else {                                                       
			return this.elementoEstaEnABB(abb.HijoDer(), elemento);
		}
	}

	public int calcularProfundidadElemABB(ABBTDA abb, int elemento) {
		if(abb.ArbolVacio()) {                                         
			return 0;
		} else if (abb.Raiz()==elemento){
			return 0;
		} else if (abb.Raiz()>elemento) {                             
			return (1+this.calcularProfundidadElemABB(abb.HijoIzq(), elemento)); 
		} else {                                                       
			return (1+this.calcularProfundidadElemABB(abb.HijoDer(), elemento));
		}
	}
	
	public static int contarElemABB(ABBTDA a){
		if (a.ArbolVacio()){
			return 0;
		} else {
			return (1 + contarElemABB(a.HijoIzq()) + contarElemABB(a.HijoDer()));
		}
	}
	
	public static int contarHojasABB(ABBTDA a){
		if (a.ArbolVacio()){
			return 0;
		} else {
			if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()) {
				return (1 + contarHojasABB(a.HijoIzq()) + contarHojasABB(a.HijoDer()));
			} else {
				return (0 + contarHojasABB(a.HijoIzq()) + contarHojasABB(a.HijoDer()));
			}
		}
	}
	
	public static int sumarElemABB(ABBTDA a){
		if (a.ArbolVacio()){
			return 0;
		} else {
			return (a.Raiz() + sumarElemABB(a.HijoIzq()) + sumarElemABB(a.HijoDer()));
		}
	}
	
	//Devuelve el menor elemento de un ABB
	public static int menorElemABB(ABBTDA a) {
		if (a.ArbolVacio()) {
			return -1;
		} else {
			if (a.HijoIzq().ArbolVacio()) {
				return a.Raiz();
			} else {
				return menorElemABB(a.HijoIzq());
			}
		}
	}
			
	//Devuelve el mayor elemento de un ABB
	public static int mayorElemABB(ABBTDA a) {
		if (a.ArbolVacio()) {
			return -1;
		} else {
			if (a.HijoDer().ArbolVacio()) {
				return a.Raiz();
			} else {
				return mayorElemABB(a.HijoDer());
			}
		}
	}
	
	//Métodos para mostrar Arboles Binarios
	//Pre-Order
	public static void preOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}
		
	//In-Order
	public static void inOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			preOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			preOrder(a.HijoDer());
		}
	}
			
	//Post-Order
	public static void postOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}
}
