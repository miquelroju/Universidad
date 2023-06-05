package Examen1;

public class Poblacio {

	private class NodeU {
		private Ubicacio inf;
		private int quants; // quants contenidors hi ha a la ubicacio
		private NodeU seg;

		public NodeU(Ubicacio on, NodeU seg) {
			this.inf = on;
			this.quants = 0;
			this.seg = seg;
		}

		public boolean hiEs(ContenidorBrossa f) {
			for (int i = 0; i < contenidors.length; i++) {
				for (int j = 0; j < contenidors[i].length; j++) {
					if (contenidors[i][j].Membre(f))
						return true;
				}
			}
			return false;
		}

		public void Inserir(ContenidorBrossa f) {
			try {
				contenidors[contenidors.length][contenidors[contenidors.length].length].Inserir(f);
				NodeU contenidor = new NodeU(f.getUbicacio(), ubicacions.seg);
				ubicacions.seg = contenidor;
			} catch (Exception e) {

			}
		}

		public void Esborrar(ContenidorBrossa f) {
			try {
				contenidors[contenidors.length][contenidors[contenidors.length].length].Esborrar(f);
			} catch (Exception e) {

			}
		}
	}

	private NodeU ubicacions; // sequencia enlla�ada d'ubicacions de la poblacio on hi ha contenidors

	private AcbEnll contenidors[][];

	public Poblacio() {
		contenidors = new AcbEnll[6][3];
		for (int i = 0; i < contenidors.length; i++) {
			for (int j = 0; j < contenidors[i].length; j++) {
				contenidors[i][j] = new AcbEnll();
			}
		}
		ubicacions = null;
	}

	public Ubicacio MesContenidors() {
		if (ubicacions == null)
			return null;
		Ubicacio ubi = new Ubicacio(null, 0);
		int max = 0;
		while (ubicacions.seg != null) {
			int q = ubicacions.quants;
			if (q > max) {
				max = q;
				ubi = ubicacions.inf;
			}
		}
		return ubi;
	}

	public void afegirContenidor(ContenidorBrossa f) {
		if (!ubicacions.hiEs(f)) {
			ubicacions.Inserir(f);
			ubicacions.quants++;
		}
	}

	public void eliminarContenidor(ContenidorBrossa f) {
		if (ubicacions.hiEs(f)) {
			ubicacions.Esborrar(f);
			ubicacions.quants--;
			if (ubicacions.quants == 0) {
				ubicacions = null;
			}
		}
	}

	public ContenidorBrossa mesReciclatOrganic(int estat) throws Exception {
		try {
			return contenidors[1][estat].max();
		} catch (Exception e) {
			throw new Exception("No hi ha contenidors organic en aquest estat");
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < contenidors.length - 1; i++) {
			s += contenidors[i][2].toString();
			s += "\n";
		}
		return s;
	}

	public String menorCodi(int color) {
		ContenidorBrossa contenidor = null;
		for (int i = 0; i < contenidors[color].length; i++) {
			contenidor = contenidors[color][i].contenidorCodiMesPetit(contenidors[color][i].codiMesPetit(color));		
		}
		if (contenidor.getCodi() == null) return null;
		return contenidor.getCodi();
	}
}
