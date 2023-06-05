package exercici_06_Estudiant;

public class ShuffleEstudiant {

	public static void main(String[] args) {
	
		Estudiant e1, e2, e3, e4;
	
		e1 = new Estudiant("ALBA", 22);
		e2 = new Estudiant("BARTOMEU", 21);
	
		e3 = e1;
		e4 = e2;
	
		e1.setEdat(e4.getEdat() - 1);
	
		e2 = new Estudiant("CONRAD", 19);
		e1 = new Estudiant("DIANA", 24);
	
		e2.setEdat(e3.getEdat() + 1);
	
		e4 = e1;
		e1 = e2;
	
		e3.setEdat(e4.getEdat() + 2);
	
		// veure quin és l'objecte referenciat per cada variable
		System.out.println();
		escriureDades(e1, "e1");
		escriureDades(e2, "e2");
		escriureDades(e3, "e3");
		escriureDades(e4, "e4");
		System.out.println();
	}
	
	private static void escriureDades(Estudiant e, String nomRef) {
		System.out.print("Objecte referenciat per " + nomRef + " => ");
		System.out.print("nom: " + e.getNom());
		System.out.println(" edat: " + e.getEdat());
	}

}
