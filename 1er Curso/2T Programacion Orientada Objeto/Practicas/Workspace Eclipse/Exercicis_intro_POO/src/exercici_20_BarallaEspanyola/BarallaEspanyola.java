package exercici_20_BarallaEspanyola;

import java.util.Random;

 public class BarallaEspanyola {

    private Naip contingut[];  // lloc on es guarden els 48 naips
    private Random alea; // generador de numeros aleatoris per fer extracccions
    private int extretes; // numero de cartes que ja han sortit
    
    public BarallaEspanyola() {
        /* crear la taula contingut i omplir-la amb els 48 naips de la 
         * baralla espanyola (12 naips de cada coll) */
        
        /* COMPLETAR */
        
        alea = new Random();
        extretes = 0;
    }
    
    public Naip extraureNaip() {
        /* treu i retorna un naip de la baralla (a l'atzar). L'extracció es pot
         * codificar de la següent manera:
         * generar un número entre 0 i 47. Mentre el número generat correspongui
         * a una posició de la taula contingut que conté null, tornar a generar
         * el número.
         * Quan ja es té un número que correspon a una posició que de la taula
         * contingut que no conté null, el naip contingut en aquella posició
         * serà el que retornarà el mètode
         * Posar null en aquella posició (marca el naip com a extret)
         * comptabilitzar un naip extret més
         * Retornar el naip que hi havia en aquella posició */
        
        if (extretes == 48) throw new BarallaException("Baralla és buida!!!");
        
        Naip resultat;
        
        /* COMPLETAR */
        
        return resultat;
    }
    
    public boolean enQueden () {
        // mètode per saber si encara es poden fer extraccions.
        return extretes < 48;
    }
    
    public void reset() {
        // deixa la baralla en el mateix estat que tenia just després de la 
        // creació
        
        /* COMPLETAR */
    }
    
} // final de la classe Baralla