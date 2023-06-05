package Examen1Curs201819;

public class AcbEnll implements Acb {
	
	private class NodeA {
		Animal inf;
		NodeA esq, dret;
		
		public NodeA (Animal m, NodeA e, NodeA d) {
			inf = m;
			esq = e;
			dret = d;
		}
		
		private int quants() {
			int cont = 1;
			if (esq != null) cont = cont + esq.quants();
			if (dret != null) cont = cont + dret.quants();
			return cont;
		}
		
		private String quinCaracter(String nom) {
			int r = nom.compareTo(inf.getNom());
			if (r == 0) return ((Gos)inf).quinTe();
			if (r < 0)
				if (esq != null)
					return esq.quinCaracter(nom);
				else return null;
			else
				if (dret != null)
					return dret.quinCaracter(nom);
				else return null;
		}
	}
	
	private NodeA arrel;
	
	public AcbEnll() {
		arrel = null;
	}
	
	public int quantsArbre() {
		if (arrel==null) return 0;
		return arrel.quants();
	}
	
	public String quinCaracter(String nom) {
		if (arrel == null) return null;
		return arrel.quinCaracter(nom);
	}

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

}
