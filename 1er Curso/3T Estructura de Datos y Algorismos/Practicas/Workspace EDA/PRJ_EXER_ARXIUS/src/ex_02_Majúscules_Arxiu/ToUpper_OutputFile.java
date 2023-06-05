package ex_02_Majúscules_Arxiu;

import java.io.*;
import Keyboard.*;

public class ToUpper_OutputFile {

    public static void main (String [] args) {
        String filename;
        File inputFile, outputFile; // un fitxer per l'entrada i un per la sortida
        BufferedReader entrada = null;
        BufferedWriter sortida = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensio): ");
        filename = Keyboard.readString();

        // vincular i obrir tant l'entrada com la sortida
        inputFile = new File(filename+".txt");
        outputFile = new File(filename+"_UPPER.txt");

        /* COMPLETAR */
       

        // llegir en un i escriure en l'altre
        try {
           /* COMPLETAR */
        	
        }
        catch (IOException e) {
           /* COMPLETAR */
        	
        }
        System.out.println(">>>Arxiu processat. Resultat a "+outputFile.getName());
    }
}
