package exercici_01_EstendreMoble;

public class Moble {
    
    // diferents estats dels mobles
    public static final int NOU = 0;
    public static final int SEMINOU = 1;
    public static final int EXPOSICIO = 2;
    
    // Atributs. Protected permet l'ús directe per part de les subclasses
    protected final String marca;
    protected final String model;
    protected final double pes; // pes en Kg
    protected final double volum; // volum en litres 
    protected final boolean fragil;
    protected double preuBase; // preu base en euros
    protected int estat; // NOU, SEMINOU o EXPOSICIO
    
    // constructor
    public Moble (String marca, String model, double pes, double volum, 
                  boolean fragil, double preuBase, int estat) {
        this.marca = marca;
        this.model = model;
        this.pes = pes; 
        this.volum = volum; 
        this.fragil= fragil;
        this.preuBase = preuBase;
        this.estat = estat;
    }
    
    // Col·lecció de mètodes get
    public String getMarca () {return this.marca;}
    public String getModel () {return this.model;}
    public double getPes () {return this.pes;}
    public double getVolum () {return this.volum;}
    public boolean getFragil () {return this.fragil;}
    public double getPreuBase () {return this.preuBase;}
    public int getEstat () {return this.estat;}
    
    // col·lecció de mètodes set
    public void setPreuBase (double preuBase) {this.preuBase=preuBase;}
    public void setEstat (int estat) {
        if (estat >= Moble.NOU && estat <= Moble.EXPOSICIO) {
            this.estat = estat;
        }
    }
    
    // determinar el preu del moble en funció del preu base i l'estat
    public double calculaPreu () {
        double pr = 0.0;
        switch (this.estat) {
            case NOU: pr=this.preuBase;  break;
            case SEMINOU: pr=this.preuBase*0.8; break;
            case EXPOSICIO: pr=this.preuBase*0.4; break; 
        }
        return pr;
    }
    
    // determinar les despeses de transport en funció de KM, preu per KG i KM i
    // el suplement per volum
    public double calcularDespesesTransport (int km, double preuPerKgKm) {
        double despesa;
        // els primers 50 KM són gratis, sempre
        if (km <= 50) {despesa = 0.0;}
        else {
            despesa = (km-50)*this.pes*preuPerKgKm;
            // volums superiors a 1000 litres tenen un suplement de 50 euros
            if (this.volum > 1000) {despesa = despesa + 50;}
            // els mobles fràgils tenen un suplement de 30 euros més
            if (this.fragil) {despesa = despesa + 30;}
        }
        return despesa;
    }
}