package ExOrdinadorRef1;
import Ordinador.Ordinador;

public class ExOrdinadorRef1 {

	public static void main(String[] args) {
		
		Ordinador o1, o2, o3;
		o1 = new Ordinador ("Albert", 512, 2.0, 2004);
		o2 = new Ordinador ("Berta", 512, 1.6, 2002);
		
		// Quants ordinadors hi ha?			2
		
		o3 = o1;
		
		// I ara, quants ordinadors hi ha?	3
		
		o1.setMemoria(1024);
		o3.setPropietari("Robert");
		o3.setMemoria(2048);
		
		// Què ha passat?					S'ha canviat la memoria del ordinador 1 a 1024
		//									i la memoria del ordinador 3 a 2048 i el 
		//									propietari a Robert
		
		System.out.println("o1: ");
		System.out.println(o1.getPropietari());
		System.out.println(o1.getMemoria());
		
		System.out.println("o3: ");
		System.out.println(o3.getPropietari());
		System.out.println(o3.getMemoria());
		
		o2 = o1;
		
		// I ara, quants n'hi ha d'ordinadors?	3
		
		o1.setPropietari("Carme");
		o2.setMemoria(512);
		o3.setPropietari("Diana");
		
		// Què ha passat?					S'ha canviat els propietaris del ordinador 1 i 3
		//									i s'ha canviat la memoria del ordinador 2 a 512
		
		System.out.println("o1: ");
		System.out.println(o1.getPropietari());
		System.out.println(o1.getMemoria());
		
		System.out.println("o2: ");
		System.out.println(o2.getPropietari());
		System.out.println(o2.getMemoria());
		
		System.out.println("o3: ");
		System.out.println(o3.getPropietari());
		System.out.println(o3.getMemoria());
		
	}
	
}
