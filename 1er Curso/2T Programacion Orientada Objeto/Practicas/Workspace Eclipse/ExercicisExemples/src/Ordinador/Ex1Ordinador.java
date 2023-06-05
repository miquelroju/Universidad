package Ordinador;
// import Ex1Ordinador.Ordinador;

public class Ex1Ordinador {

	public static void main(String[] args) {
		
		// Declaració de dues variables de tipus Ordinador
		
		Ordinador o1;
		Ordinador o2;
		
		boolean vell;
		int mem;
		
		// Creació de dos ordinadors
		
		o1 = new Ordinador ("ALBA", 512, 2.4, 2004);
		o2 = new Ordinador ("BERNAT", 1024, 2.8, 2005);
		
		// Consulta de la memòria del primer ordinador
		
		mem = o1.getMemoria();
		System.out.print("La memoria del o1 es: ");
		System.out.println(mem);
		
		// Consulta de la memòria del segon ordinador
		
		mem = o2.getMemoria();
		System.out.print("La memoria del o2 es: ");
		System.out.println(mem);
		
		// Canvi de la memòria del primer ordinador
		
		o1.setMemoria(2048);
		mem = o1.getMemoria();
		System.out.print("Despres d'ampliar-la, la memoria de o1 és: ");
		System.out.println(mem);
		
		// Determinar si el primer ordinador es vell
		
		vell = o1.esVell(2006);
		System.out.print("L'ordinador o1 ");
		if (vell) {
			System.out.println("es vell");
		} else {
			System.out.println("encara no es vell");
		}
		
		// Final del main
		
		
	}
	
	// Final de Ex1Ordinador
	
}
