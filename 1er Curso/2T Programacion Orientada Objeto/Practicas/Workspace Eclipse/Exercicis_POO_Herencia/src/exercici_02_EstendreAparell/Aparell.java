package exercici_02_EstendreAparell;

public class Aparell {
    
    // possibles ubicacions d'un aparell
    public static final int MAGATZEM = 0;
    public static final int EMPLEAT = 1;
    public static final int DIRECCIO = 2;
    public static final int ALTRES = 3;
    
    // atributs de tots els aparells
    protected final int anyCompra;
    protected final double preuCompra;
    protected int ubicacio;
    
    // Constructor
    public Aparell (int anyCompra, double preuCompra) {
        this.anyCompra = anyCompra;
        this.preuCompra = preuCompra;
        this.ubicacio = Aparell.MAGATZEM;
    }
    
    // mètodes d'accés als atributs
    public int getAnyCompra () {return this.anyCompra;}
    public double getPreuCompra () {return this.preuCompra;}
    public int getUbicacio () {return this.ubicacio;}
    
    // mètode set per a la ubicació
    public void setUbicacio (int ubicacio) {
        if (ubicacio <0 || ubicacio >3) {
            throw new IllegalArgumentException("ubicacio incorrecta");
        }
        else {
            this.ubicacio = ubicacio;
        }
    } 
}