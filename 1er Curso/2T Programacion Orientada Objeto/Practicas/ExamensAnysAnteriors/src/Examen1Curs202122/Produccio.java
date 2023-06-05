package Examen1Curs202122;

public class Produccio {
	public static final int PELICULA = 0;
	public static final int DOCUMENTAL = 1;
	public static final int CONCERT = 2;
	public static final int SERIE = 3;

	private String titol;
	private int tipus;
	private int any;

	public Produccio(String titol, int tipus, int any) {
		this.titol = titol;
		this.any = any;
		if (tipus == Produccio.PELICULA || tipus == Produccio.DOCUMENTAL || tipus == Produccio.CONCERT
				|| tipus == Produccio.SERIE)
			this.tipus = tipus;
		else
			this.tipus = Produccio.PELICULA;
	}

	public Produccio(int tipus, String tit) {
		this(tit, tipus, 2022);
	}

	public int getAny() {
		return any;
	}

	public String getTitol() {
		return titol;
	}

	public int getTipus() {
		return tipus;
	}

	public String tipusProduccio() {
		switch (this.tipus) {
		case Produccio.PELICULA:
			return "Pelicula";
		case Produccio.DOCUMENTAL:
			return "Documental";
		case Produccio.CONCERT:
			return "Concert";
		case Produccio.SERIE:
			return "Serie";
		}
		return ""; // No arribarà mai però perquè no dongui error el mètode
	}

	public boolean iguals(Produccio b) {
		if (b.tipus == this.tipus && b.titol.equals(this.titol) && b.any == this.any)
			return true;
		return false;
	}
	
	public void visualitzar() {
		System.out.println("Títol de la producció: " + this.titol);
		System.out.println("Tipus de producció: " + this.tipusProduccio());
		System.out.println("Any de la producció: " + this.any);
	}
}
