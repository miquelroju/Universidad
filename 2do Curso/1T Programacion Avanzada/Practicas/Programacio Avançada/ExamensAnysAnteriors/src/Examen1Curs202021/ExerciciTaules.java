package Examen1Curs202021;

public class ExerciciTaules extends ExerciciPPAI {
	private int quantesMatrius;
	private int quantsVectors;

	public ExerciciTaules(String codi, String enunciat, int vectors, int matrius) {
		super(codi, enunciat);
		if (vectors < 0 || matrius < 0 || vectors + matrius == 0)
			throw new IllegalArgumentException("Quantitat incorrecte");
//Almenys ha d'haver 1
		this.quantesMatrius = matrius;
		this.quantsVectors = vectors;
	}

	public ExerciciTaules(String codi, String enunciat, int total) {
		this(codi, enunciat, (total - total / 3), total / 3);
	}

	public int getTaules() {
		return this.quantesMatrius + this.quantsVectors;
	}

	public int grauDificultat() {
//Redefinició. Pujar un nivell si és possible
		int q = super.grauDificultat();
		if (q != ExerciciPPAI.moltDificil)
			return q + 1;
		return q;
	}
}
