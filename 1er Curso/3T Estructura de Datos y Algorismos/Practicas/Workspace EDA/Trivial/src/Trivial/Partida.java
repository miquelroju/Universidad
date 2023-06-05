package Trivial;
import Keyboard.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Partida {
	
	//private ArrayList<Pregunta> joc = new ArrayList<Pregunta>();
	/*
	public Partida() {
		Pregunta p1 = new Pregunta("'Shrek 2' va ser la pel·lícula més taquillera l'any que es va estrenar (2004)", true, 3);
		Pregunta p2 = new Pregunta("Abraham Lincoln va ser el primer president dels EUA", false, 2);
		Pregunta p3 = new Pregunta("El riu Amazones és el riu més llarg del món i el riu Nil és riu més caudalós", false, 4);
		Pregunta p4 = new Pregunta("El cantant del grup musical Queen era en Freddy Mercury", true, 1);
		Pregunta p5 = new Pregunta("James Cameron es va fer conegut per la seva pel·lícula 'Avatar'", false, 3);
		Pregunta p6 = new Pregunta("7^3 és 343", true, 5);
		Pregunta p7 = new Pregunta("Alan Turing és conegut com el pare de la informàtica", true, 4);
		Pregunta p8 = new Pregunta("The Legend of Zelda va sortir el 1986", true, 3);
		Pregunta p9 = new Pregunta("Salvador Dalí va crear la famosa pintura 'Guernica'", true, 3);
		Pregunta p10 = new Pregunta("L'escriptor espanyol Miguel de Cervantes era conegut com 'el manco de Lepanto'", true, 3);
		
		joc.add(p1);
		joc.add(p2);
		joc.add(p3);
		joc.add(p4);
		joc.add(p5);
		joc.add(p6);
		joc.add(p7);
		joc.add(p8);
		joc.add(p9);
		joc.add(p10);
		
		Collections.shuffle(joc);
		
		for (int i=0; i<10; i++) {
			System.out.println(joc.get(i));
		}
		
		
	}
	*/
	
	private static boolean correcte(char decisio, Pregunta pregunta) {
		boolean dec = false;
		if (decisio == 'V' || decisio == 'v') {
			dec = true;
		} 
		if (pregunta.getTruth() == dec) {
			return true;
		} else return false;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Pregunta> joc = new ArrayList<Pregunta>();
		
		Pregunta p1 = new Pregunta("'Shrek 2' va ser la pel·lícula més taquillera l'any que es va estrenar (2004)", true, 3);
		Pregunta p2 = new Pregunta("Abraham Lincoln va ser el primer president dels EUA", false, 2);
		Pregunta p3 = new Pregunta("El riu Amazones és el riu més llarg del món i el riu Nil és riu més caudalós", false, 4);
		Pregunta p4 = new Pregunta("El cantant del grup musical Queen era en Freddy Mercury", true, 1);
		Pregunta p5 = new Pregunta("James Cameron es va fer conegut per la seva pel·lícula 'Avatar'", false, 3);
		Pregunta p6 = new Pregunta("7^3 és 343", true, 5);
		Pregunta p7 = new Pregunta("Alan Turing és conegut com el pare de la informàtica", true, 4);
		Pregunta p8 = new Pregunta("The Legend of Zelda va sortir el 1986", true, 3);
		Pregunta p9 = new Pregunta("Salvador Dalí va crear la famosa pintura 'Guernica'", false, 3);
		Pregunta p10 = new Pregunta("L'escriptor espanyol Miguel de Cervantes era conegut com 'el manco de Lepanto'", true, 3);
		
		joc.add(p1);
		joc.add(p2);
		joc.add(p3);
		joc.add(p4);
		joc.add(p5);
		joc.add(p6);
		joc.add(p7);
		joc.add(p8);
		joc.add(p9);
		joc.add(p10);
		
		Collections.shuffle(joc);
		
		int preg=0, corr=0, punts=0, puntsTotal=0;
		
		System.out.print("Introdueixi el seu nom: ");
		String nom = Keyboard.readString();
		System.out.println();
		
		System.out.println("Benvingut " + nom + ". Comencem el joc:");
		for(int i=0; i<10; i++) {
			preg++;
			System.out.println(joc.get(i).getQuestion());
			System.out.print("Cert (V) o Fals(F)? ");
			char decisio = Keyboard.readChar();
			if(correcte(decisio, joc.get(i))) {
				System.out.println("Correcte!");
				corr++;
				punts += joc.get(i).getDifficulty();
				puntsTotal += joc.get(i).getDifficulty();
				
			} else {
				System.out.println("Incorrecte!");
				puntsTotal += joc.get(i).getDifficulty();
			}
			System.out.println();
		}
		System.out.println("Joc finalitzat.");
		System.out.println("Preguntes contestades: " + preg);
		System.out.println("Preguntes correctes: " + corr);
		System.out.println("Has aconseguit " + punts + " de " + puntsTotal);
		System.out.println("Percentatge de preguntes correctes: " + ((preg / corr) * 100) + " %");
		
	}
	
}
