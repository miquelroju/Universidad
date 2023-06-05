package Practica2Sessio2;

import java.util.GregorianCalendar;

public class SenyalTransit {

	public static final int advertencia = 0;
	public static final int reglamentacio = 1;
	public static final int indicacio = 2;

	private String codiSenyal; // Atribut 1
	private int tipus; // Atribut 2
	private Ubicacio ubi; // Atribut 3
	private int anyColocacio; // Atribut 4
	private int anyRetirada; // Atribut 5

//	SenyalTransit t;
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

	// Sobrecàrrega 1 constructors Sessió 2

	public SenyalTransit(Ubicacio ubicacio) {
		this(generarCodi(generarTipus()), generarTipus(), ubicacio, getAny());
	}

	// Sobrecàrrega 2 constructors Sessió 2

	public SenyalTransit(Ubicacio ubicacio, int tipus) {
		this(generarCodi(tipus), tipus, ubicacio, GenerarParametresSenyal.generarAny(getAny()));
	}
	// Sobrecàrrega 3 constructors Sessió 2

	public SenyalTransit(int anyColocacio, Ubicacio ubicacio) {
		this(generarCodi(generarTipus()), generarTipus(), ubicacio, anyColocacio);
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

	// Problema trobat: S'ha de "crear" un objecte Ubicacio
	// per poder treballar amb les funcions de la classe
	// Ubicacio

	public String getUbicacio() {
		// String retorn= "";
		String carrer = "";
		String numero = "";
		// Ubicacio u;
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

	// Sobrecàrrega retirarViaPublica

	public boolean retirarViaPublica(int anyRetirada) {
		boolean retorn = false;
		if (ubi.treureSenyal(this)) {
			this.anyRetirada = anyRetirada;
			this.ubi = null;
			this.anyColocacio = 0;
			retorn = true;
		}
		return retorn;
	}

	private static String generarCodi(int tipus) {
		String codi = "";
		switch (tipus) {
		case 1:
			codi = "ROD";
			break;
		case 2:
			codi = "TRI";
			break;
		case 3:
			codi = "QUA";
			break;
		}
		for (int i = 0; i < 4; i++) {
			codi.concat(GenerarParametresSenyal.generarDigit() + "");
		}
		return codi;
	}

	private static int generarTipus() {
		String t = "";

		for (int i = 0; i < 4; i++) {
			t.concat(GenerarParametresSenyal.generarCodi().substring(i));
		}
		switch (t) {
		case "ROD":
			return advertencia;
		case "TRI":
			return reglamentacio;
		default:
			return indicacio;
		}
	}

	private static int getAny() {
		GregorianCalendar avui = new GregorianCalendar();
		int anyActual = avui.get(1);
		return anyActual;
	}

}