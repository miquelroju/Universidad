package Ascensor;

public class Ex1Ascensor {

	public static void main (String[] args) {
		
		Ascensor asc1, asc2;
		int vegades;
		int planta;
		
		asc1 = new Ascensor(0, 4);
		asc2 = new Ascensor(-2, 7);
		
		asc1.anar(2);
		asc2.anar(asc1.getPis() + 2);
		
		vegades = 0;
		while (vegades < 5)	{
			asc1.pujar();
			asc2.baixar();
			vegades = vegades + 1;
		}
		
		System.out.print("El primer ascensor �s al pis: ");
		planta = asc1.getPis();
		System.out.println(planta);
		
		System.out.print("El segon ascensor �s al pis: ");
		planta = asc2.getPis();
		System.out.println(planta);
	}
	
}

// A.- Quin ser� el resultat d'aquest programa?

// L'ascensor 1 va de la planta 0 a la 4 i l'ascensor 2 va de la -2 a la 7
// Seguidament l'ascensor 1 viatja fins la segona planta i l'ascensor 2 viatga a la planta 2 (la planta on era l'asc 1) + 2, �s a dir, a la planta 4
// L'ascensor 1 pujar� 5 vegades, per� no pot pujar tants pisos llavors arribar� al pis 5 que �s el m�xim i all� es quedar�
// i l'ascensor 2 baixar� 5 vegades, passar� de la planta 4 a la planta -1.
// Aix� es pot veure al resultat final:

/*
	El primer ascensor �s al pis: 4
	El segon ascensor �s al pis: -1
*/