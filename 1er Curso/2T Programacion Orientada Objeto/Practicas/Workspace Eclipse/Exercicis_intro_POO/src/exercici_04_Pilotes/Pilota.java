package exercici_04_Pilotes;

/* definici� de la classe Pilota.
Una pilota es caracteritza pel nom del seu propietari,  
per la seva pressi� d'inflat i per la seva operativitat 
(una pilota no operativa �s una pilota que s'ha rebentat) */

public class Pilota {
    private String nomPropietari;
    private int pressio;
    private boolean operativa; // true si es pot jugar amb ella, false en cas contrari
    
    public Pilota(String nomP) {
        /* constructor. El par�metre �s el nom del propietari. 
        Totes les pilotes surten de f�brica amb 10 unitats de pressi� */
        nomPropietari=nomP;
        pressio=10;
        operativa=true;
    }
    
    public String getNomPropietari() {
        /* m�tode per obtenir el nom del propietari de la pilota */
        return(nomPropietari);
    }
    
    public void inflar(int quantMes) {
        /* m�tode per incrementar la pressi� de la pilota.
        Quan la pressi� supera o iguala les 25 unitats rebenta */
        pressio=pressio+quantMes;
        if (pressio>=25) {
            operativa=false;
            pressio=0;
        }
    }
    
    public void desinflar(int quantMenys) {
        /* m�tode per decrementar la pressi� de la pilota. 
         Mai no  es pot treure m�s pressi� de la que t� */
        if (pressio<=quantMenys) {
            pressio=0;
        } 
        else {
            pressio=pressio-quantMenys;
        }
    }
    
    public String botar() {
        /* m�tode per fer botar la pilota. La pilota bota d'una 
         forma o d'una altra en funci� de la seva pressi� */
        String resultat;
        resultat = "la pilota de en/na " + nomPropietari;
        if (!operativa) {
            resultat = resultat + " no bota perque s'ha rebentat";
        } 
        else {
            if (pressio<=5) {
                resultat = resultat + " fa bing-boing";
            } else {
                resultat = resultat + " fa BOING-BOING";
            }
        }
        return(resultat);
    }
    
} // final de la definici� de la classe Pilota
