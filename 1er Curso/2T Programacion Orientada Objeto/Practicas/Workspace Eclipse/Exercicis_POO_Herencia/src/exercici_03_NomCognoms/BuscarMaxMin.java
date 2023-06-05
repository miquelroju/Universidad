package exercici_03_NomCognoms;

package exerciciNomsCognoms;

import java.util.Random;

public class BuscarMaxMin {

    public static void main (String [] args) {
        
        NomCognoms max, min;
        
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
        
        min = /* COMPLETAR */ // busquem el mínim
        max = /* COMPLETAR */ // busquem el màxim
        
        System.out.println("\nEl nom i cognom 'més petit' és:");
        System.out.println("\t"+min);
        System.out.println("\nEl nom i cognom 'més gran' és:");
        System.out.println("\t"+max);
        System.out.println();
        
    }
    
    private static Comparable buscarMin (Comparable t[]) {
       /* COMPLETAR */
    }
    
    private static Comparable buscarMax (Comparable t[]) {
        /* COMPLETAR */
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
