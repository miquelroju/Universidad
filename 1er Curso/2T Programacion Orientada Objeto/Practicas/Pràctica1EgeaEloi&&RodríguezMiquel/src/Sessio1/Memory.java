package Sessio1;

import Keyboard.*;
import java.util.*;

public class Memory {

	public static void main(String[] args) {
		System.out.println("JOC DEL MEMORY. ENTRA LES DIMENSIONS DEL TAULELL");
		System.out.println("************************************************");
		
		int fil = fil();
		int col = col();
		while (fil * col > 36 || fil * col % 2 != 0) {
			System.out.println("Dimensions incorrectes. Entra nous valors");
			fil = fil();
			col = col();
		}
		String t[][] = ompleTaulell(fil, col);
		imprimir(t);
		// String[][] taulell =

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
		String[] paraules = paraules(quantes);
		
		while (quantes != 0) {
			System.out.println(".");
			int posX = pos(f);
			int posY = pos(c);
			int p = pos(quantes);
			while (paraules[p].equals(" ")) {
				p = pos(quantes);
				System.out.println(";");
			}
			for (int i = 0; i < 2; i++) {
				while (t[posX][posY].equals(" ")) {
					posX = pos(f);
					posY = pos(c);
				}
				t[posX][posY] = paraules[p];
			}
			paraules = eliminaParaula(paraules, p);
			quantes--;
			System.out.println(quantes);
		}
		System.out.println(quantes);
		
		imprimir(t);

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

	private static String[] paraules(int x) {
		String[] t = new String[x];
		String[] baralla = { "Mugre", "Modelo", "Colina", "Juguete", "Intentar", "Mezclada", "Similar", "Coordinado",
				"Cerrar", "Fiasco", "Resolver", "Cliente", "Contemplar", "Dirigible", "Balística", "Acróbata",
				"Colisión", "Agradecido" };
		if (x == baralla.length) {
			return baralla;
		} else {
			for (int i = 0; i < x; i++) {
				t[i] = baralla[i];
			}
			return t;
		}
	}

	private static void imprimir(String[][] t) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				System.out.print(t[i][j]);
			}
		}
	}
}