package Ascensor;

public class Ex2Ascensor {
	
	public static void main(String[] args)	{
		
		Ascensor asc1, asc2, asc3;
		
		asc1 = new Ascensor (0, 19);
		asc2 = new Ascensor (-4, 4);
		asc3 = new Ascensor (-2, 10);
		
		asc1.anar(5);
		asc2.anar(asc1.getPis() - 10);
		asc3.anar(asc1.getPis() + asc2.getPis());
		
		while (asc1.getPis() > 0)	{
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
	
	private static void escriurePis (int pis)	{
		System.out.print("L'ascensor es troba a");
		if (pis > 0)	{
			System.out.print(" la planta ");
			System.out.println(pis);
		}
		else	{
			if (pis < 0) {
				System.out.print("l soterrani ");
				System.out.println(-pis);
			}
			else {
				System.out.println(" la planta baixa");
			}
		}
	}

}


// B.- Quin serà el resultat d'aquest programa?

// L'ascensor 1 va de la planta 0 a la 19, l'ascensor 2 va de la planta -4 a la 4, l'ascensor 3 va de la planta -2 a la 10.
// L'ascensor va al pis 5, l'ascensor 2 va al pis 5 - 10 = -5 però com que l'ascensor no pot anar tan avall es queda al -4 i l'ascensor 3 va al pis 5 + (-4) = 1.
// Mentre l'ascensor 1 sigui a un pis més alt que el 0, l'ascensor 1 baixarà, el 2 pujarà i el 3 baixarà, tots ells d'un en un.
// Per tant, quan l'ascensor 1 sigui al pis 0, l'ascensor 2 serà al pis 1 i l'ascensor 3 hauria de ser al -4 per tant serà al pis -2 perquè no té tants soterranis.
// I com a comprovació aquest és el resultat de la consola:


/* 	Primer ascensor:
	L'ascensor es troba a la planta baixa
	Segon ascensor:
	L'ascensor es troba a la planta 1
	Tercer ascensor:
	L'ascensor es troba al soterrani 2
*/