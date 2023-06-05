package ex_04;

import p0_material.Criatura;
import java.util.*;

/* una altra interficie per a definir el que volem entendre per
   mainaderia ... Aquesta utilitza la notació <E> per garantir que
   les col·leccions que retorna ho són de només criatures*/
public interface MainaderiaTres {

    /* matricula una criatura amb el nom l'edat i el sexe 
     * donats com a paràmetres. Retorna true si ha pogut matricular
     * a la criatura i false si no ha pogut.
     * Els motius pels quals no es pot matricular una criatura són
     * els següents:
     * - ja hi ha una criatura igual (equals...)
     * - el sexe o l'edat no són correctes (= el constructor de criatura
     *   genera una excepcio) */
    public boolean matricular(String nom, int edat, int sexe);
    
    /* elimina de la mainaderiaDos la criatura que té el nom indicat.
     * El resultat és la criatura desmatriculada o null si aquesta no
     * existia */
    
    public Criatura desMatricular(String nom);
    
    /* retorna, sense eliminar-la, la criatura que té el nom
     * especificat. El resultat és null si no hi ha cap criatura
     * amb aquell nom */
    public Criatura buscar (String nom);
    
    /* calcula l'edat mitjana de les criatures de la mainaderia */
    public double edatMitjana();
    
    /* calcula l'edat mitjana de les criatures de la mainaderia 
     * que tenen el sexe especificat */
    public double edatMitjana(int sexe);
    
    /* retorna una Col·lecció amb totes les nenes de la mainaderia
     * (si no hi hagués cap nena retornaria una col·lecció buida */
    public Collection<Criatura> lesNenes();
    
    /* Igual que l'anterior però amb els nens */
    public Collection<Criatura> elsNens();
    
    /* retorna un iterador que permet recórrer la mainaderia */
    public Iterator<Criatura> iterator();
     
}
