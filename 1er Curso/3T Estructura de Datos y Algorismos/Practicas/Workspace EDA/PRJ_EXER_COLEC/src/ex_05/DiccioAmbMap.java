package ex_05;

import java.util.*;

/* Implementació de la interfície DiccionariSinonims basada en
 * un map */

public class DiccioAmbMap implements DiccionariSinonims{

    private Map<String, Set<String>> infrastructura;

    /* constructor */
    public DiccioAmbMap () {
        // només cal crear la infrastructura
        /* COMPLETAR: useu una instància de la classe TreeMap */
        
    }

    public boolean afegir(String paraula, String sinonim) {
        String pMaj = paraula.toUpperCase();
        String sMaj = sinonim.toUpperCase();
        // si la paraula pMaj existeix, en recuperem el conjunt de
        // sinònims i provem d'afegir-hi el que ens han donat sMaj
        if (/* COMPLETAR: pMaj és una clau a la infrastructura? */) {
            Set<String> sinonims = /* COMPLETAR: recupetar els sinònims */
            /* COMPLETAR: afegir sMaj als sinònims i retornar */
        }
        else {
            // si no existeix li vinculem un nou conjunt de sinònims que
            // de moment només conté el sinònim donat
            Set<String> nou = new TreeSet<String>();
            /* COMPLETAR: vincular pMaj amb nou */
            return nou.add(sMaj);
        }
    }

    public boolean afegir(String paraula, Set<String> sinonims) {
        // Proveu d'implementat aquest mètode sense fer ús de l'anterior.
        // una iteració for-each sobre el segon paràmetre us serà útil.
        // Recordeu que la paraula (primer paràmetre) pot ser nova o no.
        /* COMPLETAR */
       
    }

    public String[] recuperar(String paraula) {
        String pMaj = paraula.toUpperCase();
        String [] resultat;
        // si la paraula hi és, recuperem el seu conjunt de sinònims i el
        // "volquem" en una taula de nova creació
        if (this.infrastructura.containsKey(pMaj)) {
            Set<String> sinonims = this.infrastructura.get(pMaj);
            /* COMPLETAR: crear la taula resultat i omplir-la amb el contingut
             * de sinonims */
         }
         else {
            // i si no hi és ens limitem a crear una taula de mida 0
            resultat = new String[0];
         }
         return (resultat);
    }

    public String[] paraulesConegudes() {
        /* COMPLETAR: declarar la variable paraules de tal manera que pugui
         * referenciar un conjunt de claus -Strings- */
        String [] resultat;
        paraules = /* COMPLETAR: recuperar el conjunt de claus */
        /* COMPLETAR: crear la taula resultat i omplir-la amb el contingut
         * del conjunt de claus */
        
        return(resultat);
    }

}
