package exercici_01_EstendreMoble;

public class main {
	
	public static void main(String[] args) {
		
		Armari a, b;
		
		a = new Armari("UltraMobel", "Super Modular", 75, 2000, false, 2500, 1, 4, true);
		
		b = new Armari("UltraMobel", "Easy", 55, 1000, false, 750, 2, 2, false);
			
		for(int i=0; i<3; i++ ) {
			a.afegirLleixa();
		}
		
		for(int i=0; i<2; i++ ) {
			b.afegirLleixa();
		}
		
		System.out.println("L'armari " + a.getMarca() + " " + a.getModel() + " surt per " + a.getPreuBase() + " euros");
		System.out.println("L'armari " + b.getMarca() + " " + b.getModel() + " surt per " + b.getPreuBase() + " euros");
	}
	
}
