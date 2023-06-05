package exercici_12_13_Llibres;

public class Llibre {
    
    private String titol;
    private int punts;
    private int votants;
    private int categoria;
    
    public Llibre (String titol, int categoria) {
        this.titol = titol;
        punts = 0;
        votants = 0;
        this.categoria = categoria;
    }
    
    public String getTitol() {return titol;}
    public int getPunts() {return punts;}
    public int getVotants () {return votants;}
    public int getCategoria() {return categoria;}
    
    public void setCategoria (int categoria) {
        if (categoria>=1 && categoria<=4) {
            this.categoria = categoria;
        }
    }
    
    public void votar (int punts) {
        if (punts>=0 && punts<=10) {
            this.punts = this.punts+punts;
            votants = votants + 1;
        }
    }
    
    public double qualificacio () {
        if (votants==0) {return -1;}
        else {return punts*1.0/votants;}
    }
}