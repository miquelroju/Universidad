package exercici_02_Examen;

public class Examen {

    /* Poseu aquí­ els atributs i els mètodes de la classe Examen */
    
	private String nomEstudiant;
	private double q1,q2;
	private boolean modificable;
	
	public Examen (String nom) {
		nomEstudiant = nom;
		q1 = 0.0;
		q2 = 0.0;
		modificable = true;
	}
	
	public String getNomEstudiant {
		return nomEstudiant;
	}
	public double getQ1 {return q1;}
	
}
