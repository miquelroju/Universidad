package Pilota;

public class Pilota {
	
	private String nomPropietari;
	private int pressio;
	private boolean operativa;
	
	public Pilota (String nomP) {
		nomPropietari = nomP;
		pressio=10;
		operativa=true;
	}
	
	public String getNomPropietari() {
		return(nomPropietari);
	}
	
	public void inflar (int quantMes) {
		pressio = pressio + quantMes;
		if (pressio >= 25) {
			operativa = false;
			pressio = 0;
		}
	}
	
	public void desinflar (int quantMenys) {
		if (pressio <= quantMenys) {
			pressio = 0;
		}
		else {
			pressio = pressio - quantMenys;
		}
	}
	
	public String botar() {
		
		String resultat;
		resultat = "la pilota de en/na " + nomPropietari;
		if (!operativa) {
			resultat = resultat + " no bota perque s'ha rebentat";
		}
		else {
			if (pressio <= 5) {
				resultat = resultat + " fa bing-boing";
			}
			else {
				resultat = resultat + " fa BOING-BOING";
			}
		}
		return(resultat);
	}
	
	// Final de la definició de la classe Pilota

}
