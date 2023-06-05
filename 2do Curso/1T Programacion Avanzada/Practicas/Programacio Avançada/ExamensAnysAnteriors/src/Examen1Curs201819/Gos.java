package Examen1Curs201819;

public class Gos extends Animal {
	private int caracter;

	public static int SERIOS = 0;
	public static int TRANQUIL = 1;
	public static int JUGANER = 2;
	public static int MOLT_JUGANER = 3;

	private static final int esperansa = 15;

	public Gos(String nom, int dia, int mes, int any, float pes, int caracter) {
		super(nom, dia, mes, any, pes);
		if (caracter >= 0 && caracter < 4)
			this.caracter = caracter;
		else
			throw new IllegalArgumentException("Dades no correctes");
		this.caracter = caracter;
	}

	public int getCaracter() {
		return caracter;
	}

	public void setCaracter(int quin) {
		if (quin >= 0 && quin < 4)
			caracter = quin;
	}

	public void visualitzar() {
		super.visualitzar();
		System.out.println("que te un caracter " + this.quinTe());
	}

	public String quinTe() {
		switch (caracter) {
		case 0:
			return "SERIOS";
		case 1:
			return "TRANQUIL";
		case 2:
			return "JUGANER";
		case 3:
			return "MOLT JUGANER";
		}
		return "";
	}
	
	public String ferSo() {return "BUP! BUP!!";}
	
	public boolean esCadell() {
		if ((Animal.anyActual() - this.getAny()) < esperansa / 3) return true;
		return false;			
	}
	
	public int compareTo(Comparable p) {
		if (p instanceof Gos) return (super.compareTo(p));
		throw new ClassCastException("Tipus no correcte");
	}
}
