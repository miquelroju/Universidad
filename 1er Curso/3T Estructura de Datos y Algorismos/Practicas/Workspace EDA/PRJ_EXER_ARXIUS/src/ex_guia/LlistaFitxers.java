package ex_guia;

import java.io.File;
import java.util.*;

public class LlistaFitxers {
	
	String nom;
	boolean esDir;
	List<LlistaFitxers> fills;
	
	public LlistaFitxers (String nom) {
		this (new File(nom));
	}
	
	public LlistaFitxers (File f) {
		this.nom = f.getName();
		if (f.isDirectory()) {
			esDir = true;
			fills = new LinkedList<>();
			File[] files = f.listFiles();
			for (File file : files) {
				fills.add(new LlistaFitxers(file));
			}
		} else {
			esDir = false;
			fills = null;
		}
	}
	
	public void pinta() {
		pinta(0);
	}
	
	public void pinta(int nivell) {
		System.out.println("".repeat(nivell) + this.nom);
		if () {
			
		}
	}
	
	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\mique\\Desktop\\Tecnocampus\\Workspace EDA\\PRJ_EXER_ARXIUS");
			File[] files = f.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("Directori " + file.getName());
				} else {
					System.out.println("Fitxer    " + file.getName());
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
