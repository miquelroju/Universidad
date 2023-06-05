package ex_03;

import p0_material.Criatura;
import java.util.*;

/* una altra interficie per a definir el que volem entendre per
   mainaderia ...*/
public interface MainaderiaDos {

    /* matricula una criatura amb el nom l'edat i el sexe 
     * donats com a par�metres. Retorna true si ha pogut matricular
     * a la criatura i false si no ha pogut.
     * Els motius pels quals no es pot matricular una criatura s�n
     * els seg�ents:
     * - ja hi ha una criatura igual (equals...)
     * - el sexe o l'edat no s�n correctes (= el constructor de criatura
     *   genera una excepcio) */
	
    public boolean matricular(String nom, int edat, int sexe);
    
    /* elimina de la mainaderiaDos la criatura que t� el nom indicat.
     * El resultat �s la criatura desmatriculada o null si aquesta no
     * existia */
    
    public Criatura desMatricular(String nom);
    
    /* retorna, sense eliminar-la, la criatura que t� el nom
     * especificat. El resultat �s null si no hi ha cap criatura
     * amb aquell nom */
    public Criatura buscar (String nom);
    
    /* calcula l'edat mitjana de les criatures de la mainaderia */
    public double edatMitjana();
    
    /* calcula l'edat mitjana de les criatures de la mainaderia 
     * que tenen el sexe especificat */
    public double edatMitjana(int sexe);
    
    /* retorna una Col�lecci� amb totes les nenes de la mainaderia
     * (si no hi hagu�s cap nena retornaria una col�lecci� buida */
    public Collection lesNenes();
    
    /* Igual que l'anterior per� amb els nens */
    public Collection elsNens();
    
    /* retorna un iterador que permet rec�rrer la mainaderia */
    public Iterator iterator();
     
}
