package exercici_14_Ludos;

import java.util.Random;

public class Bombo {
    
    private int numBoles;
    private boolean haSortit[];
    private int numBolesFora;
    private Random alea;
    
    /* CONSTRUCTOR. crea un bombo amb el número de boles especificat, si
    aquest és major que zero. Si és zero o menor, crea un bombo
    de 49 boles. Les boles del bombo estaran numerades correlativament
    i la primera serà la número 1 */
    public Bombo(int numBoles) {
        if (numBoles<=0) {
            this.numBoles=49;
        } else {
            this.numBoles=numBoles;
        }
        numBolesFora=0;
        haSortit = new boolean[this.numBoles];
        for (int i=0; i<this.numBoles; i++) {
            haSortit[i]=false;
        }
        alea = new Random();
    }
    
    /* Treu, a l'atzar una bola del bombo, si en queden.
    El resultat és el numero de la bola extreta. Si ja no queden
    boles -perquè s'han fet numBoles extraccions, llavors retorna
    -1 */
    public int treureBola() {
        int extraccio;
        
        if (numBolesFora==numBoles) {return(-1);}
        
        extraccio=alea.nextInt(numBoles)+1;
        /* nextInt genera un nombre entre 0 i numBoles-1 (inclosos)
        per això sumem 1, per estar entre 1 i numBoles */
        
        while(haSortit[extraccio-1]) {
            extraccio=alea.nextInt(numBoles)+1;
        }
        
        haSortit[extraccio-1]=true;
        numBolesFora++;
        return(extraccio);
    }
    
    /* torna a omplir el bombo amb totes les boles, com si
    mai no se n'hagues tret cap */
    public void reinicialitzar() {
        numBolesFora=0;
        for (int i=0; i<numBoles; i++) {
            haSortit[i]=false;
        }
    }
    
}