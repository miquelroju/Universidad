package Sessió2;

import Keyboard.*;

public class Memory {

	public static void main(String[] args) {

		System.out.println("JOC DEL MEMORY. ENTRA LES DIMENSIONS DEL TAULELL");
		System.out.println("************************************************");

		Taulell t;

		int fil = fil();
		int col = col();
		while ((fil * col > 36 && fil * col < 0) || fil * col % 2 != 0) {
			System.out.println("Dimensions incorrectes. Entra nous valors");
			fil = fil();
			col = col();
		}
		t = new Taulell(fil, col);
		String arg[] = Arg(fil, col);

		System.out.println("COMENÇA EL JOC. ESPECIFICA LES CARTES QUE VOLS GIRAR");
		System.out.println("****************************************************");
		int f1, f2, c1, c2;
		while (!t.fiJoc()) {
			do {
				f1 = carta(fil, arg[0]);
				c1 = carta(col, arg[1]);
				while (t.aparellada(f1, c1)) {
					System.out.println("Ja esta girada!!!");
					f1 = carta(fil, arg[0]);
					c1 = carta(col, arg[1]);
				}
				f2 = carta(fil, arg[2]);
				c2 = carta(col, arg[3]);
				while (t.aparellada(f2, c2)) {
					System.out.println("Ja esta girada!!!");
					f2 = carta(fil, arg[2]);
					c2 = carta(col, arg[3]);
				}
			} while (f1 == f2 && c1 == c2);
			if (t.fanParella(f1, c1, f2, c2)) {
				System.out.println("Fan parella!");
				System.out.println("------------");
				System.out.println(t.aparellada(f1, c1));
				System.out.println(t.aparellada(f2, c2));
				// t.aparellada(f1, c1);
				// t.fanParella(f1, c1, f2, c2);

				// m imrpimir
			} else {
				System.out.println("NO Fan parella!. Observa!!!");
			}
			t.mostrar(f1, c1, f2, c2);

		}
		System.out.println("GG");
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

	private static String[] Arg(int fil, int col) {
		String frase[] = { "Indica la fila de la primera carta que vols girar [0," + (fil - 1) + "]",
				"Indica la columna de la primera carta que vols girar [0," + (col - 1) + "]",
				"Indica la fila de la primera carta que vols girar [0," + (fil - 1) + "]",
				"Indica la columna de la primera carta que vols girar [0," + (col - 1) + "]" };
		return frase;
	}

	private static int carta(int x, String text) {
		int aux;
		do {
			System.out.println(text);
			aux = Keyboard.readInt();
		} while (aux < 0 || aux > (x - 1));
		return aux;

	}

}
