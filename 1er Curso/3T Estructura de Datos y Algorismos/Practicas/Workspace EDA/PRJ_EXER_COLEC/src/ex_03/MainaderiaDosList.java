package ex_03;

import p0_material.Criatura;
import java.util.*;

/* implementaci� de la interficie MainaderiaDos basada en List */
public class MainaderiaDosList implements MainaderiaDos {

	private List<Criatura> infrastructura; // llista que far�, com el seu nom
	// indica, d'infrastructura per a guardar les criatures

	public MainaderiaDosList() {
		// constructor
		/* ENCARA S'HA DE COMPLETAR */
		infrastructura = new LinkedList<>();
	}

	@Override
	public boolean matricular(String nom, int edat, int sexe) {
		Criatura nou;
		try {
			nou = new Criatura(nom, edat, sexe);

			if (infrastructura.contains(nou)) {
				return false;
			}

			infrastructura.add(nou);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Criatura desMatricular(String nom) {

		Criatura nou = new Criatura(nom, 1, Criatura.NEN);

		Iterator<Criatura> it = infrastructura.iterator();

		int pos = infrastructura.indexOf(nou);
		if (pos >= 0) {
			// Criatura resultat = infrastructura.get(pos);
			return infrastructura.remove(pos);
			// return resultat;
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criatura buscar(String nom) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double edatMitjana() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double edatMitjana(int sexe) {

		int totalNens = 0, totalEdat = 0;
		for (Criatura nen : infrastructura) {
			if (nen.getSexe() == sexe) {
				totalEdat += nen.getEdat();
				totalNens++;
			}

		}

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection lesNenes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection elsNens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		Iterator<Criatura> it = infrastructura.iterator();
		return it;

	}

	/* CAL IMPLEMENTAR TOTS ELS M�TODES DEFINITS A LA INTERFICIE */

}
