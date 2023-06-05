package Examen1Curs201819;

import java.util.*;

public abstract class Animal implements Comparable, java.lang.Comparable<Comparable> {
	private String nom;
	private float pes;
	private int dia;
	private int mes;
	private int any;
	
	public Animal (String nom, int dia, int mes, int any, float pes) {
		if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || any < 1900 || any > 2018 || nom == "" || pes <= 0) 
			throw new IllegalArgumentException ("Dades no correcte");
		this.nom = nom;
		this.dia = dia;
		this.mes = mes;
		this.any = any;
		this.pes = pes;
	}
	
	public String getNom() {return nom;}
	public float getPes() {return pes;}
	public int getDia() {return dia;}
	public int getMes() {return mes;}
	public int getAny() {return any;}
	
	public int compareTo(Comparable p) {
		if (p instanceof Animal) {
			Animal a = (Animal) p;
			return (this.nom.compareTo(a.nom));
		}
		throw new ClassCastException("Tipus no correcte");
	}
	public boolean MajorQue(Comparable c) {
		return this.compareTo(c) > 0;
	}
	public boolean MenorQue(Comparable c) {
		return this.compareTo(c) < 0;
	}
	
	public void visualitzar() {
		System.out.println("Nom animal: " + nom + " que pesa " + pes / 1000 + " kilos i que ha nascut el " + dia + "/" + mes + "/" + any);
	}
	
	public abstract String ferSo();
	public abstract boolean esCadell();
	protected static int anyActual() {
		java.util.Date data = new Date();
		return data.getYear();
	}
	
}













