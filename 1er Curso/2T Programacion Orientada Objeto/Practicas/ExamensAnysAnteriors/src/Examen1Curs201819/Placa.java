package Examen1Curs201819;

public class Placa {
	
	private String lletres;
	private int numero;
	
	public Placa (String lletres, int numero) {
		this.lletres = lletres;
		this.numero = numero;
	}
	
	public String getLletres() {return lletres;}
	public int getNumero() {return numero;}
	public boolean placaParella() {return numero%2==0;}
	
}
