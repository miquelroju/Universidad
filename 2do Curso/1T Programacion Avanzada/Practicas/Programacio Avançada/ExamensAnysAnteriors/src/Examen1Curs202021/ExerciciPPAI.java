package Examen1Curs202021;

public class ExerciciPPAI implements Comparable<ExerciciPPAI> {
	
	public static final int facil = 0;
	public static final int mig = 1;
	public static final int dificil = 2;
	public static final int complicat = 3;
	public static final int moltDificil = 4;
	private String identificador; // No hi ha repetits
	private String enunciat;
	private boolean teAnimacio;
	private boolean interactivititatTeclat;
	private boolean interactivitatRatoli;

	public ExerciciPPAI(String identificador, String enunciat) {
		/*
		 * Un identificador és una cadena de 7 caràcters, formada exclusivament per
		 * dígits ‘0’, ‘1’ ... ‘9’. L’identificador té el següent format: XXXXART: Els 4
		 * primers (XXXX) poden ser qualsevol dels dígits indicats. La resta només poden
		 * ser ‘0’ o ‘1’ El cinquè (A) indica si l’exercici conté o no animació, ‘0’
		 * indica que no, ‘1’ indica que si. El sisè i setè (RT) fan referencia a quin
		 * tipus d’interactivitat, amb el ratolí el sisè i amb el teclat el setè. Només
		 * poden tenir una valor de ‘0’ o ‘1’ . Si ambdós són 0 no té interactivitat
		 */
	}

	public ExerciciPPAI(String enunciat, int XXXX, boolean animacio, boolean ratoli, boolean teclat) {
		/* Sobrecarrega del constructor */
	}

	public String getIdentificador() {
		return identificador.substring(0, 4); // Només els 4 primers dígits
	}

	public String getEnunciat() {
		return enunciat;
	}

	public boolean isAnimacio() {
		return teAnimacio;
	}

	public boolean isInteractivitatTeclat() {
		return this.interactivititatTeclat;
	}

	public boolean isInteractivitatRatoli() {
		return this.interactivitatRatoli;
	}

	public int grauDificultat() {
// es calcula tenint en compte diferents criteris de la tipologia de
// l’exercici.
	}

	public int compareTo(ExerciciPPAI o) {
// 4 primers dígits de l’identificador és el codi
		String s1 = this.identificador.substring(0, 4);
		String s2 = o.identificador.substring(0, 4);
		return s1.compareTo(s2);
	}
}
