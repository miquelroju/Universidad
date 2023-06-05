package Practica1Sessio2;
import Keyboard.*;


public class JocVida {
	
	public static void main(String args[]) {
		Taulell t;
		
		int files;
		int columnes;
		int orgVius;
		
		System.out.println("               JOC DE LA VIDA");
		System.out.println("Miquel Rodríguez Juvany i Daniel Ruano Villalba");
		System.out.println();
		
		do {
			System.out.print("Quantes files tindra el taulell? [5, 15]: ");
			files = Keyboard.readInt();
		} while (files<5 || files>15);
		
		do {
			System.out.print("Quantes columnes tindra el taulell? [5, 15]: ");
			columnes = Keyboard.readInt();
		} while (columnes<5 || columnes>15);
		
		t = new Taulell(files, columnes);
		
		do {
			System.out.print("Quants organismes vius tindra el taulell? [1, " + (t.getFiles()*t.getColumnes()) + "]: ");
			orgVius = Keyboard.readInt();
		} while (orgVius<1 || orgVius>t.getFiles()*t.getColumnes());
		System.out.println();
		
		t.posarVida(orgVius);
		
		System.out.println();
		System.out.println("Taulell inicial:");
		t.mostraTaulell();
		System.out.println();
		
		System.out.print("Quantes generacions vols fer? [1, 10]: ");
		int gen = Keyboard.readInt();
		System.out.println();
		
		for(int i=0; i<gen; i++)
		{
			t.ferGeneracio();
			System.out.println("Generació: " + (i+1));
			t.mostraTaulell();
			System.out.println("");
		}
		
		System.out.println("Numero d'organismes vius: " + t.getVius());

	}
}

