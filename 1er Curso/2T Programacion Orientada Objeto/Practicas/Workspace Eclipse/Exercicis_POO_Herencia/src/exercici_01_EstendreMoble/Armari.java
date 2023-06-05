package exercici_01_EstendreMoble;

public class Armari extends Moble {

	private final int portes;
	private final boolean modular;
	private int lleixes;
	
	public Armari (String marca, String model, double pes, double volum, boolean fragil, double preuBase, int estat, int portes, boolean modular) {
		super(marca, model, pes, volum, fragil, preuBase, estat);
		this.portes = portes;
		this.modular = modular;
		this.lleixes = 0;
	}
	
	public int getPortes() {
		return this.portes;
	}
	public boolean getModular() {
		return this.modular;
	}
	public int getLleixes() {
		return this.lleixes;
	}
	
	public void afegirLleixa() {
		this.preuBase+=50;
		this.lleixes++;
	}
	
	public void treureLleixa() {
		if (this.lleixes > 0) {
			this.preuBase-=50;
			this.lleixes--;
		}
	}
}
