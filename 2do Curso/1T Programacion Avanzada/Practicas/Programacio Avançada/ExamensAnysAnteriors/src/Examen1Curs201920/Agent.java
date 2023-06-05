package Examen1Curs201920;

public class Agent implements Comparable {
	
	public static final int MOSSO = 0;
	public static final int CAPORAL = 1;
	public static final int SERGENT = 2;
	public static final int SOTSINSPECTOR = 3;
	public static final int INSPECTOR = 4;
	public static final int INTENDENT = 5;
	public static final int COMISSARI = 6;
	public static final int MAJOR = 7;

	protected Placa placa;
	protected String identitat;
	protected int rang;
	
	public Agent (String identitat, String lletresPlaca, int numeroPlaca, int rang) {
		this.identitat = identitat;
		this.placa = new Placa(lletresPlaca, numeroPlaca);
		this.rang = rang;
	}
	
	public void promocionar() {
		if (rang < Agent.MAJOR) rang++;
	}
	
	public int compareTo (Object m) {
		if (!(m instanceof Agent)) throw new ClassCastException ("Tipus no correcte");
		
		Agent a = (Agent) m;
		if (a.placa.getNumero() < this.placa.getNumero()) return 1;
		if (a.placa.getNumero() > this.placa.getNumero()) return -1;
		if (a.placa.getLletres().length() < this.placa.getLletres().length()) return 1;
		if (a.placa.getLletres().length() > this.placa.getLletres().length()) return -1;
		return this.placa.getLletres().compareTo(a.placa.getLletres());
	}
	
	public int getRang() { return this.rang; }
	public Placa getPlaca() { return this.placa; }
	public String getIdentitat() { return this.identitat; }

}
