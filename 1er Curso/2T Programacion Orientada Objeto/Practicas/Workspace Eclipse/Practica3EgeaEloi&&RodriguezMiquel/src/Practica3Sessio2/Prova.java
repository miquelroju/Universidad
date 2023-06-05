package Practica3Sessio2;
import java.util.Random.*;

public class Prova {
	
	private static void prendreTotsElsMedicamentsComprats(Malalt m) throws ExceptionMedicament {
		for (int i=0; i<m.getMedicaments(); i++) {
			MedicamentPindoles a = m.getMedicamentPindolesNoBuit();
			prendreDelMedicament(a);
		}
	}
	
	private static void prendreDelMedicament(MedicamentPindoles m) throws ExceptionMedicament {
		for (int i = 0; i < m.quantesUnitatsQueden(); i++) {
			m.prendrePindola();
		}
	}
	
	private static String malaltAleatori (int i) {
        final String[] malalts;
        final String malalt1 = "Maria Fernandez";
        final String malalt2 = "Joan Moll";
        final String malalt3 = "David Jimenez";
        final String malalt4 = "Guillem Mateo";
        final String malalt5 = "Francesc Serrano";
        final String malalt6 = "Martin Pedro";
        final String malalt7 = "Perico de los Palotes";
        final String malalt8 = "Aleix Zamora";

        malalts = new String[8];

    }
	
	public static void main(String [] args) throws ExceptionMedicament {
		Malalt error1 = new Malalt("Maria Fernandez", -5, 10);
		Malalt joan = new Malalt("Joan Moll", 15, 10);
		Malalt pepito = new Malalt("xxxxxx", 10, 10);
		
		MedicamentPindoles ibuprofeno20 = new MedicamentPindoles("IBUPROFENO", 20);
		
		error1.comprarMedicamentPindoles(ibuprofeno20);
		
		MedicamentPindoles medicamentBuit = new MedicamentPindoles("AUXINA", 0);
		MedicamentPindoles medicamentError = new MedicamentPindoles("ERROR", -4);
		
		prendreTotsElsMedicamentsComprats(error1);
		
		joan.comprarMedicamentPindoles(medicamentError);
		
		pepito.comprarMedicamentPindoles(medicamentBuit);
		prendreTotsElsMedicamentsComprats(pepito);
	}
	
	public static void main1(String [] args) {
		
	}

}