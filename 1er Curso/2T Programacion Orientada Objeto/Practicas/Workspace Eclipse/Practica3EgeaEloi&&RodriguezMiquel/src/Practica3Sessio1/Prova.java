package Practica3Sessio1;

public class Prova {
	
	private static void prendreTotsElsMedicamentsComprats(Malalt m) {
		for (int i=0; i<m.getMedicaments(); i++) {
			MedicamentPindoles a = m.getMedicamentPindolesNoBuit();
			prendreDelMedicament(a);
		}
	}
	
	private static void prendreDelMedicament(MedicamentPindoles m) {
		for (int i = 0; i < m.quantesUnitatsQueden(); i++) {
			m.prendrePindola();
		}
	}
	
	public static void main(String [] args) {
		Malalt maria = new Malalt("Maria Fernandez", 10, 10);
		MedicamentPindoles enelapril60 = new MedicamentPindoles("ENELAPRIL", 60);
		MedicamentPindoles ibuprofeno20 = new MedicamentPindoles("IBUPROFENO", 20);
		
		maria.comprarMedicamentPindoles(enelapril60);
		maria.comprarMedicamentPindoles(enelapril60);
		maria.comprarMedicamentPindoles(ibuprofeno20);
		
		Malalt joan = new Malalt("Joan Moll", 15, 10);
		MedicamentPindoles auxina30 = new MedicamentPindoles("AUXINA", 30);
		MedicamentPindoles auxina35 = new MedicamentPindoles("AUXINA", 35);
		
		joan.comprarMedicamentPindoles(auxina30);
		joan.comprarMedicamentPindoles(auxina30);
		joan.comprarMedicamentPindoles(auxina35);
		joan.comprarMedicamentPindoles(auxina35);
		joan.comprarMedicamentPindoles(ibuprofeno20);
		joan.comprarMedicamentPindoles(ibuprofeno20);
		
		System.out.println("El malalt " + maria.getNom() + " té:");
		System.out.println("*******************************");
		System.out.println(maria.toString());
		
		System.out.println("Llistat per unitats");
		System.out.println("*******************");
		System.out.println(maria.numMedicamentsPerQueden());
		System.out.println();
		
		System.out.println("El malalt " + joan.getNom() + " té:");
		System.out.println("********************************");
		System.out.println(joan.toString());
		
		System.out.println("Llistat per unitats");
		System.out.println("*******************");
		System.out.println(joan.numMedicamentsPerQueden());
		System.out.println();
		
		System.out.println("Els malalts es prenen totes les píndoles!!!!!");
		System.out.println();
		
		prendreTotsElsMedicamentsComprats(maria);
		prendreTotsElsMedicamentsComprats(maria);
		
		System.out.println("La " + maria.getNom() + " es pren totes les píndoles que té");
		System.out.println("*****************************************************");
		System.out.println("El malalt " + maria.getNom() + " té:");
		System.out.println(maria.toString());
		System.out.println("Llistat per unitats");
		System.out.println("*******************");
		System.out.println(maria.numMedicamentsPerQueden());
		System.out.println();
		
		System.out.println("La " + joan.getNom() + " es pren totes les píndoles que té");
		System.out.println("*****************************************************");
		System.out.println("El malalt " + joan.getNom() + " té:");
		System.out.println(joan.toString());
		System.out.println("Llistat per unitats");
		System.out.println("*******************");
		System.out.println(joan.numMedicamentsPerQueden());
		

	}

}