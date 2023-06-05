package exercici_03_Diposits;

public class Diposits {
	
	// ATRIBUTS
	
	private String nom;
	private double litresMax;
	private double litres;
	private double cabalEntrada;
	private double cabalSortida;
	
	// CONSTRUCTOR
	
	public Diposits (String nnom, double max, double ent, double sor) {
		nom = nnom;
		litresMax = max;
		litres = 0.0;
		cabalEntrada = ent;
		cabalSortida = sor;
	}
	
	// GETTERS
	
	public String getNom() {return nom;}
	public double getLitresMax() {return litresMax;}
	public double getLitres() {return litres;}
	public double getCabalEntrada() {return cabalEntrada;}
	public double getCabalSortida() {return cabalSortida;}
	
	// SETTERS
	
	public void setCabalEntrada(double nent) {
		cabalEntrada = nent;
	}
	public void setCabalSortida(double nsor) {
		cabalSortida = nsor;
	}
	
	// ALTRES MÈTODES
	
	public double buidar (int segons) {
		calcularLitres(segons, false);
		if (litres >= 0) {
			return litres;
		} else {
			litres = 0;
			return litres;
		}
	}
	
	public double omplir (int segons) {
		calcularLitres(segons, true);
		return litres;
	}
	
	private double calcularLitres (int segons, boolean omplir) {
		if(omplir) {
			litres += cabalEntrada*segons;
			return litres;
		} else {
			litres -= cabalSortida*segons;
			return litres;
		}
	}
	
}
