package MisApis;

public interface DiccMultipleTDA {
	void inicializarDiccionario();
	void agregar(int clave, int valor);    //Precond: El diccionario debe estar inicializado
	void eliminarValor(int clave, int valor);//Precond: El diccionario debe estar inicializado y la clave debe existir
	ConjuntoTDA recuperar(int clave);      //Precond: El diccionario debe estar inicializado
	ConjuntoTDA claves();                  //Precond: El diccionario debe estar inicializado
}
