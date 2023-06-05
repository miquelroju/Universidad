package Examen1Curs202021;

public interface Acb<T extends Comparable<T>> {
	void Inserir(Comparable<T> e) throws Exception;

// excepció si l’element a inserir ja està a l’arbre
	void Esborrar(Comparable<T> e) throws Exception;

// excepció si l’element a esborrar no està a l’arbre
	boolean Membre(Comparable<T> e);

// true si l’element està a l’arbre, false en cas contrari
	Comparable<T> Arrel() throws Exception;

// Si no és buit, retorna el contingut de l’arrel, en cas
// contrari llança una excepció
	Acb<T> FillEsquerre();

// no llença excepció, tant si l’arbre this està buit com si no té
// fill esquerra retorna un arbre buit
	Acb<T> FillDret();

// no llença excepció, tant si l’arbre this està buit com si no té
// fill dret retorna un arbre buit
	boolean ArbreBuit();

	void Buidar();
} // fi interfície