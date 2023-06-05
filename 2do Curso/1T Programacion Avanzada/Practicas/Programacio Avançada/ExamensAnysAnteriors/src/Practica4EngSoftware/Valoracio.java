package Practica4EngSoftware;

public class Valoracio {
	
	private int puntuacio;
	private String comentari;
	private Farmacia farmacia; // Farmacia que fa la valoracio
	
	public Valoracio(int puntuacio, String comentari, Farmacia farmacia) {
		this.puntuacio = puntuacio; this.comentari = comentari; this.farmacia = farmacia;
	}
	
	public int getPuntuacio() {return puntuacio;}
	public String getComentari() {return comentari;}
	public Farmacia getFarmacia() {return farmacia;}
	
	public void setPuntuacio(int puntuacio) {this.puntuacio = puntuacio;}
	public void setComentari(String comentari) {this.comentari = comentari;}
	public void setFarmacia(Farmacia farmacia) {this.farmacia = farmacia;}

}
