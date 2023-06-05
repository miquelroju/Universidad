package CompteCorrent;

public class CompteCorrent {
	
	private String titular;
	private int numero;
	private double saldo;
	private double limitCredit;
	
	public CompteCorrent (String titular, int numero) {
		this.titular = titular;	// this necessari
		this.numero = numero;	// this necessari
		
		this.saldo = 0.0;		// this NO necessari
		this.limitCredit = 0.0;	// this NO necessari
	}
	
	// Mètodes d'accés. En tots 4 casos this no és necessari perquè no hi ha
	// possibilitat de conflicte
	
	public String getTitular() {
		return this.titular;
	}
	public int getNumero() {
		return this.numero;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public double getLimitCredit() {
		return this.limitCredit;
	}
	
	

}
