package exercici_01_Document;

public class Document {

    // Atributs. Tots privats
    String autor; // persona que ha creat el document
    int pagines; // número de pàgines del document
    int paraules; // número de paraules del document
    boolean confidencial; // és confidencial aquest document?
    
    // CONSTRUCTOR
    public Document (String aut, int pag, int par) {
        // els paràmetres s'usen per a inicialitzar els atributs
        autor = aut;
        pagines = pag;
        paraules = par;
        confidencial = true; // tots els documents 'neixen' confidencials
    }
    
    // MÈTODES get
    public String getAutor() {return autor;}
    public int getPagines() {return pagines;}
    public int getParaules() {return paraules;}
    public boolean getConfidencial () {return confidencial;}
    
    // MÈTODES set
    public void setPagines (int nPag) {
        // només es permet incrementar
        if (nPag > pagines) {
            pagines = nPag;
        }
    }
    public void setParaules (int nPar) {
        // només es permet incrementar
        if (nPar > paraules) {
            paraules = nPar;
        }
    }
    public void setConfidencial (boolean conf) {
        confidencial = conf;
    }
    
    public boolean esDens() {
        // un document és dens quan té més de 600 paraules per pàgina
        return (paraules/pagines > 600);
    }
    
    public double pes (boolean paperQualitat, boolean dobleCara) {
        // quan pesa un document quan s'imprimeix?
        // depen del paper, del número de pàgines i de si es fa 
        // a doble cara o no.
        // Un full de paper de qualitat pesa 7.1 grams
        // un full de paper de menys qualitat pesa 4.7 grams
        
        int nfulls; // fulls que calen per imprimir
        
        if (dobleCara) nfulls = pagines/2 + pagines%2;
        else nfulls = pagines;
        
        if (paperQualitat) return(nfulls*7.1);
        else return(nfulls*4.7);
    }
    
}
