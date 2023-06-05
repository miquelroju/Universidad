package Examen1Curs201819;

public class Lloro extends Animal {
	
	private static int esperansa = 70;
	
	private boolean parlador;
	
	public Lloro (String nom, int dia, int mes, int any, float pes, boolean parla) {
		super(nom, dia, mes, any, pes);
		this.parlador = parla;
	}
	
	public Lloro (String nom, int dia, int mes, int any, float pes) {
		this(nom, dia, mes, any, pes, true);
	}
	
	public boolean getParlador() {return parlador;}
	public void setParlador(boolean quin) {parlador = quin;}
	
	public void visualitzar() {
		super.visualitzar();
		if (parlador) System.out.println("I se parlar");
		else System.out.println("I NO se parlar");
	}
	
	public String ferSo() {
		if (parlador) return "BRRRR! Soc un lloro parlar i ser dir HOLA";
		else return "BRRRRRRRRRRRRR";
	}
	
	public boolean esCadell() {
		if (Animal.anyActual() - this.getAny() < esperansa / 3) return true;
		else return false;
	}
	
	public int compareTo (Comparable p) {
		if (p instanceof Lloro) return super.compareTo(p);
		throw new ClassCastException("Tipus no correcte");
	}

}
