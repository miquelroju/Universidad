package Examen1Curs202122;

public class Serie extends Produccio {
	
	private int quantesTemporades;
	private AcbEnll temporades[];
	
	public Serie (String titol, int any, int temporades) throws IllegalArgumentException {
		super(titol, Produccio.serie, any);
		if (temporades <= 0) throw new IllegalArgumentException("Nombre de temporades igual o inferior a zero, nombre invalid");
		else this.quantesTemporades = temporades;
		this.temporades = new AcbEnll[temporades];
		for (int i = 0; i < temporades; i++) {
			this.temporades[i] = new AcbEnll();
		}
	}
	
	public int getQuantesTemporades() {
		return this.quantesTemporades;
	}
	
	public boolean afegirCapitol (int temporada, Capitol ca) {
		try {
			temporades[temporada - 1].Inserir(ca);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/*
	public boolean eliminarCapitol (Capitol ca) {
		try {
			for (int i = 0; i < this.quantesTemporades; i++) {
				temporades[i].Esborrar(ca);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	*/
	
	public boolean eliminarCapitol (Capitol ca) {
		for (int i = 0; i < this.quantesTemporades; i++) {
			try {
				temporades[i].Esborrar(ca);
				return true;
			} catch (Exception e) {
				
			}
		}
		return false;
	}
	
	public int temporadaMesCapitols() {
		int cont = -1, contMes = -1;
		for (int i = 0; i < this.quantesTemporades; i++) {
			int q = this.temporades[i].quants();
			if (cont < q) {
				contMes = i;
				cont = q;
			}
		}
		return contMes + 1;
	}
	
	public int teCapitol (int quina, String titol) throws Exception {
		int q = this.temporades[quina - 1].te(new Capitol(0, titol));
		if (q == -1) throw new Exception("No existeix");
		return q;
	}
	
	public String teDurada (int durada) {
		for (int i=0; i<this.quantesTemporades; i++) {
			String titol = this.temporades[i].teDurada(durada);
			if (titol != null) return titol;
		}
		return null;
	}
}
