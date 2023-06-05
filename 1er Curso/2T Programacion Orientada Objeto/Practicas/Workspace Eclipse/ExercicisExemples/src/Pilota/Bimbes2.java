package Pilota;

public class Bimbes2 {
	public static void main (String[] args) {
		Pilota p1, p2, p3;
		
		p1 = new Pilota ("Maradona");
		p2 = new Pilota ("Romario");
		p3 = p1;
		
		p1.inflar(10);
		p2.inflar(10);
		p3.inflar(10);
		
		System.out.println(p1.botar());
		System.out.println(p2.botar());
		System.out.println(p3.botar());
	}

	// Quin és el resultat d'executar aquest programa?
	
	/*  la pilota de en/na Maradona no bota perque s'ha rebentat
	 *	la pilota de en/na Romario fa BOING-BOING
	 *	la pilota de en/na Maradona no bota perque s'ha rebentat
	 */
	
}
