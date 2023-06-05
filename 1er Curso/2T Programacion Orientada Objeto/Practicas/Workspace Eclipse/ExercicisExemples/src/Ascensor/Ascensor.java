package Ascensor;

public class Ascensor {
	
	private int pis;	// Pis actual
	private int max;	// Pis m�s alt
	private int min;	// Pis m�s baix
	
	// Constructor. Un ascensor es construeix coneixent el pis m�s baix i el m�s alt
	
	public Ascensor (int inf, int sup) {
		min = inf;
		max = sup;
		pis = inf;		// Definim el pis actual com el m�s baix per comen�ar
	}

	public int getMax() {return max;}
	public int getMin() {return min;}
	public int getPis() {return pis;}
	
	public void pujar() {
		if (pis < max) {pis = pis + 1;}
	}
	
	public void baixar() {
		if (pis > min) {pis = pis - 1;}
	}
	
	public void anar (int planta) {
		if ((planta >= min) && (planta <= max)) {
			pis = planta;
		}
	}
		
}
