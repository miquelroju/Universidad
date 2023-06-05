package exercici_04_AireCondicionat;

public class ExperimentAparellsAire_un {

    public static void main (String args []) {
        
        AparellAire ap = null;
        
        System.out.println("\nINICI DE L'EXPERIMENT\n");
        
        // Provem de fabricar un aparell amb límit superior incorrecte. 
        // Esperem que l'error es detecti i que es llenci una excepció.
        try {
            ap = new AparellAire("ElGiCul", 20, AparellAire.LIMIT_SUPERIOR+1);
            System.out.println("ERROR. Aparell amb límits "+20+", "+
                               (AparellAire.LIMIT_SUPERIOR+1)+" fabricat!");
            System.exit(0);
        }
        catch(/* COMPLETAR */) {
            /* COMPLETAR */
        }
        System.out.println();
        
        // fabriquem un aparell amb límits correctes.
        // Esperem que no passi res i que no es llanci cap excepció
        try {
            ap = new AparellAire("ElGiCul", 20, 26);
            System.out.println("OK. Aparell amb límits "+20+", "+
                               26+" fabricat");
        }
        catch(/* COMPLETAR */) {
            /* COMPLETAR */
        }
        System.out.println();
        
        // Provem de recuperar la memòria d'un aparell que està OFF 
        // perquè s'acaba de crear. Esperem que l'error es detecti i que
        // es llanci una excepció
        try {
            ap.recuperarMemoria();
            System.out.println("ERROR. Memòria recuperada d'un aparell apagat!");
        }
        catch(/* COMPLETAR */) {
            /* COMPLETAR */
        }
        System.out.println();
        
        // ara ho farem bé. Primer posarem l'aparell en marxa i
        // després recuperem la memòria. No s'hauria de produir cap error
        ap.pulsarIterruptor();
        System.out.println("Aparell funcionant...");
        try {
           /* COMPLETAR */
        }
        catch(/* COMPLETAR */) {
            /* COMPLETAR */
        }
        System.out.println();
        
        // Portar l'aparell al seu límit inferior. Atès que l'aparell està ON
        // i que no baixarem per sota del límit inferior, no esperem
        // que es llenci cap mena d'excepció
        try {
            while (ap.getTempActual()>ap.getTempMin()){
                ap.baixar();
            }
            System.out.println("OK. Assolida la temperatura mínima");
        }
        catch(/* COMPLETAR */) {
            /* COMPLETAR */
        }
        System.out.println();
        
        // provar de portar l'aparell encara per sota de la temperatura mínima
        // en aquest cas si que esperem que es llanci una excepció
        try {
            ap.baixar();
            System.out.println("ERROR la temperatura ha baixat per sota del mínim");
        }
        catch(/* COMPLETAR */) {
            /* COMPLETAR */
        }
        
        System.out.println("\nFINAL DE L'EXPERIMENT\n");
        
    }
           
}
