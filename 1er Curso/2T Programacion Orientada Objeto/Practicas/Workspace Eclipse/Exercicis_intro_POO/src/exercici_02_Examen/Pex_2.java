package exercici_02_Examen;

public class Pex_2 {

    public static void main (String [] args) {
        Examen ex1, ex2, ex3;
        
        ex1 = new Examen("Arnau");
        ex2 = new Examen("Bibiana");
        ex3 = new Examen("Conrad");
        
        // posar qualificacions al primer
        ex1.setQ1(8.0); 
        ex1.setQ2(3.0);
        // posar qualificacions al segon
        ex2.setQ1(7.0); 
        ex2.setQ2(9.0);
        // posar qualificacions al tercer
        ex3.setQ1(6.0); 
        ex3.setQ2(4.0);
        
        // no permetre més modificacions de cap examen
        ex1.setModificable(false);
        ex2.setModificable(false);
        ex3.setModificable(false);
        
        // aquest canvi ja no hauria de tenir cap efecte
        ex2.setQ1(2.0); ex2.setQ2(3.0);
        
        // Mostrar la informació que es té dels examens
        System.out.println();
        System.out.println("Informació dels exàmens");
        System.out.println("-----------------------");
        
        System.out.println("Pel que fa a l'examen de: "+ex1.getNomEstudiant());
        System.out.println("  La nota és: "+ex1.nota(true));
        System.out.println("  El número de parts aprovades es: "+ex1.partsAprovades());
        
        System.out.println("Pel que fa a l'examen de: "+ex2.getNomEstudiant());
        System.out.println("  La nota és: "+ex2.nota(true));
        System.out.println("  El número de parts aprovades es: "+ex2.partsAprovades());
        
        System.out.println("Pel que fa a l'examen de: "+ex3.getNomEstudiant());
        System.out.println("  La nota és: "+ex3.nota(true));
        System.out.println("  El número de parts aprovades es: "+ex3.partsAprovades());
        System.out.println();
    }
    
}
