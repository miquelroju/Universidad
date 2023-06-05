package Pilota;

public class Bimbes1 {
	public static void main(String[] args) {
		Pilota p1, p2;
		
		p1 = new Pilota("Maradona");
		p2 = new Pilota("Romario");
		
		p1.inflar(10);
		p1.inflar(10);
		
		p2.inflar(5);
		p2.inflar(5);
		
		System.out.println(p1.botar());
		System.out.println(p2.botar());
		
		p1.desinflar(5);
		p2.desinflar(16);
		
		System.out.println();
		System.out.println("Una estona més tard...");
		
		System.out.println(p1.botar());
		System.out.println(p2.botar());
	}

	// Quin és el resultat d'executar aquest programa?
	
	/*  la pilota de en/na Maradona no bota perque s'ha rebentat
	 *	la pilota de en/na Romario fa BOING-BOING
     *
	 *	Una estona més tard...
	 *	la pilota de en/na Maradona no bota perque s'ha rebentat
	 *	la pilota de en/na Romario fa bing-boing
	 */
	
}
