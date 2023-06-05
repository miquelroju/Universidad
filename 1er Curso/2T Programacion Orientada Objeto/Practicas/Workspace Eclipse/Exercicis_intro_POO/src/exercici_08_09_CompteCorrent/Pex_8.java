package exercici_08_09_CompteCorrent;

public class Pex_8 {
	
	private static boolean igualar (CompteCorrent compte1, CompteCorrent compte2) {
    	boolean fet = false;
    	
    	double a = compte1.getSaldo();
    	double b = compte2.getSaldo();
    	double c = (a+b)/2.0;
    	
    	if (a != b)
    	{
    		if (a > b)
        	{
        		boolean ok = compte1.retirar(a-c);
        		if (ok) {
        			compte2.ingressar(a-c);
        			fet = true;
        		}
        	} else {
        		
        		boolean ok = compte2.retirar(b-c);
        		if (ok) {
        			compte1.ingressar(b-c);
            		fet = true;
        		}
        	}
    	}
    	return fet;
    }
	
    private static boolean diferent (CompteCorrent compte1, CompteCorrent compte2, CompteCorrent compte3) {
    	boolean ok = false;
    	double a = compte1.getSaldo();
    	double b = compte2.getSaldo();
    	double c = compte3.getSaldo();
    	if (a == b && b == c) {
    		ok = true;
    	}
    	return ok;
    }
	
	public static void main(String[] args) {
		
		CompteCorrent c1, c2, c3;
		boolean ok;
		
		c1 = new CompteCorrent("Francesc", 1000);
		c2 = new CompteCorrent("Angels", 1001);
		c3 = new CompteCorrent("Miquel", 1002);
		
		c1.ingressar(1000);
		c2.ingressar(500);
		c3.ingressar(250);
		
		ok = igualar(c1, c2);
		if (ok) {
			System.out.println("S'ha igualat el saldo del primer i el segon compte");
		} else {
			System.out.println("No s'ha pogut igualar els saldos del primer i segon compte");
		}
		
		ok = igualar(c2, c3);
		if (ok) {
			System.out.println("S'ha igualat el saldo del segon i el tercer compte");
		} else {
			System.out.println("No s'ha pogut igualar els saldos del segon i tercer compte");
		}
		
		ok = diferent(c1,c2,c3);
		if (ok) {
			System.out.println("Tots tres saldos són iguals");
		} else {
			System.out.println("Els saldos són diferents");
		}	
		
		
	}

}