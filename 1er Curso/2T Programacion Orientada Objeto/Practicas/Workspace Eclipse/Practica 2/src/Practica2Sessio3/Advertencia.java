package Practica2Sessio3;
import java.math.*;

public class Advertencia extends SenyalTransit {
	
	private String significatSenyal;

	private double costat;
	
	public String getSignificatSenyal() {return this.significatSenyal;}
	public double getCostat() {return this.costat;}
	
	public Advertencia (String codi, Ubicacio ubicacio, int anyColocacio, String descripcio) {
		this.significatSenyal = codi;
		this.costat = Math.PI * (CIRCULAR/2) * (CIRCULAR/2);
	}

}
