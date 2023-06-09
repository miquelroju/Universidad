package Examen1;

public abstract class ContenidorBrossa implements Comparable<ContenidorBrossa> {
	private int color; // color del contenidor
	private Ubicacio ubicacio; // Si est� al magatzt� un valor de null
	private String codi; // identificador
	private int any; // emmagatzema l'any de compra
	protected float tara;
	public final static int groc = 0;
	public final static int marro = 1;
	public final static int gris = 2;
	public final static int verd = 3;
	public final static int blau = 4;
	public final static int nou = 0;
	public final static int seminou = 1;
	public final static int vell = 2;

	public ContenidorBrossa(int color, String codi, float tara, Ubicacio on, int any) {
// Suposa que el valor de tots els par�metres �s correcte.
// Si on �s null s�emmagatzema al magatzem de la poblaci�
		this.codi = codi;
		this.color = color;
		this.ubicacio = on;
		this.tara = tara;
		this.any = any;
	}

	public int getEstat() {
		if (any < 2000)
			return vell;
		if (any < 2015)
			return seminou;
		return nou;
	}

	public String getCodi() {
		return codi;
	}

	public String getTipusBrossa() {
		switch (color) {
		case marro:
			return "organic";
		case gris:
			return "rebuig";
		case blau:
			return "paper";
		case groc:
			return "plastic";
		case verd:
			return "vidre";
		default:
			return "ERROR";
		}
	}

	public Ubicacio getUbicacio() {
		return this.ubicacio;
	}

	public String toString() {
		String s = "Codi: " + codi;
		if (ubicacio != null)
			s += "Ubicaci�: " + ubicacio.toString();
		else
			s += "Ubicaci�: retirat";
		s += "Tipus brossa " + getTipusBrossa();
		s += "Tara: " + tara;
		return s;
	}

	public int compareTo(ContenidorBrossa o) {
		return codi.compareTo(o.codi);
	}

	public abstract void buidat(double quilos);
}