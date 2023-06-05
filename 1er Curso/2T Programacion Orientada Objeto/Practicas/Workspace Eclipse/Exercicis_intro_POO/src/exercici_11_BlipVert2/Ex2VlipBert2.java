package exercici_11_BlipVert2;

public class Ex2VlipBert2 {
	public static void main (String [] args) {
        BlipVert2 cho, hermione, padme, ginny;
        
        cho = new BlipVert2(10,20);
        hermione = new BlipVert2(10, 25);
        padme = new BlipVert2(23,15);
        centrifuga(hermione, cho, 5);
        centrifuga(cho, padme, 5);
        /* PUNT 1*/
        System.out.println("cho.alfa = "+ cho.getAlfa());
        System.out.println("cho.beta = "+ cho.getBeta());
        System.out.println("cho.gamma = "+ cho.getGamma());
        System.out.println();
        ginny = selecciona(hermione, cho);
        /* PUNT 2*/
        System.out.println("ginny.alfa = "+ ginny.getAlfa());
        System.out.println("ginny.beta = "+ ginny.getBeta());
        System.out.println("ginny.gamma = "+ ginny.getGamma());
        System.out.println();
        ginny = selecciona(ginny, padme); 
        /* PUNT 3 */
        System.out.println("ginny.alfa = "+ ginny.getAlfa());
        System.out.println("ginny.beta = "+ ginny.getBeta());
        System.out.println("ginny.gamma = "+ ginny.getGamma());
    }
    
    private static BlipVert2 selecciona (BlipVert2 a, BlipVert2 b) {
        a.reGamma();
        b.reGamma();
        if (a.getGamma()) {
            return(a);
        }
        else {
            return(b);
        }
    }
    
    private static void centrifuga (BlipVert2 b1, BlipVert2 b2, int a) {
        b1.blip(a);
        b2.vert(a);
    }

}
