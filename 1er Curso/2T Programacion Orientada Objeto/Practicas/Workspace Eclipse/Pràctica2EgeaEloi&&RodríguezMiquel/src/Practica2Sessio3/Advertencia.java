package Practica2Sessio3;

import java.math.*;

public class Advertencia extends SenyalTransit {

	private String significatSenyal;

	private double costat;

	public String getSignificatSenyal() {
		return this.significatSenyal;
	}

	public double getCostat() {
		return this.costat;
	}

	public Advertencia(String codiSenyal, Ubicacio ubicacio, int anyColocacio, String descripcio) {

		super(codiSenyal, ubicacio, anyColocacio, descripcio);
		this.significatSenyal = codiSenyal;

	}

	public Advertencia(double costat) {
		this(codiSenyal, getUbicacio(), anyColocacio, getDescripcio());
		this.costat=costat;
	}

	public float area() {

		this.costat = Math.PI * (CIRCULAR / 2) * (CIRCULAR / 2);
		return (float) this.costat;
	}

	public void visualitza() {
		System.out.println("L'Area és de "+area()+"cm^2");
		System.out.println("La descripció és "+getDescripcio());
		super.visualitza();
	}
	
	
	public String getUbicacio() {
		String t = "";
		t = Ubicacio.getVia() + "-" + Ubicacio.getNum();
		return t;

	}

	public String getDescripcio() { //no sabem quina descripcio es refereix
		String t = "";
		return t;
	}

}
