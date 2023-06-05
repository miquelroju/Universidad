package Sessio2;

public class Poblacio {
	private String nom;
	private int numH;
	private Ubicacio[][] ubicacions; // per cada pos hi ha un vector amb x components-->matriu
	private int numAH;
	private int numIN;
	private int numOZ;
	private final int MAX_Ubicacions;

	public Poblacio(int Maxim, String poblacio, int numHabitants) {
		this.MAX_Ubicacions = Maxim;
		this.nom = poblacio;
		this.numH = numHabitants;
		this.ubicacions = new Ubicacio[3][this.MAX_Ubicacions];
		this.numAH = 0;
		this.numIN = 0;
		this.numOZ = 0;
	}

//No se puede
	public void imprimir() {
		for (int i = 0; i < 3; i++) {
			int aux;
			if (i == 0) {
				aux = this.numAH;
			} else if (i == 1) {
				aux = this.numIN;
			} else {
				aux = this.numOZ;
			}
			for (int j = 0; j < aux; j++) {
				System.out.println(this.ubicacions[i][j].getNomCarrer() + "-" + this.ubicacions[i][j].getNumCarrer());
			}
		}
	}

	public void impirmirA() {
		System.out.println("Imprimir fila 0");
		for (int i = 0; i < this.numAH; i++) {
			System.out.println(this.ubicacions[0][i].getNomCarrer());
		}
		System.out.println("********************");
	}

	public void impirmirI() {
		System.out.println("Imprimir fila 1");
		for (int i = 0; i < this.numIN; i++) {
			System.out.println(this.ubicacions[1][i].getNomCarrer());
		}
		System.out.println("*********************");
	}

	public void impirmirO() {
		System.out.println("Imprimir fila 2");
		for (int i = 0; i < this.numOZ; i++) {
			System.out.println(this.ubicacions[2][i].getNomCarrer());
		}
		System.out.println("*********************");
	}

//Hasta aqui
	public String getNom() {
		return nom;
	}

	public int getNumH() {
		return numH;
	}

	public int getNumAH() {
		return numAH;
	}

	public int getNumIN() {
		return numIN;
	}

	public int getNumOZ() {
		return numOZ;
	}

	public int getMAX_Ubicacions() {
		return MAX_Ubicacions;
	}

	private static int fila(char x) {
		x = Character.toUpperCase(x);
		if (x >= 'A' && x <= 'H') {
			return 0;
		} else if (x >= 'I' && x <= 'N') {
			return 1;
		} else {
			return 2;
		}
	}

	private int numFila(int fila) {
		switch (fila) {
		case 0:
			return this.numAH;
		case 1:
			return this.numIN;
		case 2:
			return this.numOZ;
		default:
			return -1;
		}
	}

	private void Aumentar(int fila) {
		switch (fila) {
		case 0:
			this.numAH++;
			break;
		case 1:
			this.numIN++;
			break;
		case 2:
			this.numOZ++;
			break;

		}
	}

	private void Disminuir(int fila) {
		switch (fila) {
		case 0:
			this.numAH--;
			break;
		case 1:
			this.numIN--;
			break;
		case 2:
			this.numOZ--;
			break;

		}
	}

	public boolean afegirUbicacio(Ubicacio c) {

		int fila = Poblacio.fila(c.getNomCarrer().charAt(0));// fila en la que nos encontramos respecto a inicio de
																// palabra
		int col = numFila(fila); // max columnes plenes
		if (col == this.MAX_Ubicacions)
			return false;

		for (int i = 0; i < col; i++) {
			if (this.ubicacions[fila][i].iguals(c)) {
				return false;
			}
		}
		this.ubicacions[fila][col] = c;
		Aumentar(fila);
		return true;
	}

	public boolean eliminarUbicacio(Ubicacio c) {

		int fila = fila(c.getNomCarrer().charAt(0));
		int col = numFila(fila);
		for (int i = 0; i < col; i++) {
			if (this.ubicacions[fila][i].iguals(c)) {
				this.ubicacions[fila][i] = this.ubicacions[fila][col - 1];
				Disminuir(fila);
				this.ubicacions[fila][col - 1] = null;
				return true;
			}
		}
		return false;
	}

	public int quantes() {

		// seria posible fer sobrecarrgar pero crearia una super ineficiencia
		/*
		 * int num=0; for(int i=0;i<26;i++) { num+=this.quantes(i+'a'); } return num;
		 */
		int num = 0;
		int col = this.numAH;
		for (int i = 0; i < this.ubicacions.length; i++) {
			if (i == 1)
				col = this.numIN;
			else if (i == 2)
				col = this.numOZ;

			int j = 0;
			while (j < col && this.ubicacions[i][j].getNumSenyals() != 0) {
				num += this.ubicacions[i][j].getNumSenyals();
				j++;
			}
		}
		return num;

	}

	public int quantes(char quin) {
		int num = 0;
		int fila = Poblacio.fila(quin);
		int col = numFila(quin);
		quin = Character.toUpperCase(quin);
		for (int i = 0; i < col; i++) {
			if (quin == this.ubicacions[fila][i].getNomCarrer().charAt(0))
				num += this.ubicacions[fila][i].getNumSenyals();
		}
		return num;
		/*
		 * int fila = Poblacio.fila(quin); int col = numFila(quin); int num = 0; for
		 * (int i = 0; i < col; i++) {
		 * 
		 * if (Character .toUpperCase(this.ubicacions[fila][i].getNomCarrer().charAt(0))
		 * == (Character.toUpperCase(quin))) { num +=
		 * this.ubicacions[fila][i].getNumSenyals(); } }
		 * 
		 * return num;
		 */
	}

	public int quantes(char inici, char fi) {
		// aqui per implementar la sobrecarregar tenim ineficiencia
		int num = 0;
		for (int i = 0; i < inici - fi; i++) {
			char letra = (char) (inici + i);
			num += this.quantes(letra);
		}
		return num;
	}

	private static int tipusSenyal(String tipus) {
		if (tipus.equalsIgnoreCase("Advertència")) {
			return SenyalTransit.PERILL;
		} else if (tipus.equalsIgnoreCase("Reglamentació")) {
			return SenyalTransit.REGLAMENTACIO;
		} else {
			return SenyalTransit.INDICACIO;
		}
	}

	public int quantes(int tipusSenyal) {
		int num = 0;

		for (int i = 0; i < 26; i++) {
			char letra = (char) ('a' + i);
			num += this.quantes(letra, tipusSenyal);
		}
		return num;
	}

	public int quantes(char quin, int tipusSenyal) {
		int fila = fila(quin);
		int col = numFila(fila);
		int num = 0;
		for (int j = 0; j < col; j++) {
			int indice = 0;
			while (this.ubicacions[fila][j].getSenyal(indice) != null) {
				if (tipusSenyal(this.ubicacions[fila][col].getSenyal(indice).getTipusSenyal()) == tipusSenyal) {
					num++;
				}
				indice++;
			}
		}
		return num;
	}

	public int quantes(char inici, char fi, int tipusSenyal) {
		int num = 0;
		for (int i = 0; i < inici - fi; i++) {
			char letra = (char) (inici + i);
			num += this.quantes(letra, tipusSenyal);
		}
		return num;
	}

}
