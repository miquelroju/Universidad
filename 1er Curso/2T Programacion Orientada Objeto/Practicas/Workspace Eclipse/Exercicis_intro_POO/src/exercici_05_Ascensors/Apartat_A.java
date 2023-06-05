package exercici_05_Ascensors;

public class Apartat_A {
    
    public static void main(String [] args) {
        
        Ascensor asc1, asc2;
        int vegades;
        int planta;
        
        asc1 = new Ascensor(0, 4);
        asc2 = new Ascensor(-2, 7);
        
        asc1.anar(2);
        asc2.anar(asc1.getPis()+2);
        
        vegades = 0;
        while (vegades<5) {
            asc1.pujar();
            asc2.baixar();
            vegades=vegades+1;
        }
        
        System.out.print("El primer ascensor es al pis: ");
        planta=asc1.getPis();
        System.out.println(planta);
        
        System.out.print("El segon ascensor es al pis: ");
        planta=asc2.getPis();
        System.out.println(planta);
        
    }
}
