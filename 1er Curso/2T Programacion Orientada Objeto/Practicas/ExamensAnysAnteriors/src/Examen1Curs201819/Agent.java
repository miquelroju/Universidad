package Examen1Curs201819;

public class Agent {
	
	public static final int MOSSO = 1;
	public static final int CAPORAL = 2;
	public static final int SERGENT = 3;
	public static final int SOTSINSPECTOR = 4;
	public static final int INSPECTOR = 5;
	public static final int INTENDENT = 6;
	public static final int COMISSARI = 7;
	public static final int MAJOR = 8;

	public static final double PUNTS_SOU_BASE = 10.5;
	// atributs propis
	protected Placa placa; // identificador
	protected String identitat; // nom de l’agent
	protected int rang; 
	
	public Agent (String identitat, String lletresPlaca, int numeroPlaca, int rang) {
		
	}

}
