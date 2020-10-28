package MisApis;

public interface ConjuntoTDA {
	void inicializarConjunto();
	boolean conjuntoVacio();       //Precond: El conjunto debe estar inicializado
	void agregar(int valor);       //Precond: El conjunto debe estar inicializado
	int elegir();                  //Precond: El conjunto debe estar inicializado  y no est� vac�o
	void sacar(int valor);         //Precond: El conjunto debe estar inicializado
	boolean pertenece(int valor);  //Precond: El conjunto debe estar inicializado
}
