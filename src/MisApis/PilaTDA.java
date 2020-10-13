package MisApis;

public interface PilaTDA {
	void InicializarPila(); //Precond: La pila debe existir
	void Apilar(int valor);     //Precond: La pila debe estar inicializada
	void Desapilar();       //Precond: La pila debe estar inicializada y no debe estar vacía
	boolean PilaVacia();    //Precond: La pila debe estar inicializada
	int Tope();             //Precond: La pila debe estar inicializada
}
