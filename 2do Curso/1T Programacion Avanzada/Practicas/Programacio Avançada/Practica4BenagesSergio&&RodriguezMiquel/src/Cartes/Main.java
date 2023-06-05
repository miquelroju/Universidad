package Cartes;

import Keyboard.*;

public class Main {

	public static <E> void main(String[] args) {

		boolean acabar = false;
		Baralla baralla = new Baralla();
		baralla.crearBaralla();
				
		System.out.println("S'ha creat la baralla i crregat a l'arbre");

		while (!acabar) {

			if (menu() == 1) {

				int pal = pal();
				int num = numero();

				Carta e = new Carta(num, palStr(pal));
				
				System.out.println("S'ha eliminat la carta " + e.toString());
				
			} else {
				acabar = true;
			}
		}
	}

	private static int menu() {

		int menu = 0;

		do {
			System.out.println("Menu Opcions");
			System.out.println("============");
			System.out.println("1.- Eliminar carta");
			System.out.println("2.- Acabar");
			System.out.println("Tria que vols fer (1 o 2)");
			menu = Keyboard.readInt();
		} while (menu != 1 && menu != 2);

		return menu;
	}

	
	
	private static int pal() {

		int pal = 0;

		do {
			System.out.println("Tria pal de la carta que vols eliminar");
			System.out.println("1.- Copes");
			System.out.println("2.- Espases");
			System.out.println("3.- Oros");
			System.out.println("4.- Bastons");
			pal = Keyboard.readInt();
		} while (pal < 1 || pal > 4);

		return pal;
	}

	private static int numero() {

		int numero = 0;

		System.out.println("Tria el numero de la carta");

		do {
			System.out.println("Indica la numeracio de la carta [1,12]");
			numero = Keyboard.readInt();
		} while (numero < 1 || numero > 12);

		return numero;
	}

	private static String palStr(int num) {
		switch (num) {
		case 1:
			return "COPES";
		case 2:
			return "ESPASES";
		case 3:
			return "OROS";
		case 4:
			return "BASTONS";
		default:
			return "";
		}
	}
}