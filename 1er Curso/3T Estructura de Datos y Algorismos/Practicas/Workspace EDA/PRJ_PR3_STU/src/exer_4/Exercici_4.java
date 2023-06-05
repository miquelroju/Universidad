package exer_4;

import java.util.*;

public class Exercici_4 {
	
	private static char [] alfabet = {'a', 'b', 'c', 'd', 'e', 'f'};
	private static Random alea = new Random();
	
	public static void main (String [] args) {
		
		String mot, ite, rec;
		
		System.out.println();
		for (int i=1; i<10000; i++) {
			mot = genCadena(alea.nextInt(21));
			ite = torturaIte(mot);
			rec = tortura(mot);
			if (!ite.equals(rec)) {
				System.out.println("Discrepància detectada");
				System.out.println("per al mot: "+mot);
				System.out.println("la versió recursiva ha generat: "+rec);
				System.out.println("la versió iterativa ha generat: "+ite);
				System.out.println("CAL REVISAR EL CODI GENERAT");
				System.exit(1);
			}
		}
		
		System.out.println("Prova finalitza sense haver detectat discrepàncies");
		System.out.println("entre les versions iterativa i recursiva.");
		System.out.println("Però això no vol dir ...");
		
	}
	
	// Funció façana (llançadora) 
	public static String tortura (String s) {
		// escriure aquí la invocació inicial del funció recursiva de "tortura"
	}
	
	// escriure aquí la funció RECURSIVA de tortura
	
	public static String torturaIte (String s) {
		// escriure aquí el cos de la versió iterativa de la funció de "tortura"
	}
	
	public static String genCadena (int n) {
		// escriure aquí el cos de la funció RECURSIVA que genera 
		// cadenes de caràcters de mida n
	}
	
	

}
