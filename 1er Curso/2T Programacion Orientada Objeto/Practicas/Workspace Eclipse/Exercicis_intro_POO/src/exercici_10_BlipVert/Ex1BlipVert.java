package exercici_10_BlipVert;

public class Ex1BlipVert {
	public static void main (String [] args) {
		BlipVert b1, b2;
		
		b1 = new BlipVert("Ying", 10);
		b2 = new BlipVert("Yang", 13);

		potineja(b1, 5);
		mareja(b1, b2); 

		escriureBlipVert(b1);
		escriureBlipVert(b2);
	}

	private static void potineja (BlipVert b, int n) {
		b.sacseja(n, false);
		b.sacseja(n, true);
	}

	private static void mareja (BlipVert a, BlipVert b) {
		a.sacseja(b.getBeta(), b.getBeta()>7);
	}

	private static void escriureBlipVert(BlipVert b) {
		System.out.print(b.getAlfa());
		System.out.print(" ");
		System.out.print(b.getBeta());
		System.out.println(b.comEstic());
	}
}
