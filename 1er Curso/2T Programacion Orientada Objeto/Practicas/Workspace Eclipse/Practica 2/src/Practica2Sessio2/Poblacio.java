package Practica2Sessio2;

public class Poblacio {
	
	private String poblacio;				// Atribut 1
	private int habitants;					// Atribut 2
	private Ubicacio[][] ubicacions;		// Atribut 3
	private int numParells;					// Atribut 4
	private int numSenars;					// Atribut 5
	private final int MAX_UBICACIONS;		// Atribut 6
	
	// Constructor
	
	public Poblacio (int Maxim, String poblacio, int numHabitants) {
		this.ubicacions = new Ubicacio[2][Maxim];
		this.numParells = 0;
		this.numSenars = 0;
		this.poblacio = poblacio;
		this.habitants = numHabitants;
		this.MAX_UBICACIONS = Maxim;
	}
	
	// Metodes acces atributs
	
	public String getPoblacio () {return this.poblacio;}
	public int getHabitants () {return this.habitants;}
	public int getNumParells () {return this.numParells;}
	public int getNumSenars () {return this.numSenars;}
	public int getMaxUbicacions () {return this.MAX_UBICACIONS;}
	
	boolean afegirUbicacio (Ubicacio c) {
		boolean retorn = false;
		int correspondencia;
		if (c.getCruilla()) {
			correspondencia = 0;
		} else correspondencia = 1;
		
		for(int i=0; i<this.MAX_UBICACIONS; i++) {
			if (this.ubicacions[correspondencia][i] != null) {
				retorn = false;
			} else if (c.getVia()==null){
				retorn = false;
			} else if (c == this.ubicacions[correspondencia][i]) {
				retorn = false;
			} else {
				if (correspondencia == 0) {
					this.ubicacions[correspondencia][this.numParells] = c;
					this.numParells++;
					retorn = true;
				} else {
					this.ubicacions[correspondencia][this.numSenars] = c;
					this.numSenars++;
					retorn = true;
				}
			}
		}
		return retorn;
	}
	
	boolean eliminarUbicacio (Ubicacio c) {
		boolean retorn = false;
		int correspondencia;
		if (c.getCruilla()) {
			correspondencia = 0;
		} else correspondencia = 1;
		
		if (c.getVia() != null) {
			retorn = false;
		} else {
			if (correspondencia == 0) {
				this.ubicacions[correspondencia][this.numParells] = null;
				this.numParells--;
				retorn = true;
			} else {
				this.ubicacions[correspondencia][this.numSenars] = null;
				this.numSenars--;
				retorn = true;
			}
		}
		return retorn;
	}
	
	int eliminarBuides() {
		int buides=0;
		for (int i=0; i<this.MAX_UBICACIONS; i++) {
			for (int j=0; j<this.MAX_UBICACIONS; j++) {
				if (this.ubicacions[i][j] == null) {
					buides++;
				}
			}
		}
		return buides;
	}
	
	int quantes() {
		int quantes=0;
		quantes = this.numParells + this.numSenars;
		return quantes;
	}
}
