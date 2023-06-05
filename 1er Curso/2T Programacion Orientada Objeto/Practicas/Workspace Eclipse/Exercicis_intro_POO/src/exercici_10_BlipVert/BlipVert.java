package exercici_10_BlipVert;

public class BlipVert {
	private String alfa;
	private int beta;
	private boolean gamma;

	public BlipVert (String alfa, int beta) {
		this.alfa = alfa;
		this.beta = beta;
		gamma = (this.beta%2)==0;
	}

	public String getAlfa() {return alfa;}
	public int getBeta() {return beta;}
	

	public String comEstic() {
		if (gamma) {return " estic be";}
		else {return " estic malament";}
	}

	public void sacseja(int a, boolean b) {
		beta = beta + a;
		gamma = (beta%2)== 0;
		if (gamma!=b) {
			beta=beta+1;
			gamma=!gamma;
		}
	}
}

