package Examen1Curs202122Rec;

public class Serie extends Produccio {
	private int quantesTemporades;
	private AcbEnll temporades[];
	
	public Serie (String titol, int any, int temporades) throws IllegalArgumentException {
		super(titol, Produccio.serie, any);
		if (temporades <= 0) throw new IllegalArgumentException("El valor de temporades no es correcte");
		this.quantesTemporades = temporades;
		this.temporades = new AcbEnll[this.quantesTemporades]; // M'HAVIA OBLIDAT DE POSAR AIXO
		for (int i = 0; i < this.quantesTemporades; i++) {
			this.temporades[i] = new AcbEnll();
		}
	}
	
	public int getQuantesTemporades() {return this.quantesTemporades;}
	
	public boolean afegirCapitol(int temporada, Capitol ca) {
		try {
			this.temporades[temporada - 1].Inserir(ca); // M'HAVIA EQUIVOCAT POSANT THIS.QUANTESTEMPORADAS EN COMPTES DE TEMPORADA - 1
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean eliminarCapitol(Capitol ca) {
		for (int i = 0; i < this.quantesTemporades; i++) {
			try {
				this.temporades[i].Esborrar(ca);
				return true;
			} catch (Exception e) {
				
			}
		}
		return false;
	}
	
	public int temporadaMesCapitols() {
		int cont = -1;
		int max = -1;

		for (int i = 0; i < this.quantesTemporades; i++) {
			int q = this.temporades[i].quants();
			if (cont < q) {
				max = i;
				cont = q;
			}
		}
		
		return max + 1;
	}
	
	public int teCapitol(int quina, String titol) throws Exception {
		int q = this.temporades[quina - 1].te(new Capitol(0, titol));
		if (q == -1) throw new Exception ("Aquest capitol no existeix");
		return q;
	}
	
}



















