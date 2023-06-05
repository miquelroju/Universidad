package Practica2Sessio3;

public class Indicacio extends SenyalTransit {

	private String significatSenyal;

	private int alturaRectangle;
	private int baseRectangle;

	public String getSignificatSenyal() {
		return this.significatSenyal;
	}

	public int getAlturaRectangle() {
		return this.alturaRectangle;
	}

	public int getBaseRectangle() {
		return this.baseRectangle;
	}

	public Indicacio(String codiSenyal, Ubicacio ubicacio, int anyColocacio, String descripcio) {

		super(codiSenyal, ubicacio, anyColocacio, descripcio);
		this.significatSenyal = codiSenyal;

	}

	public Indicacio(int base, int altura) {
		this(codiSenyal, getUbicacio(), anyColocacio, getDescripcio());
		this.baseRectangle = base;
		this.alturaRectangle=altura;
	}

	public float area() {
		float x = 0;
		x = this.alturaRectangle * this.baseRectangle;
		return (float) x;
	}
	
	public void visualitza() {
		System.out.println("L'Area �s de "+area()+"cm^2");
		System.out.println("La descripci� �s "+getDescripcio());
		super.visualitza();
	}

	public String getUbicacio() {
		String t = "";
		t = Ubicacio.getVia() + "-" + Ubicacio.getNum();
		return t;

	}

	public String getDescripcio() { // no sabem quina descripcio es refereix
		String t = "";
		return t;
	}

}
