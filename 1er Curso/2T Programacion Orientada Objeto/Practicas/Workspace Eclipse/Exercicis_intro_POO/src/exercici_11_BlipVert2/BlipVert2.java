package exercici_11_BlipVert2;

public class BlipVert2 {
    private int alfa;
    private int beta;
    private boolean gamma;
    
    public BlipVert2 (int alfa, int beta) {
        this.alfa = alfa;
        this.beta = beta;
        this.gamma = alfa%2 == beta%2;
    }
   
    public int getAlfa() {return(this.alfa);}
    public int getBeta() {return(this.beta);}
    public boolean getGamma() {return(this.gamma);}
    
    public void blip(int alfa) {
        int beta;
        beta = this.beta%2;
        if (beta>0) {
            alfa = 2*alfa;
            this.alfa = this.alfa + alfa;
        }
    }
    
    public void vert (int beta) {
        this.beta = beta%2 + alfa;
    }
    
    public void reGamma() {
        gamma = alfa%2 == beta%2;
    }
}

