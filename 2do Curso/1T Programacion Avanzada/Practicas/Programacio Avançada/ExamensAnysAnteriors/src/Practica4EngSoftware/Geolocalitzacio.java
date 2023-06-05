package Practica4EngSoftware;
import java.util.*;

public class Geolocalitzacio {
	
	private LinkedList<Integer> latitud;
	private LinkedList<Integer> longitud;
	
	public Geolocalitzacio() {
		this.latitud = new LinkedList<Integer>();
		this.longitud = new LinkedList<Integer>();
	}
	
	public Geolocalitzacio(LinkedList<Integer> latitud, LinkedList<Integer> longitud) {
		this.latitud = latitud; this.longitud = longitud;
	}
	
	public LinkedList<Integer> getLatitud() {return this.latitud;}
	public LinkedList<Integer> getLongitud() {return this.longitud;}
	
	public void setLatitud(LinkedList<Integer> latitud) {this.latitud = latitud;}
	public void setLongitud(LinkedList<Integer> longitud) {this.longitud = longitud;}

}
