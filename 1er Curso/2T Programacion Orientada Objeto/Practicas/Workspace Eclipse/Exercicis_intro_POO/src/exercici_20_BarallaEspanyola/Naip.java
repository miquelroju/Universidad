package exercici_20_BarallaEspanyola;

public class Naip {

    public static final int OROS = 0;
    public static final int BASTOS = 10;
    public static final int ESPASES = 20;
    public static final int COPES = 40;
    
    private int coll;
    private int numero;
    
    public Naip (int coll, int numero) {
        if (coll!=OROS && coll!=BASTOS && coll!=ESPASES & coll!=COPES)
            throw new NaipException("coll incorrecte");
        
        if (numero<1 || numero>12) 
            throw new NaipException("numero incorrecte "+numero);
        
        this.coll = coll;
        this.numero = numero;
    }
    
    public int getColl() {return this.coll;}
    public int getNumero() {return this.numero;} 
    
    public String toString () {
        String coll, nom;
        coll="";
        switch (this.coll) {
            case OROS: coll="OROS"; break;
            case COPES: coll="COPES"; break;
            case ESPASES: coll="ESPASES"; break;
            case BASTOS: coll="BASTOS"; break;
        }
        
        switch(this.numero) {
            case 1: nom="AS"; break;
            case 10: nom="SOTA"; break;
            case 11: nom="CAVALL"; break;
            case 12: nom="REI"; break;
            default: nom=""+this.numero;        
        }
        return nom + " de " + coll;
    }
    
} // final de la classe NAIP