package Examen1Curs202021;

public class ExerciciProcediments extends ExerciciPPAI {
	private int quantesFuncions;
	private int quantesNOFuncions;

	public ExerciciProcediments(String codi, String enunciat, int funcions, int nofuncio) {
		super(codi, enunciat);
		if (funcions < 0 || nofuncio < 0 || funcions + nofuncio == 0)
			throw new IllegalArgumentException("Quantitat incorrecte");
//Almenys ha d'haver 1
		this.quantesFuncions = funcions;
		this.quantesNOFuncions = nofuncio;
	}

	public ExerciciProcediments(String codi, String enunciat, int total) {
		this(codi, enunciat, total / 2, total / 2);
		if (total % 2 == 1)
			this.quantesNOFuncions++;
	}

	public int grauDificultat() {
//Redefinició. Pujar un nivell si és possible
		int q = super.grauDificultat();
		if (q != ExerciciPPAI.moltDificil)
			return q + 1;
		return q;
	}

	public int getProcediments() {
		return this.quantesFuncions + this.quantesNOFuncions;
	}
}