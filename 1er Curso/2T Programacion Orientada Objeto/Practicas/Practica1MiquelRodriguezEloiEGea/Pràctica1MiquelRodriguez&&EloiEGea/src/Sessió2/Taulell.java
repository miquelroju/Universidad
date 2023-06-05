package Sessió2;

import java.util.*;

public class Taulell {
	private Paraula[][] taulell;
	private int parella;
	private static final String[] mots = { "Pato", "Cisne", "Elefante", "Gallo", "Tortuga", "Jaguar", "Serpiente",
			"Ganso", "Iguana", "Mantarraya", "Hormiga", "Langosta", "Armadillo", "Lobo", "Erizo", "Polilla", "Oso",
			"Cocodrilo" };

	public Taulell(int fil, int col) {
		this.taulell = new Paraula[fil][col];
		for (int i = 0; i < this.taulell.length; i++) {
			for (int j = 0; j < this.taulell[0].length; j++) {
				this.taulell[i][j] = null;
			}
		}
		this.parella = 0;
		emplena();
	}

	private void emplena() {
		int indice = 0, posX, posY, plenes = 0, cont = 0;
		Paraula p;
		Paraula calaix[] = new Paraula[mots.length]; // Paraules utilitzades es guarden a calaix

		while (cont != this.taulell.length * this.taulell[0].length) {

			indice = rnd(mots.length);
			p = new Paraula(mots[indice]);
			while (estaGuardada(calaix, plenes, p)) {
				indice = rnd(mots.length);
				p = new Paraula(mots[indice]);
			}
			guardar(calaix, plenes, indice);
			plenes++;

			for (int i = 0; i < 2; i++) {
				posX = rnd(this.taulell.length);
				posY = rnd(this.taulell[0].length);

				while (taulell[posX][posY] != null) {
					posX = rnd(this.taulell.length);
					posY = rnd(this.taulell[0].length);
				}
				this.taulell[posX][posY] = p;
			}
			cont += 2;
		}
	}

	private static int rnd(int m) {
		Random rnd = new Random();
		return rnd.nextInt(m);
	}

	private void guardar(Paraula[] c, int plenes, int indice) {
		Paraula aux = new Paraula(mots[indice]);
		c[plenes] = aux;
	}

	private boolean estaGuardada(Paraula[] c, int plenes, Paraula p) {
		for (int i = 0; i < plenes; i++) {
			if (c[i].iguals(p)) {
				return true;
			}
		}
		return false;
	}

	public void mostrar(int fil1, int col1, int fil2, int col2) {
		for (int i = 0; i < this.taulell.length; i++) {
			for (int j = 0; j < this.taulell[0].length; j++) {

				if ((i == fil1 && j == col1) || (i == fil2 && j == col2) || aparellada(i, j)) {
					this.taulell[i][j].mostraParaula();

				} else {
					System.out.print("Tapada");
					for (int x = 0; x < 9; x++) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	public boolean fanParella(int fil1, int col1, int fil2, int col2) {
		if (this.taulell[fil1][col1].iguals(this.taulell[fil2][col2])) {
			this.taulell[fil1][col1].setParella();
			this.taulell[fil2][col2].setParella();
			this.parella += 2;
			return true;
		}
		return false;
	}

	public boolean aparellada(int fil, int col) {
		return this.taulell[fil][col].getParella();
	}

	public boolean fiJoc() {
		if (this.parella == this.taulell.length * this.taulell[0].length) {
			return true;
		}
		return false;
	}

}
