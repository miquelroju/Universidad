package exer_2;

import java.util.*;


public class Exercici_2 {
	
	// atributs est�tics utilitzats en la generaci� aleat�ria de car�cters
	private static char [] theChars = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}; // els car�cters que poden ser generats
	
	private static Random alea = new Random();
	
	public static void main (String [] args) {
		/* Escriviu aqu� el vostre codi de prova. Genereu 10000 pal�ndroms de mides 
		 * aleat�ries en l'interval [0,20] i verifiqueu-los amb la funci� 
		 * checkPalindrome subministrada. Vegeu enunciat de la pr�ctica
		 */
		for (int i = 0; i < 1000; i++) {
			int random = getRandomNumber(0,20);
			String s = genPalindrome(random);
			System.out.println(s);
			if(!checkPalindrome(s)) {
				System.out.println("Error" + s);
			}
		}
	}
	
	private static String genPalindrome (int length) {
		/* COMPLETAR */
		if (length==0) return "";
		if (length==1) return "" + randomChar();
		
		String currentChar = "" + randomChar();
		return currentChar + genPalindrome(length-2)+currentChar;
	}
	
	
	/* Randomly "generates" a char */
	private static char randomChar() {
		return theChars[alea.nextInt(theChars.length)];
	}
	

	/* Verifies whether the given string is a palindrome or not.
	 * Returns true if the parameter is a palindrome and false otherwise */
	private static boolean checkPalindrome (String s) {
		String ns = "";
		for (int i=1; i<=s.length(); i++) 
			ns = ns + s.charAt(s.length()-i);
		return s.equals(ns);
	}
	
	private static int getRandomNumber(int a, int b) {
		Random rand = new Random();
		int num;
		num = rand.nextInt(a, b);
		return num;
	}
	

}
