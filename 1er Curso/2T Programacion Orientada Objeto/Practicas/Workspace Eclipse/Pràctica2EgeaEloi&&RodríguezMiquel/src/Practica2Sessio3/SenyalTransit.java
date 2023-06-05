package Practica2Sessio3;

//import Practica2Sessio3.Ubicacio;

public abstract class SenyalTransit extends Prova{
	
	public final int CIRCULAR = 50;
	public final int TRIANGULAR = 70;
	public final int RECTANGULAR_ALTURA = 132;
	public final int RECTANGULAR_BASE = 93;
	
	protected int advertencia;
	protected int reglamentacio;
	protected int indicacio;
	
	private String codiSenyal; 
	private int tipus; 
	private Ubicacio ubi; 
	private int anyColocacio;
	private int anyRetirada;
	
	
	public int getAdvertencia() {return this.advertencia;}
	public int getReglamentacio() {return this.reglamentacio;}
	public int getIndicacio() {return this.indicacio;}
	
	public void visualitza() {
		System.out.println("El codi del senyal es: " + this.codiSenyal);
		System.out.println("El tipus de senyal es: " + this.tipus);
		System.out.println("La ubicacio del senyal es: " + this.ubi);
		System.out.println("L'any de colocació del senyal es: " + this.anyColocacio);
		System.out.println("L'any de retirada del senyal es: " + this.anyRetirada);
	}
	
	public abstract float area();
	
}
