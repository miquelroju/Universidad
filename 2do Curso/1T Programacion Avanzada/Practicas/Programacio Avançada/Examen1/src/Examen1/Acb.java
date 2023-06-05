package Examen1;

public interface Acb<T extends Comparable<T>> {
	void Inserir(T e) throws Exception;

// excepci� si l�element a inserir ja est� a l�arbre
	void Esborrar(T e) throws Exception;

// excepci� si l�element a esborrar no est� a l�arbre
	boolean Membre(T e);

// true si l�element est� a l�arbre, fals en cas contrari
	T Arrel() throws Exception;

// Si no �s buit, retorna el contingut de l�arrel, en cas
// contrari llan�a una excepci�
	Acb<T> FillEsquerre();

// tant si l�arbre this est� buit com si no t� fill esquerra retorna un arbre
// buit, en cas contrari retorna el subarbre esquerra
	Acb<T> FillDret();

// tant si l�arbre this est� buit com si no t� fill dret retorna un arbre
// buit, en cas contrari retorna el subarbre dret
	boolean ArbreBuit();

	void Buidar();
}