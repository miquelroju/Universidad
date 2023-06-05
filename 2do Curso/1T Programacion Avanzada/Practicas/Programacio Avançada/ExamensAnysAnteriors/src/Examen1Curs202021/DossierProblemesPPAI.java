package Examen1Curs202021;

public class DossierProblemesPPAI {

	public class ExcepcioDossier extends Throwable {
		ExcepcioDossier(String msg) {
			super(msg);
		}
	}

	public class ExcepcioInserirDossier extends Exception {
		public ExcepcioInserirDossier(String msm) {
			super(msm);
		}
	}

	public class ExcepcioEsborrarDossier extends Exception {
		public ExcepcioEsborrarDossier(String msm) {
			super(msm);
		}
	}

	private class Node {
		ExerciciPPAI inf;
		Node seg;

		public Node(ExerciciPPAI m, Node seg) {
			inf = m;
			seg = seg;
		}
	} // Fi classe Node

	private Node[][] magatzems;
	private AcbEnll<ExerciciPPAI> examen;

	public DossierProblemesPPAI() {
		this.magatzems = new Node[3][5];
		for (int i = 0; i < magatzems.length; i++) {
			for (int j = 0; j < magatzems[i].length; j++) {
				magatzems[i][j] = null;
			}
		}
		this.examen = new AcbEnll<ExerciciPPAI>();
	}

	private static int quin(ExerciciPPAI exer) {
		boolean animacio = exer.isAnimacio();
		boolean interactivitat = exer.isInteractivitatRatoli() || exer.isInteractivitatTeclat();
		int fila = -1;
		if (!exer.isAnimacio() && !(exer.isInteractivitatRatoli() && exer.isInteractivitatTeclat()))
			fila = 0;
		if (!animacio && !interactivitat)
			fila = 0;
		if ((!animacio && interactivitat) || (animacio && !interactivitat))
			fila = 1;
		if (animacio && interactivitat)
			fila = 2;
		int col = exer.grauDificultat();
		return ((fila + 1) * 10) + (col + 1);
	}

	private Node onEs(ExerciciPPAI exer) throws ExcepcioDossier {
		int on = quin(exer);
		Node aux = magatzems[on / 10 - 1][on % 10 - 1];
		if (aux == null)
			throw new ExcepcioDossier("No hi es");
		if (magatzems[on / 10 - 1][on % 10 - 1].inf.compareTo(exer) == 0)
			return null;
		while (aux.seg != null && aux.seg.inf.compareTo(exer) != 0)
			aux = aux.seg;
		if (aux.seg == null)
			throw new ExcepcioDossier("No hi es");
		else
			return aux;
	}
	
	public void afegirExercici(ExerciciPPAI exer, boolean examen) throws ExcepcioInserirDossier {
		Node aux;
		try {
			aux = onEs(exer);
			throw new ExcepcioInserirDossier("Exercici repetit. Ja esta al dossier");
		} catch (ExcepcioDossier e) {
			int on = quin(exer);
			aux = magatzems[on / 10 - 1][on % 10 - 1];
			magatzems[on / 10 - 1][on % 10 - 1] = new Node(exer, aux);
			if (examen) {
				try {
					this.examen.Inserir(exer);
				} catch (Exception m) {				
				}
			}
		}
	}
	
	public void eliminarExercici (ExerciciPPAI exer) throws ExcepcioEsborrarDossier {
		Node aux;
		try {
			aux = onEs(exer);
			if (aux == null) {
				int on = quin(exer);
				magatzems[on / 10 - 1][on % 10 - 1] = magatzems[on / 10 - 1][on % 10 - 1].seg;
			}
			try {
				this.examen.Esborrar(exer);
			} catch (Exception m) {
			}
		} catch (ExcepcioDossier e) {
			throw new ExcepcioEsborrarDossier("No esta al dossier");
		}
	}
	
	public double percentatgeExerciciExamenSupers() {
		return examen.percentatge();
	}
	
	public int ExerciciExamenAmbProcediments throws ExcepcioDossier {
		return examen.ExerciciExamenAmbProcediments();
	}

}



















