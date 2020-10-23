package MisImplementacionesDinamicas;

import MisApis.ABBTDA;

public class ABB implements ABBTDA {
	
	class NodoABB{
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	NodoABB raiz;
	
	public int Raiz() {
		return raiz.info;
	}

	public ABBTDA HijoIzq() {
		return raiz.hijoIzq;
	}

	
	public ABBTDA HijoDer() {
		return raiz.hijoDer;
	}

	public boolean ArbolVacio() {
		return (raiz==null);
	}


	public void InicializarArbol() {
		raiz=null;
	}

	public void AgregarElem(int elemento) {
		if(raiz==null) {                      //Si no existe un NodoABB en raíz, lo crea, con su elemento, crea sus HijoIzq e HijoDer y los inicializa
			raiz=new NodoABB();                
			raiz.info=elemento;
			raiz.hijoIzq=new ABB();
			raiz.hijoIzq.InicializarArbol();
			raiz.hijoDer=new ABB();
			raiz.hijoDer.InicializarArbol();
		}
		else if (elemento<raiz.info) {         
			raiz.hijoIzq.AgregarElem(elemento);
		}
		else if (elemento>raiz.info) {
			raiz.hijoDer.AgregarElem(elemento);
		}
	}

	public void EliminarElem(int elemento) {
		if (raiz!=null) {                                                                           //Si el arbol no esta vacio
			if(raiz.info==elemento && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {     //Si el elemento a eliminar es la raiz y ambos hijos estan vacios (es hoja)
				raiz=null;                                                                          //La raiz vuelve a null, queda vacío
			}
			else if (raiz.info==elemento && !raiz.hijoIzq.ArbolVacio()) {                           //Si el elemento a eliminar es la raiz y el hijo izq no esta vacío (no es hoja)
				raiz.info=this.mayor(raiz.hijoIzq);                                                 //Busca el mayor de los menores, porque hay menores (izquierda)
				raiz.hijoIzq.EliminarElem(raiz.info);                                               //Reemplaza por el mayor de los menores
			}
			else if (raiz.info==elemento && raiz.hijoIzq.ArbolVacio()) {                            //Si el elemento a eliminar es la raiz y el hijo der no esta vacío (no es hoja)
				raiz.info=this.menor(raiz.hijoDer);                                                 //Busca el menor de los mayores, porque hay mayores (derecha)
				raiz.hijoDer.EliminarElem(elemento);
			}
			else if (elemento>raiz.info) {                                                          //Si no encontro la raiz con el
				raiz.hijoDer.EliminarElem(elemento);
			}
			else {
				raiz.hijoIzq.EliminarElem(elemento);
			}
		}
	
	}

	private int menor(ABBTDA a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		} else {
			return menor(a.HijoIzq());
		}
	}

	private int mayor(ABBTDA a) {
		if (a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		} else {
			return mayor(a.HijoDer());
		}
	}

}
