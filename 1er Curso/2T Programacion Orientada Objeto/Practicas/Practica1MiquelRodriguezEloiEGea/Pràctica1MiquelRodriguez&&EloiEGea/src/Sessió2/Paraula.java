package Sessió2;

public class Paraula {
	private char mot[];
	private int llargaria;
	private boolean parella;

	public Paraula(String mot) {
		this.mot = mot.toCharArray(); // llamo al atributo mot y le guardo el string
		this.llargaria = mot.length();
		this.parella = false;
	}

	public boolean iguals(Paraula altra) {
		if (this.llargaria == altra.llargaria) {
			for (int i = 0; i < this.llargaria; i++) { //poner -1
				if (this.mot[i] != altra.mot[i]) {
					return false;
				}
			}
			return true;
		}
		return false;

	}

	public void mostraParaula() {
		for (int i = 0; i < this.llargaria; i++) {
			System.out.print(this.mot[i]);
		}
		for(int x=0;x<15-this.llargaria;x++) {
			System.out.print(" ");
		}
	}

	public boolean getParella() {
		return this.parella;
	}

	public void setParella() {
		// this.parella = !this.parella;
		if (this.parella) this.parella = false;
		else this.parella = true;
	}

}
