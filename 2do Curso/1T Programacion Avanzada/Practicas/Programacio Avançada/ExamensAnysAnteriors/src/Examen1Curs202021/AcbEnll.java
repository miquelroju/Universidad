package Examen1Curs202021;

import Examen1Curs202021.DossierProblemesPPAI.ExcepcioDossier;

public class AcbEnll<T extends Comparable<T>> implements Acb<T> {
	private class NodeA {
		T inf;
		NodeA esq, dret;

		public NodeA(T m, NodeA e, NodeA d) {
			inf = m;
			esq = e;
			dret = d;
		}

		public void percentatge(int[] calcul) {
			calcul[1]++;
			if (((ExerciciPPAI)inf).grauDificultat() == ExerciciPPAI.moltDificil) calcul[0]++;
			if (esq != null) esq.percentatge(calcul);
			if (dret != null) dret.percentatge(calcul);
		}
		
		public int ExerciciExamenAmbProcediments() {
			int quina = -1;
			if (esq != null) quina = esq.ExerciciExamenAmbProcediments();
			if (quina != -1) return quina;
			if (inf instanceof ExerciciProcediments) return ((ExerciciProcediments)inf).grauDificultat();
			if (dret != null) return dret.ExerciciExamenAmbProcediments();
			return quina;
		}
	} // fi classe

	private NodeA arrel;

	public AcbEnll() {
		arrel = null;
	}
	/* implementació de totes les operacions de la interfície */

	@Override
	public void Inserir(Comparable<T> e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Esborrar(Comparable<T> e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Membre(Comparable<T> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable<T> Arrel() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb<T> FillEsquerre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb<T> FillDret() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ArbreBuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Buidar() {
		// TODO Auto-generated method stub
		
	}
	
	public double percentatge() {
		if (arrel == null) return 0.0F;
		int[] calcul = {0 , 0};
		arrel.percentatge(calcul);
		return calcul[0] * 1.0 / calcul[1];
	}
	
	public int ExerciciExamenAmbProcediments() throws ExcepcioDossier {
		if (arrel == null) throw new ExcepcioDossier("No hi ha cap");
		int quin = arrel.ExerciciExamenAmbProcediments();
		if (quin == -1) throw new ExcepcioDossier("No hi ha cap");
		else return quin;
	}
	
	
	
	
	
	
} // fi classe