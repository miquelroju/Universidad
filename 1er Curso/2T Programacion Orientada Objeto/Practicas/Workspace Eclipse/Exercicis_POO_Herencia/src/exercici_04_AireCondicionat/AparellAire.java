package exercici_04_AireCondicionat;

public class AparellAire{

    public static int LIMIT_INFERIOR = 15; // límit inf. de qualsevol aparell
    public static int LIMIT_SUPERIOR = 33; // límit sup. de qualsevol aparell
    
    private String fabricant;
    private int tempMin,  tempMax; // limits de temperatura d'aquest aparell
    private int tempActual; // temperatura actualment programada
    private int memoria;  // temperatura actualment memoritzada
    private boolean on; // estat (encès -true- o apagat -false-);

    public AparellAire(String fabricant, int min, int max) {
        if (min<LIMIT_INFERIOR)
            throw new ExcepcioFabricacio("minim massa baix: "+min);
        if (max>LIMIT_SUPERIOR)
            throw new ExcepcioFabricacio("maxin massa alt: "+max);
        
        this.fabricant = fabricant;
        this.tempMin = min;
        this.tempMax = max;
        this.tempActual = (min+max)/2;
        this.memoria = this.tempActual;
        this.on = false;
    }

    
    /* mètodes de consulta dels valors dels atributs */
    public String getFabricant() {return this.fabricant;}
    public int getTempMin() {return this.tempMin;}
    public int getTempMax() {return this.tempMax;}
    public int getTempActual() {return this.tempActual;}
    public int getMemoria() {return this.memoria;}
    public boolean isOn() {return this.on;}

    
    /* mètodes de canvi d'estat de l'aparell */
   
    public boolean pulsarIterruptor() {
        this.on = !this.on;
        return this.on;
    }

    public void pujar() throws ExcepcioUtilitzacio {
        if (!this.on) 
            throw new ExcepcioEstatIncorrecte("Aparell apagat");
        
        if (this.tempActual == this.tempMax)
            throw new ExcepcioOperacioNoPermesa("Pujar. Temperatura màxima");
        else this.tempActual++;
    }

    public void baixar() throws ExcepcioUtilitzacio{
        if (!this.on) 
            throw new ExcepcioEstatIncorrecte("Aparell apagat");
        
        if (this.tempActual == this.tempMin)
            throw new ExcepcioOperacioNoPermesa("Baixar. Temperatura mínima");
        else this.tempActual--;
    }
    
    public void memoritzar () throws ExcepcioEstatIncorrecte {
        if (!this.on) 
            throw new ExcepcioEstatIncorrecte("Aparell apagat");
        else this.memoria = this.tempActual;
    }
    
    public void recuperarMemoria () throws ExcepcioEstatIncorrecte{
        if (!this.on) 
            throw new ExcepcioEstatIncorrecte("Aparell apagat");
        else this.tempActual = this.memoria;
    }
    
    public String toString () {
        String estat;
        if (this.on) estat = "ON";
        else estat = "OFF";
        return "Aparell Aire ("+this.fabricant+" )["
                +this.tempActual+"º] "+estat;
    }
   
}
