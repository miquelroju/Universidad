package exercici_03_NomCognoms;

public class NomCognoms implements Comparable{

    private String nom;
    private String cognom1;
    private String cognom2 = null;
    
    public NomCognoms (String nom, String cognom1) {
        if (nom == null)
            throw new IllegalArgumentException("nom no admet valor null");
        if (cognom1 == null)
            throw new IllegalArgumentException("cognom1 no admet valor null");
        this.nom = nom;
        this.cognom1 = cognom1;
    }
    
    public NomCognoms (String nom, String cognom1, String cognom2) {
        this(nom, cognom1); // invocació de l'altre constructor
        this.cognom2 = cognom2;
    }
    
    public String getNom() {return this.nom;}
    public String getCognom1() {return this.cognom1;}
    public String getCognom2() {
        /* Si cognom2 és null el valor retornat és null. 
         * És obligació de qui invoca el mètode i en recull el
         * resultat verificar si el resultat a estat o no null */
        return this.cognom2;
    }
    
    public String toString() {
        /* El resultat és 
           cognom1 cognom2, nom   si cognom2 no és null. Altrament és 
           cognom1, nom
         */
        if (cognom2 != null) return cognom1+" "+cognom2+", "+nom;
        else return cognom1+", "+nom;
    }
    
    
    /* Cal completar la classe amb la implementació de la interfície
     * Comparable. No altereu res del que ja hi ha */
    
}
