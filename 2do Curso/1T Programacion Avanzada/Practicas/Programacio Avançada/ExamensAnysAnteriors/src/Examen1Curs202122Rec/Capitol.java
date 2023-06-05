package Examen1Curs202122Rec;

public class Capitol implements Comparable<Capitol> {
	private int durada;
	private String titol;
	
	public Capitol (int durada, String titol) {
		this.durada = durada;
		this.titol = titol;
	}
	
	public int compareTo (Capitol o) {
		return titol.compareTo(o.titol);
	}
	
	public String getTitol() {return titol;}
	public int getDurada() {return durada;}
}
