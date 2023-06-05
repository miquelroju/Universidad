package exercici_04_AireCondicionat;

public class ExperimentAparellsAire_tres {

    public static void main(String[] args) {

        AparellAire ap1 = null, ap2 = null;

        System.out.println("\nTERCER EXPERIMENT\n");

        // creació d'un aparell no viable
        ap2 = new AparellAire("FugiuTots", 0, 32);
        System.out.println("OK. Aparell amb límits " + 0 + ", " +
                32 + " fabricat");
        System.out.println("L'aparell es: " + ap1);

        System.out.println();

        // creació d'un aparell viable
        ap1 = new AparellAire("FugiuTots", 20, 32);
        System.out.println("OK. Aparell amb límits " + 20 + ", " +
                32 + " fabricat");
        System.out.println("L'aparell es: " + ap1);

        System.out.println();

        // El posem en marxa
        ap1.pulsarIterruptor();
        System.out.print("Interruptor polsat.");
        if (ap1.isOn()) System.out.println(" Aparell en marxa...");
        else System.out.println(" Aparell apagat (????? ERROR ???)");
        

        // Recurperem el valor memoritzat
        ap1.recuperarMemoria();
        System.out.println("memòria recuperada!");

        System.out.println();

        // fem un nou experiment de pujar la temperatura...
        for (int i = 1; i <= 10; i++) {
            ap1.pujar();
            System.out.println("  --> (" + i + ") temperatura pujada fins a " 
                                + ap1.getTempActual() + "º" +
                                " sense problemes");
        }
        
        System.out.println("\nFINAL DEL TERCER EXPERIMENT\n");
    }
}
