package ex_01;

import p0_material.Criatura;
import java.util.*;

public class Apartat_B {

public static void main (String [] args) {
        
        Criatura [] poblacio = {
        		 new Criatura("NIL",0,Criatura.NEN),
                 new Criatura("EVA",1, Criatura.NENA),
                 new Criatura("CARLES",0, Criatura.NEN),
                 new Criatura("ONA",1, Criatura.NENA),
                 new Criatura("DÍDAC",0, Criatura.NEN),
                 new Criatura("NIL",1, Criatura.NEN),
                 new Criatura("EVA",3, Criatura.NENA),
                 new Criatura("JORDI",2, Criatura.NEN),
                 new Criatura("ENIA",3, Criatura.NENA)
        };
        
        
        List elsNens, lesNenes;
        elsNens = new LinkedList();
        lesNenes = new ArrayList();
        
      
         /* APARTAT B: poseu tots els nens de la taula població a la llista
          	elsNens i totes les nenes a la llista lesNenes.
          	Després calculeu l'edat mitjana dels nens i l'edat mitjana de les 
          	nenes, iterant sobre les llistes emplenades en el pas anterior. 
          	Per tal d'iterar sobre les llistes, utilitzeu els seus mètodes get */
  
        
        
        double nens = 0; // per calcular la mitjana d'edat dels nens
        double nenes = 0; // per calcula la mitjana d'edat de les nenes
        Criatura c;
        
        /* ... poseu la vostra solució a partir d'aquí */
        
        
        // donar el resultat
        System.out.println();
        System.out.println("L'edat mitjana dels nens és: "+nens);
        System.out.println("L'edat mitjana de les nenes és: "+nenes);
        System.out.println();
    
}
