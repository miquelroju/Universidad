package Practica2Sessio3;

import java.util.Random;

public class Prova {

	public static void main(String[] args) {
		Ubicacio ubi;
		SenyalTransit[] senyals = new SenyalTransit[20];

		String Carrer = "", senyal = "";
		int msenyals, num, any, tipus;

		for (int i = 0; i < senyals.length; i++) {
			Random random = new Random();

			msenyals = random.nextInt();
			num = random.nextInt();
			any = random.nextInt();
			tipus = random.nextInt();
			Carrer = Carrer + (char) (random.nextInt(26) + 'a');
			senyal = senyal + (char) (random.nextInt(26) + 'a');

			ubi = new Ubicacio(msenyals, Carrer, num);
			senyals[i] = new SenyalTransit(senyal, tipus, ubi, any);

		}

	}

}
