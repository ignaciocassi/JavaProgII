package MisApis;

public interface ABBTDA {
	int Raiz();                               //Precond: El arbol no debe estar vacío y debe star inicicializado
	ABBTDA HijoIzq();                         //Precond: El arbol no debe estar vacío y debe star inicicializado
	ABBTDA HijoDer();                         //Precond: El arbol no debe estar vacío y debe star inicicializado
	boolean ArbolVacio();                     //Precond: El arbol dele estar inicicializado
	void InicializarArbol();            
	void AgregarElem(int elemento);           //Precond: El arbol dele estar inicicializado
	void EliminarElem(int elemento);          //Precond: El arbol dele estar inicicializado
}
