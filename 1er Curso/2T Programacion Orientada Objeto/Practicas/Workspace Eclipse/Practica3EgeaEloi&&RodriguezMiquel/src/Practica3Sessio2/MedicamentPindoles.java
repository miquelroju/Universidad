package Practica3Sessio2;

public class MedicamentPindoles implements Comparable {
	
	private final String medicament;
	private final int unitats;
	private int preses;
	
	public MedicamentPindoles (String nom, int unitats) {
		if (!(nom instanceof String)) throw new IllegalArgumentException("Nom no valid");
		this.medicament = nom;
		if (unitats < 0) throw new IllegalArgumentException("Nombre no valid, unitats inferior a 0");
		this.unitats = unitats;
		this.preses = 0;
	}
	
	public int quantesUnitatsQueden() {
		return (this.unitats-this.preses);
	}
	
	public void prendrePindola() throws ExceptionMedicament {
		if (this.unitats == this.preses) throw new ExceptionMedicament("No hi ha pindoles que prendre");
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
	
	public int compareTo(Object o) {
        if(!(o instanceof MedicamentPindoles)) throw new ClassCastException();
        if (this.unitats < ((MedicamentPindoles)o).unitats) {
            return -1;
        } else if (this.unitats == ((MedicamentPindoles)o).unitats) {
            return 0;
        } else return 1;
    }

}
