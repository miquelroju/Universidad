package Sessio2;

import java.util.Random;

public class GenerarParametresSenyal {

	public static String generarCodi() {
		String codi = "";
		for (int i = 0; i < 4; i++) {
			codi += generarDigit();
		}
		return codi += "-" + generarForma();

	}
	public static int generarAny(int maxim) {
		Random rnd=new Random();
		return rnd.nextInt(maxim-1981)+1980;
	}

	private static char generarDigit() {
		Random rnd = new Random();
		return (char) (rnd.nextInt(10) + 48); 
	}

	private static String generarForma() {
		String[] tipus = { "ROD", "TRI", "REC", "QUA" };
		Random rnd = new Random();
		return tipus[rnd.nextInt(4)];
	}
}
