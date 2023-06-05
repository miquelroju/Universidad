package Examen1;

public class AcbEnll implements Acb<ContenidorBrossa> {
	private class NodeA {
		ContenidorBrossa inf;
		NodeA esq, dret;

		public NodeA(ContenidorBrossa m, NodeA e, NodeA d) {
			inf = m;
			esq = e;
			dret = d;
		}

		public int quants() {
			int quants = 1;
			if (esq != null) {
				quants++;
				return esq.quants();
			}
			if (dret != null) {
				quants++;
				return dret.quants();
			}
			return quants;
		}
		
		public ContenidorBrossa contenidorCodiMesPetit(String codi) {
			while (esq != null) {
				if(arrel.inf.getCodi().compareTo(codi) == 0) return arrel.inf;
				arrel.esq = arrel.esq.esq;
			}
			while (dret != null) {
				if (arrel.inf.getCodi().compareTo(codi) == 0) return arrel.inf;
				arrel.dret = arrel.dret.dret;
			}
			return null;
		}
	} // fi classe

	private NodeA arrel;

	public AcbEnll() {
		arrel = null;
	}

	/*
	 * implementaci� de tots els m�todes de la interf�cie
	 */
	public int quants(ContenidorBrossa c) {
		if (arrel == null)
			return 0;
		return arrel.quants();
	}

	public ContenidorBrossa max() {
		int max = 0;
		ContenidorBrossa con = null;
		while (arrel.esq != null) {
			int q = arrel.quants();
			if (q > max) {
				max = q;
				con = arrel.inf;
			}
			arrel.esq = arrel.esq.esq;
		}
		while (arrel.dret != null) {
			int q = arrel.quants();
			if (q > max) {
				max = q;
				con = arrel.inf;
			}
			arrel.dret = arrel.dret.dret;
		}
		return con;
	}

	public String toString() {
		String s = "";
		if (arrel == null)
			return s;
		return arrel.inf.toString();
	}

	public String color(int color) {
		switch (color) {
		case 0:
			return "groc";
		case 1:
			return "marro";
		case 2:
			return "gris";
		case 3:
			return "verd";
		case 4:
			return "blau";
		}
		return "";
	}
	
	public String codiMesPetit(int color) {
		String codi = "";
		if (arrel == null) return codi;
		if (arrel.esq != null) {
			String cod = arrel.inf.getCodi();
			if (codi.compareTo(cod) < 0) {
				codi = cod;
			}
			arrel.esq = arrel.esq.esq;
		}
		if (arrel.dret != null) {
			String cod = arrel.inf.getCodi();
			if (codi.compareTo(cod) < 0) {
				codi = cod;
			}
			arrel.dret = arrel.dret.dret;
		}
		return codi;
	}
	
	public ContenidorBrossa contenidorCodiMesPetit(String codi) {
		if (arrel == null) return null;
		return arrel.contenidorCodiMesPetit(codi);
	}
} // fi classe