package Examen1Curs202122;

public class AcbEnll implements Acb {
	private class NodeA {
		Capitol inf; // La classe Capitol la trobaràs més endavant
		NodeA esq, dret;

		public NodeA(Capitol m, NodeA e, NodeA d) {
			inf = m;
			esq = e;
			dret = d;
		}
		
		public int quants() {
			int cont = 1;
			if (esq != null) cont += esq.quants();
			if (dret != null) cont += dret.quants();
			return cont;
		}
		
		public int te(Comparable e) {
			int m = inf.compareTo((Capitol)e);
			if (m == 0) return inf.getDurada();
			if (m > 0) {
				if (esq != null) return esq.te(e);
				return -1;
			}
			if (dret != null) return dret.te(e);
			return -1;
		}
		
		public String teDurada (int e) {
			String hiEs = null;
			if (inf.getDurada() == e) return inf.getTitol();
			if (esq != null) hiEs = esq.teDurada(e);
			if (hiEs == null && dret != null) return dret.teDurada(e);
			return hiEs;
		}
	} // fi classe

	private NodeA arrel;

	public AcbEnll() {
		arrel = null;
	}
	/*
	 * implementació de totes les operacions de la interfície
	 */
	
	public int quants() {
		if (arrel == null) return 0;
		return arrel.quants();
	}
	
	public int te(Comparable e) {
		if (arrel == null) return -1;
		return arrel.te(e);
	}
	
	public String teDurada (int temps) {
		if (arrel == null) return null;
		return arrel.teDurada(temps);
	}
	
} // fi classe