package Sessio1;

import Keyboard.*;
import java.util.*;

public class Memory {

	public static void main(String[] args) {
		char jugar = 's';
		System.out.println("JOC DEL MEMORY. ENTRA LES DIMENSIONS DEL TAULELL");
		System.out.println("************************************************");
		while (jugar == 's' || jugar == 'S') {
			int fil = fil(); // hacer t string f1c1f2c2
			int col = col();
			while (fil * col > 36 || fil * col % 2 != 0) {
				System.out.println("Dimensions incorrectes. Entra nous valors");
				fil = fil();
				col = col();
			}
			boolean[][] tBool = ompleTapat(fil, col);
			String t[][] = ompleTaulell(fil, col);
			imprimir(t, tBool);// Taulell inicial

			System.out.println("COMENÇA EL JOC. ESPECIFICA LES CARTES QUE VOLS GIRAR");
			System.out.println("****************************************************");
			int cartes = fil * col;
			int f1, c1, f2, c2;
			String arg[] = Arg(fil, col);
			while (cartes != 0) {
				do {
					f1 = carta(fil, arg[0]);
					c1 = carta(col, arg[1]);
					while (tBool[f1][c1]) {
						System.out.println("Ja esta girada!!!");
						f1 = carta(fil, arg[0]);
						c1 = carta(col, arg[1]);
					}
					f2 = carta(fil, arg[2]);
					c2 = carta(col, arg[3]);
					while (tBool[f2][c2]) {
						System.out.println("Ja esta girada");
						f2 = carta(fil, arg[2]);
						c2 = carta(col, arg[3]);
					}
				} while (f1 == f2 && c1 == c2);

				// evitar la mateixa carta

				if (parella(t[f1][c1], t[f2][c2])) {
					System.out.println("Fan parella!");
					System.out.println("------------");
					girar(tBool, f1, c1, f2, c2);
					cartes -= 2;
				} else {
					System.out.println("NO Fan parella!. Observa!!!");
					girar(tBool, f1, c1, f2, c2);
					imprimir(t, tBool); // mostra les cartes i les torna a tapar
					girar(tBool, f1, c1, f2, c2);
				}
				System.out.println("ESTAT DEL TAULELL");
				imprimir(t, tBool); // mostrar com esta el taulell
				// System.out.println(cartes);
			}
			System.out.println("Felicitats! Joc acabat");
			System.out.println("Vols tornar a jugar? S/s --> si");
			jugar = Keyboard.readChar(); // tornar a jugar
			if (jugar == 's' || jugar == 'S') {
				System.out.println("Iniciem una nova partida");
				System.out.println("************************");
			}
		}
		System.out.println("Ádeu");

	}

	private static int fil() {
		int fil;
		do {
			System.out.println("Indica el número de files:");
			fil = Keyboard.readInt();
		} while (fil < 0);
		return fil;
	}

	private static int col() {
		int col;
		do {
			System.out.println("Indica el número de columnes:");
			col = Keyboard.readInt();
		} while (col < 0);
		return col;
	}

	private static String[][] crearTaulell(int f, int c) {
		String[][] t = new String[f][c];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = " ";
			}
		}
		return t;
	}

	private static String[][] ompleTaulell(int f, int c) {
		String[][] t = crearTaulell(f, c);
		int quantes = (f * c) / 2;
		String[] paraules = paraules();

		while (quantes != 0) {

			int posX = pos(f);
			int posY = pos(c);
			int p = pos(paraules.length);

			while (paraules[p].equals(" ")) {
				p = pos(paraules.length);
			}
			for (int i = 0; i < 2; i++) {
				while (!(t[posX][posY].equals(" "))) {
					posX = pos(f);
					posY = pos(c);
				}
				t[posX][posY] = paraules[p];
			}
			paraules = eliminaParaula(paraules, p);
			quantes--;
		}
		return t;
	}

	private static boolean[][] crearTapat(int f, int c) {
		boolean[][] t = new boolean[f][c];
		return t;
	}

	private static boolean[][] ompleTapat(int f, int c) {
		boolean[][] t = crearTapat(f, c);
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = false;
			}
		}
		return t;
	}

	private static String[] eliminaParaula(String[] paraules, int p) {
		paraules[p] = " ";
		return paraules;
	}

	private static int pos(int m) {
		Random rnd = new Random();
		return rnd.nextInt(m);
	}

	private static String[] paraules() {

		String[] baralla = { "Pato", "Cisne", "Elefante", "Gallo", "Tortuga", "Jaguar", "Serpiente", "Ganso", "Iguana",
				"Mantarraya", "Hormiga", "Langosta", "Armadillo", "Lobo", "Erizo", "Polilla", "Oso", "Cocodrilo" };
		return baralla;

	}

	private static void girar(boolean[][] t, int f1, int c1, int f2, int c2) {
		t[f1][c1] = !t[f1][c1];
		t[f2][c2] = !t[f2][c2];
	}

	private static void imprimir(String[][] t, boolean tBool[][]) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (tBool[i][j]) {
					System.out.print(t[i][j]);
					for (int f = 0; f < (15 - t[i][j].length()); f++) {
						System.out.print(" ");
					}
				} else {

					System.out.print("Tapat");
					for (int f = 0; f < 10; f++) {
						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

	private static int carta(int x, String text) {
		int aux;
		do {
			System.out.println(text);
			aux = Keyboard.readInt();
		} while (aux < 0 || aux > (x - 1));
		return aux;

	}

	private static boolean parella(String m1, String m2) { // metode equals
		if (m1.equalsIgnoreCase(m2)) {
			return true;
		} else {
			return false;
		}
	}

	private static String[] Arg(int fil, int col) {
		String frase[] = { "Indica la fila de la primera carta que vols girar [0," + (fil - 1) + "]",
				"Indica la columna de la primera carta que vols girar [0," + (col - 1) + "]",
				"Indica la fila de la primera carta que vols girar [0," + (fil - 1) + "]",
				"Indica la columna de la primera carta que vols girar [0," + (col - 1) + "]" };
		return frase;
	}

}
