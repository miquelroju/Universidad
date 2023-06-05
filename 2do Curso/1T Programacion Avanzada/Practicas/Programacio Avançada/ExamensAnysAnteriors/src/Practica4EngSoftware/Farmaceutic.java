package Practica4EngSoftware;

public class Farmaceutic {
	
	private String horari;
	private String nom;
	private int telefon;
	
	public Farmaceutic(String horari, String nom, int telefon) {
		this.horari = horari; this.nom = nom; this.telefon = telefon;
	}
	
	public String getHorari() {return horari;}
	public String getNom() {return nom;}
	public int getTelefon() {return telefon;}
	
	public void setHorari(String horari) {this.horari = horari;}
	public void setNom(String nom) {this.nom = nom;}
	public void setTelefon(int telefon) {this.telefon = telefon;}
	
}
