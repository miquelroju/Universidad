package Examen1Curs202122;

public class Plataforma {
	private Produccio[][] cartera;
	private int[] comptadors; // posicions plenes fila 0, 1, 2 i 3 respectivament

	// Fila 0 pelicules
	// Fila 1 documentals
	// Fila 2 Concerts
	// Fila 3 Series

	public Plataforma(int quantes) {
		this.cartera = new Produccio[4][quantes];
		this.comptadors = new int[4];
		for (int i = 0; i < 4; i++)
			comptadors[i] = 0;
	}

	private static boolean hiEs(Produccio p, Produccio m[], int quantes) {
		for (int i = 0; i < quantes; i++) {
			if (m[i].iguals(p))
				return true;
		}
		return false;
	}

	public boolean afegirProduccio(Produccio p) {
		if (this.comptadors[p.getTipus()] < this.cartera[p.getTipus()].length
				|| !hiEs(p, this.cartera[p.getTipus()], this.comptadors[p.getTipus()])) {
			return false;
		}
		this.cartera[p.getTipus()][this.comptadors[p.getTipus()]] = p;
		this.comptadors[p.getTipus()]++;
		return true;
	}

	public void eliminarProducio(Produccio p) {
		for (int i = 0; i < this.comptadors[p.getTipus()]; i++) {
			if (this.cartera[p.getTipus()][i].iguals(p)) {
				this.cartera[p.getTipus()][i] = this.cartera[p.getTipus()][this.comptadors[p.getTipus() - 1]];
				this.comptadors[p.getTipus()]--;
				return;
			}
		}
	}

	public void eliminarProduccio(int any) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < this.comptadors[i]; j++) {
				if (this.cartera[i][j].getAny() == any) {
					this.eliminarProducio(this.cartera[i][j]);
					j--;
				}
			}
		}
	}
	
	public int tipusProduccions() {
		int max = -1, cont;
		for (int i = 0; i < this.cartera.length; i++) {
			cont = 0;
			for (int j = 0; j < this.comptadors[i]; j++) {
				if (this.cartera[i][j].getAny() > 2000)
					cont++;
			}
			if (max < cont) {
				max = cont;
			}
		}
		return max;
	}
	
	public Plataforma mesGran(Plataforma c) {
		int quants1 = 0, quants2 = 0;
		for (int i = 0; i < 4; i++) {
			quants1 += this.comptadors[i];
			quants2 += c.comptadors[i];
		}
		if (quants1 > quants2)
			return this;
		return c;
	}

}
