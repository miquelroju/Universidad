package ex_05_Comptar_LA;

import java.io.*;
import Keyboard.*;

public class Comptar_LA {

    public static void main (String [] args) throws IOException {
    // en aquest exercici no caldr� capturar excepcions perqu� si aquestes
    // es produissin deixariem que fossin propagades fins a la m�quina 
    // virtual.

       File file;
       String filename;
       BufferedReader entrada;
       String linia;
       int aparicions;

       System.out.println();
       System.out.print("nom de l'arxiu TXT (sense extensi�): ");
       filename = Keyboard.readString();
       filename = filename + ".txt";


       /* COMPLETAR */

       System.out.println("la cadena LA apareix "+aparicions+" vegades");

    }

    private static int processarLinia (String linia) {
        // aquest procediment compta el n�mero de vegades que apareix 
        // la cadena LA, en qualsevol de les seves variants, a la l�nia de
        // text donada com a par�metre
        int pos, resultat;

        linia = linia.toUpperCase();
        
        resultat = 0;
        pos = linia.indexOf("LA");

        /* COMPLETAR */
        // us pot ser �til una iteraci� en qu� es fa �s del m�tode
        // indexOf en la seva versi� de dos par�metres...

        return resultat;
    }
}
