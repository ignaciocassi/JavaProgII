package MisApis;

public interface ColaPrioridadTDA {
	void InicializarCola();
	void Acolar(int valor, int prioridad); //Precond: La cola debe estar inicializada
	void Desacolar();                      //Precond: La cola debe estar inicializada y no debe estar vacía
	int Primero();                         //Precond: La cola debe estar inicializada y no debe estar vacía
	boolean ColaVacia();                   //Precond: La cola debe estar inicializada
	int Prioridad();                       //Precond: La cola debe estar inicializada
}
