package Ascensor;
import Keyboard.*;

public class Ex4Ascensor {
	
	public static void main (String[] args) {
		
		Ascensor asc1, asc2;
		int max, min;
		
		max = 9999;
		min = -9999;
		
		do {
			
			System.out.println("Quin és el pis més baix al que arribarà aquest ascensor?: ");
			min = Keyboard.readInt();
			
			System.out.println("Quin és el pis més alt al que arribarà aquest ascensor?: ");
			max = Keyboard.readInt();
			
			if(max <= min) {
				System.out.println("El pis més baix introduït és superior o igual al pis més alt introduït");
				System.out.println("");
			}

	
		} while (max < min);
		
		asc1 = new Ascensor (min, max);
		
		asc1.anar((max + min) / 2);
		
		asc2 = new Ascensor (asc1.getPis(), max + 1);
		
		while(asc2.getPis() != asc2.getMax()) {
			asc2.pujar();
		}
		
		System.out.println("El límit superior del primer ascensor és " + max + " i l'inferior és " + min);
		
		System.out.print("L'ascensor es troba a");
		if (asc1.getPis() > 0) {
			System.out.print(" la planta " + asc1.getPis());
		} else {
			if (asc1.getPis() == 0) {
				System.out.print("la planta baixa");
			} else {
				System.out.print("al soterrani " + asc1.getPis());
			}
		}
		
		System.out.println("");
		System.out.println("El límit superior del segon ascensor és " + asc2.getMax() + " i l'inferior és " + asc2.getMin());
		
	}

}
