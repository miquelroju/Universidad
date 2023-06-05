package exercici_07_TeleTonta;

public class TeleTonta {
	private boolean enMarxa;   // true si la tele està en funcionament
	private double frequencia; // freqüencia sintonitzada
	private int volum; // volum del so


	/* Constructor: una tele es fabrica sintonitzant una determinada
       freqüencia i sempre surt de fàbrica parada i amb el volum a zero */
	public TeleTonta (double frequencia) {
		if (frequencia<0) {this.frequencia=0.0;}
		else {this.frequencia = frequencia;}
		enMarxa=false;
		this.volum=0;				// Si sempre que ens referim a un atribut posem this esta be, sino, no fa falta
	}

	public boolean getEnMarxa() {return(this.enMarxa);}			// Correcte pero no necessari
	public int getVolum() {return(volum);}
	public double getFrequencia() {return(this.frequencia);}	// Correcte pero no necessari

	/* controla l'interruptor de posta en marxa. Si la tele
	   està funcionant l'apaga i si està apagada la posa en marxa.
	   O potser no... */
	public void polsarInterruptor() {
		this.enMarxa = !this.enMarxa;
		/*
		boolean enMarxa;
		enMarxa = this.enMarxa;
		if (enMarxa) {this.enMarxa=!enMarxa;}		// abans era if (enMarxa) {enMarxa=!enMarxa;}
		else {this.enMarxa=!enMarxa;}
		*/
	}

	/* Controla el volum. Si la tele està en marxa augmenta una unitat
       el volum, si el paràmetre és true. Si és false el decrementa
	   una unitat. No fa res si la tele no està en marxa.
	   O potser no és exactament així ... */ 
	public void modificarVolum (boolean amunt) {
		if (enMarxa) {
			if (amunt) {volum=this.volum+1;}
			else {this.volum=volum-1;}
		}
	} 

	/* Controla la sintonització (freqüència) de la tele, si aquesta
	   està en marxa. Es limita a sincronitzar la tele a la freqüència
	   indicada, excepte quan es negativa, que tampoc fa res. O no? */
	public void sintonitzar (double frequencia) {
		if (this.enMarxa) {
			if (this.frequencia >= 0.0) {this.frequencia=frequencia;}	// abans era if (this.frequencia >= 0.0) {frequencia=this.frequencia;}	
		} 
	}

}

