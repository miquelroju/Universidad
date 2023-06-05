package Practica3Sessio1;

public class MedicamentPindoles {
	
	private final String medicament;
	private final int unitats;
	private int preses;
	
	public MedicamentPindoles (String nom, int unitats) {
		this.medicament = nom;
		this.unitats = unitats;
		this.preses = 0;
	}
	
	public int quantesUnitatsQueden() {
		return (this.unitats-this.preses);
	}
	
	public void prendrePindola() {
		if (this.preses < this.unitats) {
			this.preses++;
		}
	}
	
	public int getPindolesPreses() {
		return this.preses;
	}
	
	public String getNom() {
		return this.medicament;
	}
	
	public boolean equals(Object med) {
		if (this == med) {
			return true;
		} else return false;
	}
	
	public String toString() {
		return ("Nom del medicament " + this.medicament + " amb " + this.quantesUnitatsQueden() + " píndoles de " + this.unitats);
	}

}
