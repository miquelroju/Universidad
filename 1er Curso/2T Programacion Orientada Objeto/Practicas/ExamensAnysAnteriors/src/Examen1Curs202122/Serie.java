package Examen1Curs202122;

public class Serie extends Produccio {
	
	private int quantesTemporades;
	private int[] numeroCapitols;
	
	public Serie(String titol, int any, int numeroTemporades) {
		super(titol, Produccio.SERIE, any);
		this.quantesTemporades = numeroTemporades;
		for (int i = 0; i < this.quantesTemporades; i++) {
			this.numeroCapitols[i] = 1;
		}
	}
	
	public Serie(String titol, int numeroTemporades) {
		this(titol, 1990, numeroTemporades);
	}
	
	public int getQuantesTemporades() {
		return this.quantesTemporades;
	}
	
	public void setAny(int any) {
		// super.setAny(any);			// Ens faltaria un setter d'any a la superclasse
	}
	
	public boolean iguals(Produccio b, int quina) {
		if(super.iguals(b) && ((Serie)b).numeroCapitols[quina] == this.numeroCapitols[quina])
			return true;
		return false;
	}
	
	public void visualitzar() {
		super.visualitzar();
		System.out.println("Número de temporades disponibles: " + this.quantesTemporades);
	}
	
	public void incrementarCapitol(int quina) {
		if (quina <= this.quantesTemporades) {
			this.numeroCapitols[quina]++;
		}
	}
	
	public int mesCapitols() {
		int caps = 0;
		int resultat = 0;
		for (int i = 0; i < this.quantesTemporades; i++) {
			if (this.numeroCapitols[i] > caps) {
				caps = this.numeroCapitols[i];
				resultat = i;
			}
		}
		return resultat + 1;
	}
}
