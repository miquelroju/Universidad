package Ordinador;

public class Ordinador {
	
	// ATRIBUTS
	
	private String propietari;
	private int memoria;
	private double velCPU;
	private int any;
	
	// Mètode CONSTRUCTOR
	
	public Ordinador (String prop, int mem, double vel, int a) {
		
		propietari = prop;
		memoria = mem;
		velCPU = vel;
		any = a;
		
	}
	
	// Mètodes d'accés als atributs (GET)
	
	public String getPropietari() {
		return propietari;
	}
	public int getMemoria() {
		return memoria;
	}
	public double getVelCPU() {
		return velCPU;
	}
	public int getAny() {
		return any;
	}
	
	// Mètodes de modificació d'atributs (SET)

	public void setMemoria (int mem) {
		if (mem >= 256) {
			memoria = mem;
		}
	}
	
	public void setPropietari (String prop) {
		propietari = prop;
	}
	
	// Altres mètodes
	
	public boolean esVell (int anyActual) {
		int dif;
		dif = anyActual - any;
		return (dif >= 3);
	}
}
