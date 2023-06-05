package Examen1Curs202122Rec;

public class Produccio implements Comparable<Produccio> {
	public static final int pelicula = 0;
	public static final int documental = 1;
	public static final int concert = 2;
	public static final int serie = 3;
	
	private String titol;
	private int tipus;
	private int any;
	
	public Produccio(String titol, int tipus, int any) throws IllegalArgumentException {
		
	}
	
	public int getAny() {return any;}
	public int compareTo (Produccio o) {
		return titol.compareTo(o.titol);
	}
}
