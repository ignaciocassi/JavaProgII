package MisApis;

public interface ABBTDA {
	void InicializarArbol();   
	int Raiz();                               //Precond: El arbol debe estar inicializado y no debe estar vacío.
	ABBTDA HijoIzq();                         //Precond: El arbol debe estar inicializado y no debe estar vacío.
	ABBTDA HijoDer();                         //Precond: El arbol debe estar inicializado y no debe estar vacío.
	boolean ArbolVacio();                     //Precond: El arbol dele estar inicicializado
	void AgregarElem(int elemento);           //Precond: El arbol dele estar inicicializado
	void EliminarElem(int elemento);          //Precond: El arbol dele estar inicicializado
}
