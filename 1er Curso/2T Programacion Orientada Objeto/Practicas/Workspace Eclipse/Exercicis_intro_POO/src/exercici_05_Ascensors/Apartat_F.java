package exercici_05_Ascensors;

public class Apartat_F {
	
	public static void main(String[] args) {

		Ascensor a1, a2, a3;

		a1 = new Ascensor(10, 20);
		a3 = a1;
		a2 = new Ascensor(a3.getPis() / 2, a1.getMin());
		a3.pujar();
		a2.anar(a1.getPis());
		a3 = a2;
		a2 = new Ascensor(a3.getMin() - 1, a2.getMax());

		System.out.println(a1.getPis() + a2.getPis() + a3.getPis());

	}

}
