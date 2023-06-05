package Practica2Sessio1;
import Keyboard.*;
public class Prova {

	public static void main(String[] args) {

		Ubicacio u1, u2, u3;
		SenyalTransit t;
		String Carrer,senyal;
		int msenyals,num,any,tipus;

		System.out.println("numero de senyals");
		msenyals=Keyboard.readInt();
		System.out.println("nom carrer");
		Carrer=Keyboard.readString();
		System.out.println("numero de senyal");
		num=Keyboard.readInt();
		System.out.println("codi senyal");
		senyal=Keyboard.readString();
		System.out.println("tipus de senyal");
		tipus=Keyboard.readInt();
		System.out.println("any de colocacio");
		any=Keyboard.readInt();
		
		
		u1 = new Ubicacio(msenyals, Carrer, num);
		t = new SenyalTransit(senyal, tipus, u1, any);
		u1.afegirSenyal(t);
		for (int i = 0; i < u1.getMaxSenyals(); i++) {
			System.out.print("El carrer " + u1.getVia() + " amb numero " + u1.getNum());
			if (u1.getCruilla()) {
				System.out.print(" que te cruilla, ");
			} else
				System.out.print(" que no te cruilla, ");
			System.out.print("amb un nombre de " + u1.getNumSenyals() + " senyals i un maxim de " + u1.getMaxSenyals());
			System.out.print(" Hi ha un senyal " + u1.getSenyals());
			System.out.println();
		}
	}

}
