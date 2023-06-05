package Ascensor;

public class Ex3Ascensor {
	
	public static void main(String[] args) {
		
		Ascensor asc1;
		int i = 0;
		
		asc1 = new Ascensor (-10, 30);
		
		asc1.anar(28);
		
		while(i < 15) {
			asc1.baixar();
			i++;
		}
		
		System.out.print("L'ascensor es troba a");
		if (asc1.getPis() > 0) {
			System.out.print(" la planta " + asc1.getPis());
		} else {
			if (asc1.getPis() == 0) {
				System.out.print("la planta baixa");
			} else {
				System.out.print("l soterrani " + asc1.getPis());
			}
		}
		
	}
	
}
