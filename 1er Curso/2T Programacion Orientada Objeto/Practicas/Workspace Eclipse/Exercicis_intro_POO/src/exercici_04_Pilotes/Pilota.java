package exercici_04_Pilotes;

/* definició de la classe Pilota.
Una pilota es caracteritza pel nom del seu propietari,  
per la seva pressió d'inflat i per la seva operativitat 
(una pilota no operativa és una pilota que s'ha rebentat) */

public class Pilota {
    private String nomPropietari;
    private int pressio;
    private boolean operativa; // true si es pot jugar amb ella, false en cas contrari
    
    public Pilota(String nomP) {
        /* constructor. El paràmetre és el nom del propietari. 
        Totes les pilotes surten de fàbrica amb 10 unitats de pressió */
        nomPropietari=nomP;
        pressio=10;
        operativa=true;
    }
    
    public String getNomPropietari() {
        /* mètode per obtenir el nom del propietari de la pilota */
        return(nomPropietari);
    }
    
    public void inflar(int quantMes) {
        /* mètode per incrementar la pressió de la pilota.
        Quan la pressió supera o iguala les 25 unitats rebenta */
        pressio=pressio+quantMes;
        if (pressio>=25) {
            operativa=false;
            pressio=0;
        }
    }
    
    public void desinflar(int quantMenys) {
        /* mètode per decrementar la pressió de la pilota. 
         Mai no  es pot treure més pressió de la que té */
        if (pressio<=quantMenys) {
            pressio=0;
        } 
        else {
            pressio=pressio-quantMenys;
        }
    }
    
    public String botar() {
        /* mètode per fer botar la pilota. La pilota bota d'una 
         forma o d'una altra en funció de la seva pressió */
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
    
} // final de la definició de la classe Pilota
