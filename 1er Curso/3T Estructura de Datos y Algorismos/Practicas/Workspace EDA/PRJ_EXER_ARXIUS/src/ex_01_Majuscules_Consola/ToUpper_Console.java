package ex_01_Majuscules_Consola;

import java.io.*;
import Keyboard.*;

public class ToUpper_Console {

    public static void main (String [] args) {
        String filename;
        File file;
        BufferedReader entrada = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensio): ");
        filename = Keyboard.readString();
        filename = filename+".txt";

        // vincular i obrir
        file = new File(filename);
        try {
            /* COMPLETAR */
        	
        }
        catch (FileNotFoundException e) {
            /* COMPLETAR */
        	
        }

        // llegir i mostrar en majúscules
        System.out.println();
        System.out.println("--------------------------------------------------");
        try {
           /* COMPLETAR */
        	
        }
        catch (IOException e) {
           /* COMPLETAR */
        	
        }
        System.out.println("--------------------------------------------------");
    }

}
