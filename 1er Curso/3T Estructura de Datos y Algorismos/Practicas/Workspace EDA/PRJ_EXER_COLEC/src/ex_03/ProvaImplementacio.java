package ex_03;

import p0_material.Criatura;

public class ProvaImplementacio {
    public static void main (String [] args) {
        Criatura [] poblacio = {
            new Criatura("NIL",0,Criatura.NEN),
            new Criatura("PERE",1, Criatura.NEN),
            new Criatura("NEUS",0, Criatura.NENA),
            new Criatura("ONA",1, Criatura.NENA),
            new Criatura("DÍDAC",0, Criatura.NEN),
            new Criatura("MARIONA",1, Criatura.NENA),
            new Criatura("EVA",3, Criatura.NENA),
            new Criatura("FIONA",2, Criatura.NENA),
            new Criatura("ENIA",3, Criatura.NENA)
        }; // dades per la prova. Evidentment se'n poden afegir més
        
        MainaderiaDosList mainaderia; // la mainaderia que es vol provar
        boolean matriculat;
        /* SI CALEN MÉS VARIABLES ES PODEN DECLARAR AQUÍ */
        
        mainaderia = new MainaderiaDosList(); // creacio
        
        //càrrega
        for (int i=0; i<poblacio.length; i++) {
            matriculat=mainaderia.matricular(poblacio[i].getNom(),
                                             poblacio[i].getEdat(),
                                             poblacio[i].getSexe()
                                            );
            if (!matriculat) {
                System.out.println("\nSembla que no hem pogut matricular a");
                System.out.println(poblacio[i]);
            }
        }
        
        /* CONTINUAR A PARTIR D'AQUEST PUNT */
               
    }

}
