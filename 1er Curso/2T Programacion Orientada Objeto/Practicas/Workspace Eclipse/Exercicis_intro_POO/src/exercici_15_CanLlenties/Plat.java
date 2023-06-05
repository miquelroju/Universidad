package exercici_15_CanLlenties;

public class Plat {

	private String nom; // nom del plat
	private boolean postre; // true si és un postre
	private boolean vegetaria; // true si és un plat vegetarià
	private double cost; // el que costa, en euros, elaborar-lo
	private double preuVenda; // el preu, en euros, que figura a la carta
	private int vendes; // unitats venudes

	public Plat (String nom, boolean postre, boolean vegetaria) {
		this.nom = nom;
		this.postre = postre;
		this.vegetaria = vegetaria;
		this.cost = 0.0;
		this.preuVenda = 0.0;
		this.vendes = 0;
	}

	public String getNom() { return(nom);}
	public boolean esPostre () { return(postre);}
	public boolean esVegetaria () { return(vegetaria);}
	public double getCost() { return(cost);}
	public double getPreuVenda() { return(preuVenda);}
	public int getVendes() { return(vendes); }

	public void setCost (double cost) {
		if (cost>0.0) {
			this.cost=cost;
		}
	}

	public void setPreuVenda (double preuVenda) {
		if (preuVenda>this.cost) {
			this.preuVenda = preuVenda;
		} 
	}

	public void setVendes (int vendes) {
		if (vendes>0) {
			this.vendes=vendes;
		}
	}

	public double beneficiBrut () {
		return((this.preuVenda - this.cost)*this.vendes);
	}
}
