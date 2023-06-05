package exer_3;

import java.util.Random;

public class Exercici_3 {
	
	
	public static void main (String [] args) {
		/* Escriviu aqu� el vostre codi de prova. Genereu parelles de
		 * vectors i utilitzeu la vostra funci� per dterminar si l'un 
		 * �s la versi� girada de l'altre o no. Vegeu l'enunciat 
		 * de la pr�ctica */
		for (int i = 0; i < 10; i++) {
			VectorPair parellGirat = new VectorPair(true);
			if(verificar(parellGirat.one, parellGirat.two)) {
				System.out.println("El parell girat [" + parellGirat.one + "," + parellGirat.two + "] és erroni");
			}
			if(!verificar(parellGirat.one, parellGirat.two)) {
				System.out.println("Parell Girat correcte");
			}
		}
		for (int i = 0; i < 10; i++) {
			VectorPair parellNoGirat = new VectorPair(false);
			if(!verificar(parellNoGirat.one, parellNoGirat.two)) {
				System.out.println("El parell no girat " + parellNoGirat.one + "," + parellNoGirat.two + " és erroni");
			}
			if(verificar(parellNoGirat.one, parellNoGirat.two)) {
				System.out.println("Parell No Girat correcte");
			}
		}
		
	}
	
	/* ESCRIVIU AQU� LA VOSTRA FUNCI� DE VERIFICACI� */
	
	private static boolean verificar (int[] a, int[] b) {
		boolean bool = false;
		while (bool = false) {
			for (int i = 0; i < a.length; i++) {
				if(a[i] != b[b.length-i]) bool = true;
				// Si no són iguals, retorna true
			}
		}		
		return bool;
	}
	
}


/* Classe d'utilitat per a generar parelles de vectors que poden sser
 * l'un la versi� girada de l'altre o no, en funci� del par�metre del
 * constructor  */
class VectorPair {
	
	private static Random alea = new Random();
	
	public  int [] one;
	public int [] two;
	
	public VectorPair(boolean correctlyReversed) {
		this.one = this.randomIntVector(correctlyReversed ? alea.nextInt(10) : alea.nextInt(10)+1);
		this.two = this.reversed(this.one);
		if (!correctlyReversed) {
			this.two[alea.nextInt(this.two.length)]++;
		}
	}
	
	private static int[] reversed (int [] v) {
		int [] result = new int[v.length];
		for (int i=0; i<v.length; i++) {
			result[v.length-1-i]=v[i];
		}
		return result;
	}
	
	private static int[] randomIntVector (int length) {
		int [] result = new int[length];
		for (int i=0; i<length; i++) {
			result[i] = alea.nextInt(10);
		}
		return result;
	}
}
