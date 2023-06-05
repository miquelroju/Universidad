package Sessio1;

public class Prova {

	public static void main(String[] args) {

		Ubicacio ubicacio1, ubicacio2;
		ubicacio1 = new Ubicacio(9, "Avinguda Sant Esteve", 29);
		ubicacio2 = new Ubicacio(4, "Camí Ral", 38);

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
		//System.out.println(senyal4.getUbicacio());
		if(senyal4.canviarUbicacio(ubicacio2)) {
			System.out.println(senyal4.getUbicacio());
		}
		System.out.println(senyal4.getUbicacio());
		
	}

}
