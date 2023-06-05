package Cartes;

import java.util.*;

public class Baralla {

	private class node {
		private Carta ele;
		private node seg;

		public node() {

		}

		public node(Carta c, node seg) {
			this.ele = c;
			this.seg = seg;
		}
		
		public node (Carta c) {
			this (c, null);
		}
	}
	
	private node cap;
	
	public Baralla () {
		this.cap = null;
	}
	
	public Baralla (Carta c) {
		this.cap = new node(c);
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

	public int inserir(Carta c) {
		// inserim davant de tot
		if (!this.membre(c)) {
			this.cap = new node(c, this.cap);
			return 1;
		} else {
			return 0;
		}
	}

	public boolean membre(Carta c) {
		boolean trobat = false;
		node aux = this.cap;
		while (!trobat && aux != null) {
			if (aux.ele.compareTo(c) == 0) {
				trobat = true;
			} else {
				aux = aux.seg;
			}
		}
		return trobat;
	}

	public void crearBaralla() {

		for (int i = 0; i < 47; i++) {
			int pal = (int) (Math.random() * 4 + 1);
			int numero = (int) (Math.random() * 12 + 1);
			Carta c = new Carta(numero, palStr(pal));
			if (this.inserir(c) == 0) {
				i = i - 1;
			} else {
				System.out.println(c.toString());
			}
		}
	}
}