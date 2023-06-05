package exercici_20_BarallaEspanyola;

public class PetitaProva {

    public static void main(String[] args) throws Exception {
        // una manera senzilla de provar una barralla es "buidant-la"
        BarallaEspanyola baralla;
        Naip contingut[];
        int [] oros, bastos, copes, espases;
        int index;

        baralla = new BarallaEspanyola();
        contingut = new Naip[48];
        index = 0;


        while (baralla.enQueden()) {
            contingut[index] = baralla.extraureNaip();
            index++;
        }

        if (index == 48) System.out.println("Efectuades 48 extraccions...");
        else {
            System.out.println("No s'ha pogut fer les 48 extraccions");
            System.out.println("Finalització amb errors");
            System.exit(0);
        }
        
        // ara que la tenim buidada, provem de mirar que hi son totes i sense 
        // repeticions...
        oros = new int[12]; espases = new int[12];
        copes = new int[12]; bastos = new int[12];
        for (int i=0; i<12; i++) {
            copes[i]=0; espases[i]=0;oros[i]=0; bastos[i]=0;
        }
        
        for (int i=0; i<48; i++) {
            switch(contingut[i].getColl()) {
                case Naip.BASTOS: bastos[contingut[i].getNumero()-1]++;break;
                case Naip.OROS: oros[contingut[i].getNumero()-1]++;break;
                case Naip.ESPASES: espases[contingut[i].getNumero()-1]++;break;
                case Naip.COPES: copes[contingut[i].getNumero()-1]++;break;
            }
        }
        
        for (int i=0; i<12; i++) {
            if (bastos[i]!=1 || oros[i]!=1 || copes[i]!=1 || espases[i]!=1) {
                System.out.println("falten i/o sobren cartes...");
                System.out.println("Finalització amb errors!");
                System.exit(0);
            }
        }
        
        System.out.println("cartes comptades ok");
        
        // per acabar mirem que després de la darrera extracció ja no se'n pugui
        // fer cap més
        try {
            baralla.extraureNaip();
        }
        catch(BarallaException e) {
            System.out.println("Prova finalitzada sense haver detectat errors");
            System.exit(0);
        }
        System.out.println("Baralla permet fer més de 48 extraccions");
        System.out.println("Finalització amb errors!");
    }
}
