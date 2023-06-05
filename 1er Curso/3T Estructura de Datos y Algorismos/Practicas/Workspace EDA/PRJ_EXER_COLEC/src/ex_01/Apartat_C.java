package ex_01;

import p0_material.Criatura;
import java.util.*;

public class Apartat_C {

public static void main (String [] args) {
        
        Criatura [] poblacio = {
        		 new Criatura("NIL",0,Criatura.NEN),
                 new Criatura("EVA",1, Criatura.NENA),
                 new Criatura("CARLES",0, Criatura.NEN),
                 new Criatura("ONA",1, Criatura.NENA),
                 new Criatura("D�DAC",0, Criatura.NEN),
                 new Criatura("NIL",1, Criatura.NEN),
                 new Criatura("EVA",3, Criatura.NENA),
                 new Criatura("JORDI",2, Criatura.NEN),
                 new Criatura("ENIA",3, Criatura.NENA)
        };
        
        
        Collection llarInfants;
        llarInfants = new LinkedList();
        
        // afegim totes les criatures, despr�s de "barrejar" una mica
        shuffle(poblacio);
        for (int i=0; i<poblacio.length; i++) {
            llarInfants.add(poblacio[i]);
        }
        
        /* APARTAT C: eliminar tots els nens -les nenes no- de la 
           Col�lecci� llarInfants. Feu-ho obtenint l'iterador
           de la col�lecci� i fent amb ell tota la feina. Si us cal,
           documenteu-vos sobre el m�tode iterator (de Collection) i sobre el
           darrer m�tode de la interf�cie Iterator. */
        
        /* ... Poseu aqu� la vostra soluci� */
        
        
        
        // I finalment veiem qu� hi ha...
        System.out.println();
        System.out.println("contingut de la llista despr�s de treure els nens");
        System.out.println("-------------------------------------------------");
        Object [] contingut = llarInfants.toArray();
        for (int i=0; i<contingut.length;i++) {
            System.out.println(contingut[i]);
        }    
        System.out.println();
        
    }
    
    private static void shuffle (Object [] t) {
        Random alea = new Random();
        int i,j;
        Object inter;
        for (int cont=1; cont<=t.length/2+1; cont++) {
            i = alea.nextInt(t.length);
            j = alea.nextInt(t.length);
            inter = t[i];
            t[i] = t[j];
            t[j] = inter;
        }
    }
    
}
