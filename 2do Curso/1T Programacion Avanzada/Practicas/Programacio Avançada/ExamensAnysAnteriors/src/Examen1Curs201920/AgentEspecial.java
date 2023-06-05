package Examen1Curs201920;

public class AgentEspecial extends Agent {
	
	private String nomEnClau;
	
	public AgentEspecial (String nomEnClau, String lletresPlaca, int numeroPlaca) {
		super("Encoberta", lletresPlaca, numeroPlaca, Agent.SERGENT);
		this.nomEnClau = nomEnClau;
	}
	
	public AgentEspecial(String nomEnClau, Placa p) {
		this (nomEnClau, p.getLletres(), p.getNumero());
	}
	
	public String getNomEnClau() {
		return nomEnClau;
	}

}