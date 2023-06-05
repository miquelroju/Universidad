package exercici_05_Ascensors;

public class Apartat_E {
    
    public static void main(String [] args) {
        
        Ascensor a1, a2;
        
        a1 = new Ascensor(0,10);
        a2 = a1;
        
        a1.anar(6);
        a2.baixar();
        
        a1 = new Ascensor(-1, a1.getMax()/2);
        
        a1.anar(a2.getPis());
        a1.pujar();
        a2.baixar();
        
        System.out.print("L'ascensor 1 es al pis: ");
        System.out.println(a1.getPis());
        
        System.out.print("L'ascensor 2 es al pis: ");
        System.out.println(a2.getPis());
        
    }
}
