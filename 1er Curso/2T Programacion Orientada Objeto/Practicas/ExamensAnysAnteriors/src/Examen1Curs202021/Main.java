package Examen1Curs202021;

public class Main {
	
	private static int quinMes(Immoble[] immo) {
		int quantitat = 0, max = 0, tipusMax=0;
		for (int i = 0; i < immo.length; i++) {
			if(immo[i].tipusImmoble() == Immoble.APARTAMENT) {
				quantitat++;
			}
		}
		if (quantitat > max) {
			max = quantitat;
			tipusMax = Immoble.APARTAMENT;
			quantitat = 0;
		}
		
		for (int i = 0; i < immo.length; i++) {
			if(immo[i].tipusImmoble() == Immoble.PIS) {
				quantitat++;
			}
		}
		if (quantitat > max) {
			max = quantitat;
			tipusMax = Immoble.PIS;
			quantitat = 0;
		}
		
		for (int i = 0; i < immo.length; i++) {
			if(immo[i].tipusImmoble() == Immoble.LOCAL) {
				quantitat++;
			}
		}
		if (quantitat > max) {
			max = quantitat;
			tipusMax = Immoble.LOCAL;
			quantitat = 0;
		}
		
		for (int i = 0; i < immo.length; i++) {
			if(immo[i].tipusImmoble() == Immoble.CASA) {
				quantitat++;
			}
		}
		if (quantitat > max) {
			max = quantitat;
			tipusMax = Immoble.CASA;
			quantitat = 0;
		}
		return tipusMax;
	}
	
	private static boolean teAlmenys3(Immobiliaria in) {
		int cont=0, i=0;
		while (in.getImmobleVenda(i)!=null) {
			if (in.getImmobleVenda(i).isVendaILloguer()) {
				cont++;
				if (cont==3) return true;
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
		
	}

}
