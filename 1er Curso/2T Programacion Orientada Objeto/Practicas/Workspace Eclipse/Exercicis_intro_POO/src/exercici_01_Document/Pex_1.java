package exercici_01_Document;

// import exercici_01.Document; /* no cal import perqu� �s al mateix paquet */

public class Pex_1 {
 public static void main (String [] args) {
     
     /* Poseu aqu� el codi demanat */
	 
	 Document doc1, doc2, doc3, doc4;
	 
	 doc1 = new Document ("Alba", 10, 4000);
	 doc2 = new Document ("Bernat", 45, 31500);
	 doc3 = new Document ("Carme", 11, 7800);
	 doc4 = new Document ("D�dac", 22, 13100);
	 
	 doc1.setConfidencial(false);
	 doc2.setConfidencial(false);
	 doc3.setConfidencial(false);
	 doc4.setConfidencial(true);
	 
	 System.out.println("Informaci� sobre la densitat dels documents");
	 System.out.println("-------------------------------------------");
	 System.out.print("El document de " + doc1.getAutor());
	 
 }
}
