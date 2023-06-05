package exercici_08_09_CompteCorrent;

public class CompteCorrent {
    private String titular;
    private int numero;
    private double saldo;
    private double limitCredit;
    
    
    public CompteCorrent(String titular, int numero) {
        this.titular = titular; // this necessari
        this.numero = numero; // this necessari
        
        this.saldo = 0.0; // this no necessari
        this.limitCredit = 0.0; // this no necessari
    }
    
   /* Mètodes d'accés. En tots quatre casos this no és
   necessari perquè no hi ha possibilitat de conflicte */
    public String getTitular() {return this.titular;}
    public int getNumero() {return this.numero;}
    public double getSaldo() {return this.saldo;}
    public double getLimitCredit() {return this.limitCredit;}
    
    public void setLimitCredit(double limitCredit) {
        if (limitCredit>=0) {
            this.limitCredit = limitCredit; // this necessari
        }
    }
    
    public void ingressar(double quant) {
        if (quant>0) {
            this.saldo = this.saldo + quant; // this no necessari
        }
    }
    
    public boolean retirar(double quant) {
        double saldo;
        boolean ok;
        
        if (quant>0) {
            saldo = this.saldo - quant; // this necessari
            if (saldo<0) {
                if (this.valAbs(saldo) <= this.limitCredit) {
                    ok = true;
                    this.saldo = saldo; // this necessari
                } 
                else {
                    ok = false;
                }
            } 
            else {
                ok = true;
                this.saldo = saldo; // this.necessari
            }
        } 
        else { ok = false;}
        
        return ok;
    }
    
    private double valAbs(double n) {
        if (n>=0.0) {return n;} 
        else {return -n;}
    }
    
}