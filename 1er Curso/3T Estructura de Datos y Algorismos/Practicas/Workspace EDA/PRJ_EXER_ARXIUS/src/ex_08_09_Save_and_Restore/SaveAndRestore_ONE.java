package ex_08_09_Save_and_Restore;

import java.util.*;
import java.io.*;

public class SaveAndRestore_ONE {

    
    public static void saveONE (Collection<Producte> col, File file)
                            throws IOException {
    	// desa el contingut de la col�lecci� donada en el primer par�metre
        // a l'arxiu especificat pel segon par�metre
    	
        BufferedWriter buw;

        buw = new BufferedWriter(new FileWriter(file));

        for(Producte prod : col) {
            buw.write(prod.getNom()); buw.newLine(); // desar nom
            buw.write(Double.toString(prod.getPreu())); buw.newLine(); // desar preu
            for (Part part : prod.getParts()){ // iterar sobre les parts
                buw.write(part.getId()); buw.newLine(); // desar id de la part
                buw.write(part.getDesc()); buw.newLine(); // desar desc de la part
            }
            buw.write(Part.MARCA); buw.newLine(); // desar marca de finalitzaci� de la seq��ncia de parts
        }
        buw.close();
    }

    
    public static Collection<Producte> restoreONE (File file)
                  throws IOException {
    	 // recupera de l'arxiu especificat el contingut d'una col�lecci� que
        // va ser desada amb el m�tode save
        Collection<Producte> resultat = new ArrayList();
        Set<Part> parts;

        /* COMPLETAR */
       
        return resultat;
    }

}
