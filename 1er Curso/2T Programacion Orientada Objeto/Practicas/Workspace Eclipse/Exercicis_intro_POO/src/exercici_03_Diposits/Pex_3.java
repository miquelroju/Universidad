package exercici_03_Diposits;

public class Pex_3 {
	public static void main(String[] args) {
	
		Diposits dip1, dip2;
		
		dip1 = new Diposits ("dip1", 100, 1, 0.5);
		dip2 = new Diposits ("dip2", 50, 2, 5);
	
		dip1.omplir(10);

		dip2.omplir(20);

		System.out.println("Hem omplert el primer diposit 10 segons i el segon 20 segons:");
		System.out.println("El primer diposit té " + dip1.getLitres());
		System.out.println("El segon diposit té " + dip2.getLitres());
		System.out.println("");

		dip1.setCabalEntrada(4);

		dip1.omplir(10);

		dip2.buidar(5);

		System.out.println("Hem canviat la valvula d'entrada del primer diposit per una de 4L/s, hem omplert el primer diposit 10 segons i hem buidat el segon 5 segons:");
		System.out.println("El primer diposit té " + dip1.getLitres());
		System.out.println("El segon diposit té " + dip2.getLitres());
		System.out.println("");

		dip1.buidar(20);

		dip2.buidar(20);

		System.out.println("Hem buidat el primer diposit 20 segons i el segon 20 segons:");
		System.out.println("El primer diposit té " + dip1.getLitres());
		System.out.println("El segon diposit té " + dip2.getLitres());
	
	}

}
