package ex_05;

import java.util.*;

/* Implementaci� de la interf�cie DiccionariSinonims basada en
 * un map */

public class DiccioAmbMap implements DiccionariSinonims{

    private Map<String, Set<String>> infrastructura;

    /* constructor */
    public DiccioAmbMap () {
        // nom�s cal crear la infrastructura
        /* COMPLETAR: useu una inst�ncia de la classe TreeMap */
        
    }

    public boolean afegir(String paraula, String sinonim) {
        String pMaj = paraula.toUpperCase();
        String sMaj = sinonim.toUpperCase();
        // si la paraula pMaj existeix, en recuperem el conjunt de
        // sin�nims i provem d'afegir-hi el que ens han donat sMaj
        if (/* COMPLETAR: pMaj �s una clau a la infrastructura? */) {
            Set<String> sinonims = /* COMPLETAR: recupetar els sin�nims */
            /* COMPLETAR: afegir sMaj als sin�nims i retornar */
        }
        else {
            // si no existeix li vinculem un nou conjunt de sin�nims que
            // de moment nom�s cont� el sin�nim donat
            Set<String> nou = new TreeSet<String>();
            /* COMPLETAR: vincular pMaj amb nou */
            return nou.add(sMaj);
        }
    }

    public boolean afegir(String paraula, Set<String> sinonims) {
        // Proveu d'implementat aquest m�tode sense fer �s de l'anterior.
        // una iteraci� for-each sobre el segon par�metre us ser� �til.
        // Recordeu que la paraula (primer par�metre) pot ser nova o no.
        /* COMPLETAR */
       
    }

    public String[] recuperar(String paraula) {
        String pMaj = paraula.toUpperCase();
        String [] resultat;
        // si la paraula hi �s, recuperem el seu conjunt de sin�nims i el
        // "volquem" en una taula de nova creaci�
        if (this.infrastructura.containsKey(pMaj)) {
            Set<String> sinonims = this.infrastructura.get(pMaj);
            /* COMPLETAR: crear la taula resultat i omplir-la amb el contingut
             * de sinonims */
         }
         else {
            // i si no hi �s ens limitem a crear una taula de mida 0
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
