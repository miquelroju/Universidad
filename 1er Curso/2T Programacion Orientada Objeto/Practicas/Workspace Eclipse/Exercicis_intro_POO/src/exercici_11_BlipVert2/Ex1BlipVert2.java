package exercici_11_BlipVert2;

public class Ex1BlipVert2 {
	public static void main (String [] args) {
	       BlipVert2 albus, harry, ron;
	       
	       albus = new BlipVert2(10, 20);
	       harry = new BlipVert2(10, 15);
	       
	       albus.vert(100);
	       harry.blip(100);
	       
	       ron = harry;
	       
	       ron.vert(13);
	       
	       ron = new BlipVert2(albus.getAlfa(), harry.getBeta());
	       ron.blip(1);
	       ron.vert(1);
	       
	       albus.reGamma();
	       harry.reGamma();
	       ron.reGamma();
	       
	       System.out.println("albus.alfa = " + albus.getAlfa());
	       System.out.println("albus.beta = " + albus.getBeta());
	       System.out.println("albus.gamma = " + albus.getGamma());
	       System.out.println();
	       System.out.println("harry.alfa = " + harry.getAlfa());
	       System.out.println("harry.beta = " + harry.getBeta());
	       System.out.println("harry.gamma = " + harry.getGamma());
	       System.out.println();
	       System.out.println("ron.alfa = " + ron.getAlfa());
	       System.out.println("ron.beta = " + ron.getBeta());
	       System.out.println("ron.gamma = " + ron.getGamma());
	   }

}
