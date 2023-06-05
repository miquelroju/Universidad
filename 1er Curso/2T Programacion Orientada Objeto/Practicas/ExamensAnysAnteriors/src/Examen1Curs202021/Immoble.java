package Examen1Curs202021;

public class Immoble {

	public final static int PIS = 1;
	public final static int CASA = 2;
	public final static int APARTAMENT = 3;
	public final static int LOCAL = 4;

	private int identificador;
	private int superficie;
	private float preuLloguer;
	private float preuVenda;

	public Immoble(int mida, float preuVenda, float preuLloguer, int identificador) {
		this.identificador = identificador;
		this.superficie = mida;
		this.preuLloguer = preuLloguer;
		this.preuVenda = preuVenda;
	}

	public Immoble(int mida, float preuLloguer, int identificador) {
		this(mida, 0.0F, preuLloguer, identificador);
	}

	public float getPreuLloguer() {
		return preuLloguer;
	}

	public float getPreuVenda() {
		return preuVenda;
	}

	public void setPreuLloguer(float p) {
		preuLloguer = p;
	}

	public void setPreuVenda(float p) {
		preuVenda = p;
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int tipusImmoble() {
		int tipo = this.identificador % 10;
		switch (tipo) {
		case 1:
			return Immoble.PIS;
		case 2:
			return Immoble.APARTAMENT;
		case 3:
			return Immoble.CASA;
		case 4:
			return Immoble.LOCAL;
		}
		return 0;		
	}
	
	public boolean isLloguer() {
		return preuLloguer!=0;
	}
	
	public boolean isVenda() {
		return preuVenda!=0;
	}
	
	public boolean isVendaILloguer() {
		return this.isLloguer() && this.isVenda();
	}
	
	public boolean iguals(Immoble b) {
		return this.identificador == b.identificador;
	}
	
	public float preuMetreQuadrat(float comisio) {
		float preu = 0;
		if (this.preuVenda > 0) {
			preu = this.preuVenda/this.superficie;
			if (this.tipusImmoble() == Immoble.LOCAL)
				preu += preu*(comisio/2);
			else
				preu += preu*comisio;
		} else {
			preu = this.preuLloguer/this.superficie;
			if (this.tipusImmoble() == Immoble.LOCAL)
				preu += preu*(comisio/2);
			else
				preu += preu*comisio;
		}
		return preu;
	}	
}
