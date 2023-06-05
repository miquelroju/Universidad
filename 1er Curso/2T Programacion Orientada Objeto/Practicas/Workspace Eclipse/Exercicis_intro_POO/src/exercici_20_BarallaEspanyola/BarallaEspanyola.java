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
        /* treu i retorna un naip de la baralla (a l'atzar). L'extracci� es pot
         * codificar de la seg�ent manera:
         * generar un n�mero entre 0 i 47. Mentre el n�mero generat correspongui
         * a una posici� de la taula contingut que cont� null, tornar a generar
         * el n�mero.
         * Quan ja es t� un n�mero que correspon a una posici� que de la taula
         * contingut que no cont� null, el naip contingut en aquella posici�
         * ser� el que retornar� el m�tode
         * Posar null en aquella posici� (marca el naip com a extret)
         * comptabilitzar un naip extret m�s
         * Retornar el naip que hi havia en aquella posici� */
        
        if (extretes == 48) throw new BarallaException("Baralla �s buida!!!");
        
        Naip resultat;
        
        /* COMPLETAR */
        
        return resultat;
    }
    
    public boolean enQueden () {
        // m�tode per saber si encara es poden fer extraccions.
        return extretes < 48;
    }
    
    public void reset() {
        // deixa la baralla en el mateix estat que tenia just despr�s de la 
        // creaci�
        
        /* COMPLETAR */
    }
    
} // final de la classe Baralla