package MisApis;

public interface ColaTDA {
	void InicializarCola();
	void Acolar(int valor); //Precond: La cola debe estar inicializada
	void Desacolar();       //Precond: La cola debe estar incializada y no debe estar vacía
	boolean ColaVacia();    //Precond: La cola debe estar inicializada
	int Primero();          //Precond: La cola debe estar incializada y no debe estar vacía
}
