package exercici_05_Ascensors;

public class Apartat_B {
    
    public static void main(String [] args) {
        
        Ascensor asc1, asc2, asc3;
        
        asc1 = new Ascensor(0, 19);
        asc2 = new Ascensor(-4, 4);
        asc3 = new Ascensor(-2, 10);
        
        asc1.anar(5);
        asc2.anar(asc1.getPis()-10);
        asc3.anar(asc1.getPis()+asc2.getPis());
        
        while(asc1.getPis()>0) {
            asc1.baixar();
            asc2.pujar();
            asc3.baixar();
        }
        
        System.out.println("Primer ascensor:");
        escriurePis(asc1.getPis());
        System.out.println("Segon ascensor:");
        escriurePis(asc2.getPis());
        System.out.println("Tercer ascensor:");
        escriurePis(asc3.getPis());
    }
    
    private static void escriurePis(int pis) {
        System.out.print("L'ascensor es troba a");
        if (pis>0) {
            System.out.print(" la planta ");
            System.out.println(pis);
        } else {
            if (pis<0) {
                System.out.print("l soterrani ");
                System.out.println(-pis);
            } else {
                System.out.println(" la planta baixa");
            }
        }
    }
    
}
