package exercici_10_BlipVert;

public class Ex2BlipVert {
	public static void main (String [] args) {
		BlipVert b1, b2;

		b1 = new BlipVert("Arnold", 21);

		b1.sacseja(5, true);

		b2 = unDeMes(b1);

		b1 = unDelsDos(b1,b2);
		b2 = unDelsDos(unDeMes(b1), b2);

		escriureBlipVert(b1);
		escriureBlipVert(b2);
	}

	private static BlipVert unDeMes (BlipVert b) {
		BlipVert elNou;
		if (b.getBeta()>=26) {
			elNou=new BlipVert("Txuas", 3);
		}
		else {
			elNou=new BlipVert("Arneguer", 4);
		}
		return(elNou);
	}

	private static BlipVert unDelsDos (BlipVert b1, BlipVert b2) {
		if (b1.getBeta()>=b2.getBeta()) {return b1;}
		else {return b2;}
	} 

	private static void escriureBlipVert(BlipVert b) {
		System.out.print(b.getAlfa());
		System.out.print(" ");
		System.out.print(b.getBeta());
		System.out.println(b.comEstic());
	}
}
