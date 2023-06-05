package Sessio3;

import java.util.GregorianCalendar;

public abstract class SenyalTransit extends GenerarParametresSenyal {

	/*
	 * public static final String INDICACIO_RECTANGULAR = "REC"; public static final
	 * String INDICACIO_QUADRADA = "QUA"; public static final String REGLAMENTACIO =
	 * "ROD"; public static final String PERILL = "TRI";
	 */

	public static final int INDICACIO = 1;
	public static final int REGLAMENTACIO = 2;
	public static final int PERILL = 3;

	private String codi;
	private int tipus;
	private Ubicacio ubicacio;
	private int anyColocacio;
	private int anyRetirada;
	public int circular = 50;// cm diametre
	public int triangulars = 70;// cm costat
	public int rectangularsAlcada = 132;// cm
	public int rectangularCostat = 93;// cm
	protected int numPerill;
	protected int numReglamentacio;
	protected int numIndicacio;

	private static GregorianCalendar avui = new GregorianCalendar();
	public static int anyActual = avui.get(1);

	public SenyalTransit(String codi, Ubicacio ubicacio, int anyColocacio) {
		this.codi = codi;
		this.tipus = tipusSenyal();

		this.ubicacio = ubicacio;
		if (this.ubicacio == null || !this.ubicacio.afegirSenyal(this)) { // Tinc dubtes que aixo estigui be, jo tambe
			this.anyColocacio = 0;
			this.anyRetirada = anyColocacio;
		} else {
			this.anyColocacio = anyColocacio;
			this.anyRetirada = 0;
		}
	}

	public SenyalTransit(Ubicacio ubicacio) {
		this(generarAny(anyActual), ubicacio);
	}

	public SenyalTransit(int anyColocacio, Ubicacio ubicacio) {
		this(generarCodi(), ubicacio, anyColocacio);
	}

	private int tipusSenyal() {
		String tipus = this.codi.substring(this.codi.length() - 3);
		if (tipus.equalsIgnoreCase("TRI")) {
			return SenyalTransit.PERILL;
		} else if (tipus.equalsIgnoreCase("ROD")) {
			return SenyalTransit.REGLAMENTACIO;
		}
		return SenyalTransit.INDICACIO;
	}

	public int getNumPerill() {
		return numPerill;
	}

	public int getNumReglamentacio() {
		return numReglamentacio;
	}

	public int getNumIndicacio() {
		return numIndicacio;
	}

	

	public boolean retirarViaPublica() {
		if (!this.ubicacio.treureSenyal(this))
			return false;

		this.anyRetirada = anyActual;
		this.ubicacio = null;
		this.anyColocacio = 0;
		return true;
	}

	public boolean retirarViaPublica(int anyRetirada) {
		this.anyActual = anyRetirada; // no se si es fa aixi
		return this.retirarViaPublica();
	}

	public String getUbicacio() {
		if (this.ubicacio == null)
			return null;
		else
			return this.ubicacio.getNomCarrer() + " " + this.ubicacio.getNumCarrer();
	}

	public boolean canviarUbicacio(Ubicacio novaUbicacio) {
		if (novaUbicacio != null) {
			if (!novaUbicacio.afegirSenyal(this))
				return false;
			else {
				if (this.ubicacio != null)
					this.ubicacio.treureSenyal(this);

				this.ubicacio = novaUbicacio;
				this.ubicacio.afegirSenyal(this);
				return true;
			}
		}
		return false;
	}

	public String getCodi() {
		return this.codi;
	}

	public String getEstat() {
		int diferenciaAnys;
		if (this.anyColocacio != 0) {
			diferenciaAnys = (this.anyActual - this.anyColocacio);
		} else {
			diferenciaAnys = this.anyActual - this.anyRetirada;
		}
		if (diferenciaAnys > 4)
			return "Vell " + diferenciaAnys + " " + this.anyColocacio;
		else if (diferenciaAnys >= 2 && diferenciaAnys <= 4)
			return "Semi nou " + diferenciaAnys + " " + this.anyColocacio;
		else
			return "Nou " + diferenciaAnys + " " + this.anyColocacio;
	}

	public String toString() {
		return "SenyalTransit [codi=" + this.codi + ", tipus=" + this.tipus + ", ubicacio=" + this.ubicacio
				+ ", anyColocacio=" + this.anyColocacio + ", anyRetirada=" + this.anyRetirada + ", circular="
				+ this.circular + ", triangulars=" + this.triangulars + ", rectangularsAlcada="
				+ this.rectangularsAlcada + ", rectangularCostat=" + this.rectangularCostat + ", numPerill="
				+ this.numPerill + ", numReglamentacio=" + this.numReglamentacio + ", numIndicacio=" + this.numIndicacio
				+ "]";
	}
	public abstract float area();

}
