package exercici_19_TaulesEstudiants;

import java.util.Random;

public class GeneradorEstudiants {

    private static final String [] NOMS = {
        "ABEL", "BERNAT", "CARLES", "DIDAC", "EMILI", "FERRAN", "GENIS",
        "ANNA", "BERTA", "CLARA", "DOLORS", "EUG�NIA", "F�TIMA",
        "HIP�LIT", "IGNASI", "JORDI", "KEVIN", "LLU�S", "MARC", "NARC�S",
        "HELENA", "IRINA", "JEZABEL", "L�DIA", "MARTA", "NOEMI",
        "�SCAR", "PERE", "ROBERT", "SERGI", "TOM�S", 
        "OLGA", "PATRICIA", "ROSER", "SELMA", "TINA",
        "VICTOR", "XAVIER", "YUSEF", "ZEN�", 
        "VICT�RIA", "X�NIA"};

    private boolean ambNotes;
    private Random alea;
    
    public GeneradorEstudiants (boolean ambNotes) {
        this.ambNotes = ambNotes;
        this.alea = new Random();
    }
    
    public Estudiant generar () {
        Estudiant resultat;
        int edat = 18 + this.alea.nextInt(19);
        String nom = NOMS[this.alea.nextInt(NOMS.length)];
        resultat = new Estudiant (nom, edat);
        if (this.ambNotes) {
            resultat.setNotaMates(this.alea.nextInt(11));
            resultat.setNotaAngles(this.alea.nextInt(11));
            resultat.setNotaProg(this.alea.nextInt(11));
        }
        
        return resultat;
    }
    
}