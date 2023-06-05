package Examen1Curs202021;

public class Immobiliaria {
	private Immoble[][] cartera;
	private int numVenda;			// posicions plenes fila 0
	private int numLloguer;			// posicions plenes fila 1
	
	public Immobiliaria(int quantes) {
		this.cartera = new Immoble[2][quantes];
		this.numLloguer = 0;
		this.numVenda = 0;
	}
	
	private static boolean hiEs(Immoble p, Immoble m[], int quantes) {
		for(int i=0; i<quantes; i++) {
			if(m[i].iguals(p)) return true;
		}
		return false;
	}
	
	public boolean afegirImmoble(Immoble p) {
		if(!hiEs(p, this.cartera[0], this.numVenda) && !hiEs(p, this.cartera[1], this.numLloguer)) {
			if(p.isVendaILloguer()) {
				this.cartera[0][this.numVenda] = p;
				this.numVenda++;
				this.cartera[1][this.numLloguer] = p;
				this.numLloguer++;
				return true;
			} else if(p.isVenda()) {
				this.cartera[0][this.numVenda] = p;
				this.numVenda++;
				return true;
			} else {
				this.cartera[1][this.numLloguer] = p;
				this.numLloguer++;
				return true;
			}
		}
		return false;
	}
	
	public void eliminarImmoble(Immoble p) {
		boolean trobat = false;
		if (p.isVenda()) {
			for (int i = 0; i < this.numVenda && !trobat; i++)
				if (p.iguals(this.cartera[0][i])) {
					trobat = true;
					this.numVenda--;
					this.cartera[0][i] = this.cartera[0][this.numVenda];
				}
		}
		trobat = false;
		if (p.isLloguer()) {
			for (int i = 0; i < this.numLloguer && !trobat; i++)
				if (p.iguals(this.cartera[1][i])) {
					trobat = true;
					this.numLloguer--;
					this.cartera[0][i] = this.cartera[1][this.numLloguer];
				}
		}
	}
	
	public void llistatLocals(int superficie) {
		for (int i = 0; i < this.numVenda; i++) {
			if (this.cartera[0][i].tipusImmoble() == Immoble.LOCAL && this.cartera[0][i].getSuperficie() >= superficie && ((Local) this.cartera[0][i]).getDarrerNegoci().equals("Cap"))
				System.out.println(this.cartera[0][i].getIdentificador());
		}
		for (int i = 0; i < this.numLloguer; i++) {
			if(this.cartera[1][i].tipusImmoble() == Immoble.LOCAL && this.cartera[1][i].getSuperficie() >= superficie && ((Local)this.cartera[1][i]).getDarrerNegoci().equals("Cap") && !this.cartera[1][i].isVendaILloguer())
				System.out.println(this.cartera[1][i].getIdentificador());
		}
	}
	
	public Immobiliaria mesGran(Immobiliaria c) {
		if(this.numVenda > c.numVenda) return this;
		return c;
	}
	
	public Immoble getImmobleVenda(int quin) {
		if (quin >= 0 && quin < this.numVenda)
			return this.cartera[0][quin];
		return null;
	}
}
