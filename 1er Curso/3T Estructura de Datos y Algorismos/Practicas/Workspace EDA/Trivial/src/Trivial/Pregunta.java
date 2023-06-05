package Trivial;

public class Pregunta {
	
	private String question;
	private boolean truth;
	private int difficulty;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public boolean getTruth() {
		return truth;
	}
	public void setTruth(boolean truth) {
		this.truth = truth;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public Pregunta (String nom, boolean cert, int dif) {
		this.question = nom;
		this.truth = cert;
		this.difficulty = dif;
	}

}
