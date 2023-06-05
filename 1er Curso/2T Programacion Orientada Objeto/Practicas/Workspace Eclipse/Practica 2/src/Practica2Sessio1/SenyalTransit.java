package Practica2Sessio1;

import java.util.GregorianCalendar;

public class SenyalTransit {

	public final int advertencia = 0;
	public final int reglamentacio = 1;
	public final int indicacio = 2;

	private String codiSenyal; // Atribut 1
	private int tipus; // Atribut 2
	private Ubicacio ubi; // Atribut 3
	private int anyColocacio; // Atribut 4
	private int anyRetirada; // Atribut 5

	GregorianCalendar avui = new GregorianCalendar();
	int anyActual = avui.get(1);

	// Constructor

	public SenyalTransit(String codi, int tipus, Ubicacio ubicacio, int anyColocacio) {
		this.codiSenyal = codi;
		this.tipus = tipus;
		if (!ubicacio.afegirSenyal(this)) {
			this.ubi = null;
			this.anyColocacio = 0;
			this.anyRetirada = anyActual;
		} else {
			this.ubi = ubicacio;
			this.anyColocacio = anyColocacio;
			this.anyRetirada = 0;
		}
	}

	public String getTipusSenyal() {
		String retorn;
		if (this.tipus == advertencia) {
			retorn = "Advertencia";
		} else if (this.tipus == reglamentacio) {
			retorn = "Reglamentacio";
		} else
			retorn = "Indicacio";

		return retorn;
	}

	public boolean retirarViaPublica() {
		boolean retorn = false;
		if (ubi.treureSenyal(this)) {
			int anyActual = avui.get(1);
			this.anyRetirada = anyActual;
			this.ubi = null;
			this.anyColocacio = 0;
			retorn = true;
		}
		return retorn;
	}

	public String getUbicacio() {
		String carrer = "";
		String numero = "";
		if (this.ubi != null) {
			carrer = ubi.getVia();
			numero = Integer.toString(ubi.getNum());
			carrer = carrer + " " + numero;

		}
		return carrer;
	}

	boolean canviarUbicacio(Ubicacio novaUbicacio) {
		if (ubi.afegirSenyal(this) == false) {
			return false;
		} else {
			ubi.treureSenyal(this);
			ubi.afegirSenyal(this);
			return true;
		}
	}

	String getCodiSenyal() {
		return this.codiSenyal;
	}

	Ubicacio getUbi() {
		return this.ubi;
	}

	String getEstat() {
		int any;
		String estat;
		any = anyActual - anyColocacio;
		if (any > 4) {
			estat = "vell";
		} else if (any < 4 && any >= 2) {
			estat = "semi nou";
		} else {
			estat = "nou";
		}
		return estat;
	}

}