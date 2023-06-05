package Examen1Curs202122Rec;

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
			if (esq != null)	cont +=	esq.quants();
			if (dret != null)	cont +=	dret.quants();
			return cont;
		}
		
		public int te(Comparable e) {
			int m = inf.compareTo((Capitol) e);
			if (m == 0) return inf.getDurada();
			if (m > 0) {
				if (esq != null)
					return esq.te(e);
				return -1;
			}
			if (dret != null) return dret.te(e);
			return -1;
		}
		
	} // fi classe

	private NodeA arrel;

	public AcbEnll() {
		arrel = null;
	}
	
	public int quants() {
		if (arrel == null) return 0;
		return arrel.quants();
	}
	
	public int te(Comparable e) {
		if (arrel == null) return -1;
		return arrel.te(e);
	}
	
	/*
	 * implementació de totes les operacions de la interfície
	 */

	@Override
	public void Inserir(Comparable e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Esborrar(Comparable e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Membre(Comparable e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable Arrel() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb FillEsquerre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb FillDret() {
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
} // fi classe