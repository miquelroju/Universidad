package Practica4EngSoftware;

public class Farmacia {
	
	private String DNI;
	private String email;
	private String ubicacio;
	
	public Farmacia(String DNI, String email, String ubicacio) {
		this.DNI = DNI; this.email = email; this.ubicacio = ubicacio;
	}
	
	public String getDNI () {return DNI;}
	public String getEmail() {return email;}
	public String getUbicacio() {return ubicacio;}
	
	public void setDNI (String DNI) {this.DNI = DNI;}
	public void setEmail (String email) {this.email = email;}
	public void setUbicacio (String ubicacio) {this.ubicacio = ubicacio;}

}
