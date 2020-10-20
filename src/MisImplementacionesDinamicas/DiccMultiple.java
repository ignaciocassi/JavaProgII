package MisImplementacionesDinamicas;

import MisApis.ConjuntoTDA;
import MisApis.DiccMultipleTDA;

public class DiccMultiple implements DiccMultipleTDA {
	
	NodoClave origen;                      //Apunta al primer NodoClave
	
	class NodoClave {                               
		int clave;                         //Clave    
		NodoValor valores;                 //Primer NodoValor
		NodoClave sigClave;                //Siguiente NodoClave
	}

	class NodoValor {
		int valor;
		NodoValor sigValor;
	}
	
	public void inicializarDiccionario() {
		origen=null;
	}

	public void agregar(int clave, int valor) {
		//Existe la clave?
		NodoClave nc=Clave2NodoClave(clave);                 //Busca el NodoClave, con la clave. Si es null (no la encontró) lo crea
		if (nc==null) {
			nc=new NodoClave();
			nc.clave=clave;
			nc.sigClave=origen;
			origen=nc;
		}
		NodoValor aux=nc.valores;                            //Toma el primer valor (valores) en aux
		while(aux!=null && aux.valor!=valor) {               //Mientras que aux no sea null (llego al final) y que su valor no sea el valor a agregar
			aux=aux.sigValor;                                //Aux pasa a ser el sigValor de aux
		}
		if (aux==null) {                                     //Si llego al final (no lo encontro), crea el NodoValor con el valor
			NodoValor nv=new NodoValor();
			nv.valor=valor;                                  //Le agrega el valor
			nv.sigValor=nc.valores;                          //El siguiente del nuevo NodoValor es el primer NodoValor del NodoClave (nc.valores) 
			nc.valores=nv;                                   //El primer NodoValor (valores) del NodoClave pasa a ser el nuevo NodoValor
		}
	}

	private NodoClave Clave2NodoClave(int clave) {           //Recibe una clave, devuelve el nodoClave con la clave buscada
		NodoClave aux=origen;
		while(aux!=null && aux.clave!=clave) {
			aux=aux.sigClave;
		}
		return aux;
	}

	public void eliminarValor(int clave,int valor) {
		if (origen!=null) {
			if (origen.clave==clave) {
				EliminarValorEnNodo(origen,valor);
			}
		}
		else {
			NodoClave aux = origen;
			while (aux.sigClave != null && aux.sigClave.clave!=clave){
				aux = aux.sigClave;
			}
			if (aux.sigClave!= null ) {
				EliminarValorEnNodo(aux.sigClave , valor);
				if (aux.sigClave.valores== null ) {
					aux.sigClave= aux.sigClave.sigClave;
				}
			}
		}
	}

	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if(nodo.valores.valor==valor) {
			nodo.valores=nodo.valores.sigValor;
		}
		else {
			NodoValor aux=nodo.valores;
			while(aux.sigValor!=null && aux.sigValor.valor!=valor) {
				aux=aux.sigValor;
			}
			if(aux.sigValor!=null) {
				aux.sigValor=aux.sigValor.sigValor;
			}
		}
	}

	public ConjuntoTDA recuperar(int clave) {
		NodoClave n=Clave2NodoClave(clave);
		ConjuntoTDA c=new Conjunto();
		c.inicializarConjunto();
		if(n!=null) {
			NodoValor aux=n.valores;
			while(aux!=null) {
				c.agregar(aux.valor);
				aux=aux.sigValor;
			}
		}
		return c;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		NodoClave aux = origen;
		while (aux != null ){
			c.agregar(aux.clave);
			aux = aux.sigClave;
			}
		return c;
	}
}
