package Practica2Sessio3;
import java.util.Random;

public class GenerarParametresSenyal{
	
	Random random;
	
	public static String generarCodi() {
		 String codi = "";
		 String forma = GenerarParametresSenyal.generarForma();
		 int digit = GenerarParametresSenyal.generarDigit();
		 // codi = forma + digit;
		 codi = forma + "-" + digit;
		 return codi;
	}
	
	public static int generarAny(int maxim) {
		Random random = new Random();
		int minim = 1980;
		int randomAny = random.nextInt((maxim - minim)+1)+minim;
		return randomAny;
	}
	
	public static char generarDigit() {
		int maxim = 57;
		int minim = 48;
		Random random = new Random();
		char randomDigit = (char)(random.nextInt((maxim-minim)+1)+minim);
		return randomDigit;
		// Codi que genera un char random entre a-z
		// Random r = new Random();
		// char c = (char)(r.nextInt(26) + 'a');
	}
	
	public static String generarForma() {
		Random rnd = new Random();
		int random = rnd.nextInt(3);
		String forma = "";
		switch (random) {
			case 0: forma = "ROD";
			case 1: forma = "TRI";
			case 2: forma = "REC";
			case 3: forma = "QUA";
		}
		return forma;
	}
}