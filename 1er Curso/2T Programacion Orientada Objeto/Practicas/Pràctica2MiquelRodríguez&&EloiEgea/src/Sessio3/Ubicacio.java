package Sessio3;

public class Ubicacio {
	private String nomCarrer;
	private int numCarrer;
	private SenyalTransit senyals[];
	private int numSenyals;
	private final int MAX_SENYALS;

	public Ubicacio(int maxim, String carrer, int numero) {
		this.MAX_SENYALS = maxim;
		this.senyals = new SenyalTransit[this.MAX_SENYALS];
		this.numSenyals = 0;
		this.nomCarrer = carrer.toUpperCase();
		this.numCarrer = numero;
	}

	public String getNomCarrer() {
		return nomCarrer;
	}

	public int getNumCarrer() {
		return numCarrer;
	}

	public int getNumSenyals() {
		return numSenyals;
	}

	public boolean iguals(Ubicacio ubicacio) {
		if (this.numCarrer == ubicacio.numCarrer) {
			if (this.nomCarrer.equalsIgnoreCase(ubicacio.nomCarrer)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public SenyalTransit getSenyal(int quin) {
		if (quin > this.numSenyals) {
			return null;
		} else {
			return this.senyals[quin];
		}
	}

	public boolean afegirSenyal(SenyalTransit c) {
		if (this.numSenyals < this.MAX_SENYALS) {
			for (int i = 0; i < this.numSenyals; i++) {
				if (c.getCodi().equalsIgnoreCase(this.senyals[i].getCodi())) {
					return false;
				}
			}
			this.senyals[this.numSenyals] = c;
			this.numSenyals++;
			return true;
		}
		return false;
	}

	public boolean treureSenyal(SenyalTransit c) {
		int index = 0;
		while (!this.senyals[index].getCodi().equalsIgnoreCase(c.getCodi())) {
			index++;
			if (index == this.numSenyals)
				return false; // Sino no surt del bucle
		}
		this.senyals[index] = this.senyals[this.numSenyals - 1];
		this.numSenyals--;
		this.senyals[this.numSenyals] = null;
		return true;
	}

	public String getSenyals() {
		String codi = "";
		for (int i = 0; i < this.numSenyals; i++) {
			codi += this.senyals[i].getCodi();
			if (i < this.numSenyals - 1)
				codi += "-";
		}
		return codi;
	}
}
