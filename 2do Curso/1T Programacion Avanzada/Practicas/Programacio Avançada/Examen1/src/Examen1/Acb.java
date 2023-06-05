package Examen1;

public interface Acb<T extends Comparable<T>> {
	void Inserir(T e) throws Exception;

// excepció si l’element a inserir ja està a l’arbre
	void Esborrar(T e) throws Exception;

// excepció si l’element a esborrar no està a l’arbre
	boolean Membre(T e);

// true si l’element està a l’arbre, fals en cas contrari
	T Arrel() throws Exception;

// Si no és buit, retorna el contingut de l’arrel, en cas
// contrari llança una excepció
	Acb<T> FillEsquerre();

// tant si l’arbre this està buit com si no té fill esquerra retorna un arbre
// buit, en cas contrari retorna el subarbre esquerra
	Acb<T> FillDret();

// tant si l’arbre this està buit com si no té fill dret retorna un arbre
// buit, en cas contrari retorna el subarbre dret
	boolean ArbreBuit();

	void Buidar();
}