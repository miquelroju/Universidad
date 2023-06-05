package Sessio2;

import java.util.*;

public class Prova {

	public static void main(String[] args) {
		Ubicacio ubicacio1, ubicacio2;
		Ubicacio t[] = new Ubicacio[100];
		Poblacio x;
		Random rnd = new Random();
		x = new Poblacio(20, "Mataro", 20000);
		// char k=(char) (rnd.nextInt(26)+'A');

		for (int i = 0; i < 100; i++) {
			String k = "";
			for (int l = 0; l < 5; l++) {
				k += nomRandom();
			}
			t[i] = new Ubicacio(rnd.nextInt(50), k, rnd.nextInt(60));
		}
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i].getNomCarrer() + "-" + t[i].getNumCarrer());

		ubicacio1 = new Ubicacio(9, "Avinguda Sant Esteve", 29);
		ubicacio2 = new Ubicacio(4, "Camí Ral", 38);

		int l = 0;
		for (int i = 0; i < t.length; i++) {
			if (x.afegirUbicacio(t[i])) {
				System.out.println(t[i].getNomCarrer());
				System.out.println("Ha entrado");
				System.out.println("A" + x.getNumAH());
				System.out.println("I" + x.getNumIN());
				System.out.println("O" + x.getNumOZ());
				System.out.println("Total" + (x.getNumAH() + x.getNumIN() + x.getNumIN()));
				;
			} else {
				System.out.println("No ha entrado");
				System.out.println(t[i].getNomCarrer());
			}
		}
		SenyalTransit senyal1, senyal2, senyal3, senyal4;
		senyal1 = new SenyalTransit("3QX5-ROD", ubicacio1, 2020);
		senyal2 = new SenyalTransit("AB29-TRI", ubicacio2, 1999);
		senyal3 = new SenyalTransit("XXX1-REC", ubicacio1, 2000);
		senyal4 = new SenyalTransit("BC3A-QUA", null, 2022);

		System.out.print("Ubicacio 1: " + ubicacio1.getNomCarrer());
		System.out.println(ubicacio1.getNumCarrer());
		System.out.print("Senyals de la ubicacio 1: " + ubicacio1.getNumSenyals());
		System.out.print(ubicacio1.getSenyals());
		System.out.println("Senyal 1 de la ubicacio 1: " + ubicacio1.getSenyal(1).getCodi());

		System.out.print("Ubicacio 2: " + ubicacio2.getNomCarrer());
		System.out.println(ubicacio2.getNumCarrer());
		System.out.print("Senyals de la ubicacio 2: " + ubicacio2.getNumSenyals());
		System.out.print(ubicacio2.getSenyals());
		System.out.println("Senyal 0 de la ubicacio 2: " + ubicacio2.getSenyal(0).getCodi());

		System.out.print("Senyal 1: " + senyal1.getCodi());
		System.out.print(senyal1.getEstat());
		System.out.println(senyal1.getUbicacio());
		if (senyal1.canviarUbicacio(ubicacio2))
			System.out.println("s'ha canviat la ubicacio"); // CANVIARUBICACIO NO ESTA DONANT EL RESULTAT ESPERAT
		else
			System.out.println("No s'ha canviat");
		System.out.println("Nova ubicacio senyal 1: " + senyal1.getUbicacio() + " ");

		System.out.println(senyal4.getCodi());
		System.out.println(senyal4.getEstat());
		// System.out.println(senyal4.getUbicacio());
		if (senyal4.canviarUbicacio(ubicacio2)) {
			System.out.println(senyal4.getUbicacio());

		}
		System.out.println(ubicacio1.getSenyals());
		// System.out.println(senyal4.getUbicacio());

		System.out.println(x.quantes());
		System.out.println(x.quantes(ubicacio2.getNomCarrer().charAt(0)));
		System.out.println(x.quantes('a', 'z'));

		System.out.println();
		System.out.println(x.getMAX_Ubicacions());
		System.out.println(x.getNom());
		System.out.println("A-H" + x.getNumAH());
		// System.out.println("Habitants"+x.getNumH());
		System.out.println("I-N" + x.getNumIN());
		System.out.println("O-Z" + x.getNumOZ());

		x.imprimir();
		System.out.println("************");
		x.impirmirA();
		x.impirmirI();
		x.impirmirO();

	}

	private static char nomRandom() {
		Random rnd = new Random();
		char k = (char) (rnd.nextInt(26) + 'A');
		return k;
	}

}
