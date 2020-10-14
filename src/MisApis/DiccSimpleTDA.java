package MisApis;

public interface DiccSimpleTDA {
	void inicializarDiccionario();
	void agregar(int clave, int valor);      //Precond: El diccionario debe estar inicializado
	void eliminar(int clave);                //Precond: El diccionario debe estar inicializado
	int recuperar(int clave);                //Precond: El diddionario debe estar inicializado y la clave debe existir
	ConjuntoTDA claves();                    //Precond: El diccionario debe estar inicializado
}
