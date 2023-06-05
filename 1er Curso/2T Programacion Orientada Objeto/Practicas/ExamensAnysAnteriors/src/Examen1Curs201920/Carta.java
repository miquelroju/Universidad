package Examen1Curs201920;

public class Carta {
	private double numero;
	private int pal;
	public final static int COPES = 1;
	public final static int ESPASES = 2;
	public final static int OROS = 3;
	public final static int BASTONS = 4;

	public Carta(double numero, int pal) {
		this.numero = numero;
		this.pal = pal;
	}

	public double getNumero() {
		return this.numero;
	}

	public int getPal() {
		return pal;
	}

	public String visualitzar() {
		return "Carta " + this.numero + "de " + this.donaPal();
	}

	public boolean iguals(Carta c) {
		if (this.numero == c.numero && this.pal == c.pal)
			return true;
		return false;
	}
	
	public boolean noIguals(Carta c) {
		return !this.iguals(c);
	}
	
	private String donaPal() {
		switch(this.pal) {
			case Carta.BASTONS:
				return "BASTONS";
			case Carta.COPES:
				return "COPES";
			case Carta.OROS:
				return "OROS";
			case Carta.ESPASES:
				return "ESPASES";
		}
		return "";
	}
}
