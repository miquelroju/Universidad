package exercici_03_NomCognoms;

/* Aquesta classe ja està completa. No cal fer res
 * Només s'ha d'utilitzar per a verificar el possible
 * mal funcionament de la implementació del mètode
 * compareTo de NomCognoms */

import java.util.Arrays;
import java.util.Random;

public class OrdenarNomsCognoms {

    public static void main (String [] args) {
        
        NomCognoms gent[] = {
          new NomCognoms("Albert", "Adell", "Arnau"),
          new NomCognoms("Ariadna", "ADELL", "ARNAU"),
          new NomCognoms("Bartomeu", "Puig", "Pelat"),
          new NomCognoms("Bartomeu", "PUIG", "Melero"),
          new NomCognoms("Zenó", "Zumarraga", "Zunzunegui"),
          new NomCognoms("Bartomeu", "Perea", "Pelat"),
          new NomCognoms("Joan", "Smith", "Casabella"),
          new NomCognoms("Mary", "SMITH"),
          new NomCognoms("John", "FITCH"),
          new NomCognoms("Andrew", "Fitch"), 
        };
        
        shuffle(gent); // "barrejem" la taula
        Arrays.sort(gent); // ordenem la taula
        
        System.out.println();
        System.out.println("Llista de noms i cognoms ordenada alfabèticament");
        System.out.println("------ -- ---- - ------- -------- --------------");
        for (int i=0; i<gent.length; i++) {
            System.out.println(i+": "+gent[i]);
        }
        System.out.println();
        
    }
    
    private static void shuffle (Object t[]) {
        Random r = new Random();
        Object pivot;
        int a, b;
        for (int i=0; i<=t.length/2; i++) {
            a = r.nextInt(t.length);
            b = r.nextInt(t.length);
            if (a!=b) {
                pivot = t[a];
                t[a] = t[b];
                t[b] = pivot;
            }
        }
    }
    
}
