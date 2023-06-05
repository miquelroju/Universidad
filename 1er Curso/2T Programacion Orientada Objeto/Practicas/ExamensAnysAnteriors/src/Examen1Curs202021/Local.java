package Examen1Curs202021;

public class Local extends Immoble {
	private boolean lavabo;
	private String darrerNegoci;

	public Local(int mida, float preuVenda, float preuLloguer, int identificador, boolean lavabo, String darrerNegoci) {
		super(mida, preuVenda, preuLloguer, identificador);
		this.lavabo = lavabo;
		this.darrerNegoci = darrerNegoci;
	}
	
	public Local(int mida, float preuVenda, float preuLloguer, int identificador, boolean lavabo) {
		this(mida, preuVenda, preuLloguer, identificador, lavabo, "Cap");		
	}
	
	public boolean getLavabo() {return this.lavabo;}
	public String getDarrerNegoci() {return this.darrerNegoci;}
	public void setDarrerNegoci(String darrerNegoci) {this.darrerNegoci=darrerNegoci;}
	
	public float preuMetreQuadrat(float comisio) {
		if(this.darrerNegoci.equals("Cap")) {
			return super.preuMetreQuadrat(comisio) - super.preuMetreQuadrat(comisio)*0.02F;
		} else return this.preuMetreQuadrat(comisio);
	}
	
	public float preuMetreQuadrat() {
		return this.preuMetreQuadrat(555F);
	}
}
