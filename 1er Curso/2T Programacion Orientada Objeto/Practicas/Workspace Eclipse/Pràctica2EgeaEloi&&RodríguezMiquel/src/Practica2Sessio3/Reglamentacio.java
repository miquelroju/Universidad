package Practica2Sessio3;

public class Reglamentacio extends SenyalTransit {

	private String significatSenyal;

	private int diametre;

	public String getSignificatSenyal() {
		return this.significatSenyal;
	}

	public int getDiametre() {
		return this.diametre;
	}

	public Reglamentacio(String codiSenyal, Ubicacio ubicacio, int anyColocacio, String descripcio) {

		super(codiSenyal, ubicacio, anyColocacio, descripcio);
		this.significatSenyal = codiSenyal;
		this.diametre = CIRCULAR;

	}

	public Reglamentacio(int diametre) {
		this(codiSenyal, getUbicacio(), anyColocacio, getDescripcio());
		this.diametre = diametre;
	}

	public float area() {
		float x = 0;
		x = (float) (Math.PI * (this.diametre / 2) * (this.diametre / 2));
		return (float) x;
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

	public String getDescripcio() { // no sabem quina descripcio es refereix
		String t = "";
		return t;
	}

}
