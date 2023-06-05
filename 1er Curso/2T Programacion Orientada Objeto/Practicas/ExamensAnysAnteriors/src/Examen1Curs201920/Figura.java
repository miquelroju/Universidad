package Examen1Curs201920;

public class Figura extends Carta {
	private String nomFigura;
	public final static double PUNTUACIO = 0.5;
	
	public Figura(double numero, int pal, String nomFigura) {
		super(numero, pal);
		this.nomFigura = nomFigura;
	}
	
	public Figura(double numero, int pal) {
		this(numero, pal, nomFigura);
		String nomFigura = "";
		if (numero == 10) nomFigura = "Cavaller";
		if (numero == 11) nomFigura = "Reina";
		if (numero == 12) nomFigura = "Rei";
		//this(numero, pal, nomFigura);
	}
}
