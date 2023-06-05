package Practica3Sessio1;

//import java.util;
import java.util.Arrays;

public class Malalt {
	
	private String nom;										// Atribut 1
	private MedicamentPindoles[] magatzem;					// Atribut 2
	private int medicaments;								// Atribut 3
	private final int inc;									// Atribut 4
	
	public Malalt (String nom, int max, int inc) {
		this.nom = nom;
		this.magatzem = new MedicamentPindoles[max];
		this.medicaments = 0;
		this.inc = inc;
	}
	
	public String getNom() {return this.nom;}
	public int getMedicaments() {return this.medicaments;}
	public int getIncrement() {return this.inc;}
	
	public MedicamentPindoles getMedicamentPindoles(int quin) {
		if (quin >= 0 && quin < this.medicaments) {
			return this.magatzem[quin];
		} else return null;
	}
	
	public MedicamentPindoles getMedicamentPindolesNoBuit() {
		MedicamentPindoles ret = null;
		for (int i=0; i<this.medicaments; i++) {
			if (this.magatzem[i] != null) {
				ret = this.magatzem[i];
			} else ret = null;
		}
		return ret;
	}
	
	public void comprarMedicamentPindoles(MedicamentPindoles p) {
		int pos = 0;
		boolean trobat = false;
		if (this.medicaments >= this.magatzem.length) {
			MedicamentPindoles[] nouMagatzem = new MedicamentPindoles[this.medicaments + this.inc];
			for (int j = 0; j < this.medicaments; j++) {
				nouMagatzem[j] = this.magatzem[j];
			}
			this.magatzem = nouMagatzem;

		}
		// buscar posicio a la que va
		for (int i = 0; i < this.medicaments && !trobat; i++) {
			if (magatzem[i].getNom().compareTo(p.getNom()) > 0) {
				// hem trobat el lloc
				pos = i;
				trobat = true;
			} else if (magatzem[i].getNom().compareTo(p.getNom()) == 0) {
				if (magatzem[i].quantesUnitatsQueden() < p.quantesUnitatsQueden()) {
					pos = i;
					trobat = true;
				}
			}
		}
		if (!trobat)
			pos = this.medicaments;
		// fer desplaçament
		for (int i = this.medicaments; i >= pos; i--) {
			this.magatzem[i + 1] = this.magatzem[i];
		}
		this.magatzem[pos] = p;
		this.medicaments++;

	}
	
	public void comprarMedicamentPindoles(String p, int pindoles) {
		MedicamentPindoles obj = new MedicamentPindoles(p, pindoles);
		this.comprarMedicamentPindoles(obj);
	}
	
	public int totalPindolesQueden() {
		int queden = 0;
		// Seria fins el limit o fins l'ultim omplert
		for (int i=0; i<this.medicaments; i++) {
			queden += this.magatzem[i].quantesUnitatsQueden();
		}
		return queden;
	}
	
	public int totalPindolesQueden(String nom) {
		int queden = 0;
		for (int i=0; i<this.medicaments; i++) {
			if (this.magatzem[i].getNom().equals(nom)) {
				queden += this.magatzem[i].quantesUnitatsQueden();
			}
		}
		return queden;
	}
	
	public int maximPindoles() {
		String nom;
		int queden, quedenAnt = 0;
		for (int i=0; i<this.medicaments; i++) {
			nom = this.magatzem[i].getNom();
			queden = this.totalPindolesQueden(nom);
			if (queden >= quedenAnt) {
				quedenAnt = queden;
			}
		}
		return quedenAnt;
	}
	
	public String numMedicamentsPerQueden() {
		String retorn = "";
		int[] quants, queden;
		int num = 0;
		queden = new int[this.medicaments];
		quants = new int[this.medicaments];
		for (int i = 0; i < this.medicaments; i++) {
			//if (this.magatzem[i].quantesUnitatsQueden() > num) {
				int x = troba(this.magatzem[i], queden, num);
				
				if(x != -1) {
					quants[x]++;						
				} else {
					queden[num]=this.magatzem[i].quantesUnitatsQueden();
					quants[num]=1;
					num++;
				}
			}
		
		retorn = crear(queden, quants, num);
		return retorn;
	}

	private static int troba(MedicamentPindoles caixa, int[] queden, int quants) {
		for (int i = 0; i < quants; i++) {
			if (caixa.quantesUnitatsQueden() == queden[i]) {
				return i;
			}
		}
		return -1;
	}

	private static String crear(int[] queden, int[] quants, int quantes) {
		String retorn="";
		for(int i=0; i<quantes;i++) {
		 retorn = "Amb " + queden[i] + " pindoles queden " + quants[i] + " medicaments - ";
		}
		return retorn;
	}
	
	// A la hora d'eliminar un altre element fem el tractament tot i que tingui 0 píndoles
	
	public int eliminarMedicamentPindoles() {
		int retorn = 0;
		for (int i=0; i<this.medicaments; i++) {
			if (this.magatzem[i].quantesUnitatsQueden()==0) {
				for (int j=i; j<this.medicaments; j++) {
					this.magatzem[j] = this.magatzem[j++];
				}
				this.magatzem[this.medicaments] = null;
				this.medicaments--;
				retorn++;
			}
		}
		return retorn;
	}
	
	public MedicamentPindoles[] donaMedicamentsBuits() {
		int j=0;
		MedicamentPindoles[] retorn;
		retorn = new MedicamentPindoles[this.medicaments];
		for (int i=0; i<this.medicaments; i++) {
			if (this.magatzem[i].quantesUnitatsQueden()==0) {
				retorn[j] = this.magatzem[i];
				j++;
			}
		}
		return retorn;
	}
	
	public String toString() {
		String retorn = "";
		for (int i = 0; i < this.medicaments; i++) {
			retorn += (i+1) + ". "+this.magatzem[i].toString()+"\n";
		}
		return retorn;
	}
	
	public boolean equals(Object o) {
		String[] arrayA, arrayB;
		if (((Malalt) o) instanceof Malalt) {
			String a = this.numMedicamentsPerQueden();
			String b = ((Malalt) o).numMedicamentsPerQueden();

			arrayA = a.split("-", this.medicaments);
			arrayB = b.split("-", ((Malalt) o).getMedicaments());

			Arrays.sort(arrayA);
			Arrays.sort(arrayB);

			a = Arrays.toString(arrayA);
			b = Arrays.toString(arrayB);

			if (a == b) {
				return true;
			} else
				return false;
		} else
			return false;
	}
	
}
	
