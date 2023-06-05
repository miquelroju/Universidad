package exercici_04_AireCondicionat;

public class ExperimentAparellsAire_dos {

    public static void main(String[] args) {

        AparellAire ap1 = null;

        System.out.println("\nSEGON EXPERIMENT\n");


        // creaci� d'un aparell viable
        ap1 = new AparellAire("Fragor", 18, 30);
        System.out.println("OK. Aparell amb l�mits " + 18 + ", " +
                30 + " fabricat");
        System.out.println("L'aparell es: " + ap1);

        System.out.println();


        // recuperem el valor memoritzat de f�brica
        ap1.recuperarMemoria();
        System.out.println("ERROR.Mem�ria d'aparell apagat recuperada!");

        System.out.println();

        // primer hem de posar l'aparell en marxa...
        ap1.pulsarIterruptor();
        System.out.print("Interruptor polsat.");
        if (ap1.isOn()) System.out.println(" Aparell en marxa...");
        else System.out.println(" Aparell apagat (????? ERROR ???)");

        // Ara s� que hauriem de poder recuperar el valor memoritzat
        ap1.recuperarMemoria();
        System.out.println("mem�ria recuperada!");

        System.out.println();

        //pujem la temperatura, a veure fins on podem arribar...
        for (int i = 1; i < 100; i++) {
            ap1.pujar();
            System.out.println("  --> temperatura pujada fins a " 
                               + ap1.getTempActual() + "�" +
                               " sense problemes");
        }

        System.out.println("\nFINAL DEL SEGON EXPERIMENT\n");
    }
}
