package Practica2Sessio2;

public class Ubicacio {

	// Declaració atributs

	private String via;
	private int num;
	private boolean cruilla;

	private SenyalTransit[] senyals;
	private int numSenyals;
	private final int max_senyals;

	// Mètode constructor

	public Ubicacio(int maxim, String carrer, int numero) {
		this.via = carrer;
		this.num = numero;
		this.cruilla = false;

		this.senyals = new SenyalTransit[maxim];
		this.numSenyals = 0;
		this.max_senyals = maxim;
	}
	
	// Metodes d'acces als atributs

	public String getVia() {
		return this.via;
	}

	public int getNum() {
		return this.num;
	}

	public boolean getCruilla() {
		return this.cruilla;
	}

	public int getNumSenyals() {
		return this.numSenyals;
	}

	public int getMaxSenyals() {
		return this.max_senyals;
	}
	
	// Metode de modificacio de l'atribut cruilla

	public void setCruilla() {
		if (this.cruilla == false)
			this.cruilla = true;
		else
			this.cruilla = false;
	}
	
	// Metode per veure un senyal

	public SenyalTransit getSenyal(int quin) {
		if (quin > 0 && quin <= this.max_senyals)
			return this.senyals[quin - 1];
		else
			return null;
	}

	// Metode per afegir un senyal

	public boolean afegirSenyal(SenyalTransit c) {
		boolean retorn = false;
		for (int i = 0; i < this.numSenyals; i++) {
			if (this.senyals[i].getCodiSenyal().equals(c.getCodiSenyal())) {
				return false;
			}
		}
		if (this.numSenyals < this.max_senyals) {
				this.senyals[this.numSenyals] = c;
				this.numSenyals++;
				retorn = true;
		
		}
		return retorn;
	}

	// Metode per treure un senyal
	
	public boolean treureSenyal(SenyalTransit c) {
		boolean retorn = false;
		for (int i = 0; i < this.numSenyals; i++) {
			if (this.senyals[i].equals(c)) {
				this.senyals[i] = null;
				this.senyals[i] = this.senyals[this.max_senyals - 1];
				this.numSenyals--;
				retorn = true;
			} else
				retorn = false;
		}
		return retorn;
	}
	
	// Metode per obtenir tots els senyals

	public String getSenyals() {
		String retorn = "";
		for (int i = 0; i < this.numSenyals; i++) {
			retorn = String.valueOf(this.senyals[i]);
			System.out.print('-');
			return retorn;
		}
		return retorn;
	}

}