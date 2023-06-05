package exercici_01_Document;

public class Document {

    // Atributs. Tots privats
    String autor; // persona que ha creat el document
    int pagines; // n�mero de p�gines del document
    int paraules; // n�mero de paraules del document
    boolean confidencial; // �s confidencial aquest document?
    
    // CONSTRUCTOR
    public Document (String aut, int pag, int par) {
        // els par�metres s'usen per a inicialitzar els atributs
        autor = aut;
        pagines = pag;
        paraules = par;
        confidencial = true; // tots els documents 'neixen' confidencials
    }
    
    // M�TODES get
    public String getAutor() {return autor;}
    public int getPagines() {return pagines;}
    public int getParaules() {return paraules;}
    public boolean getConfidencial () {return confidencial;}
    
    // M�TODES set
    public void setPagines (int nPag) {
        // nom�s es permet incrementar
        if (nPag > pagines) {
            pagines = nPag;
        }
    }
    public void setParaules (int nPar) {
        // nom�s es permet incrementar
        if (nPar > paraules) {
            paraules = nPar;
        }
    }
    public void setConfidencial (boolean conf) {
        confidencial = conf;
    }
    
    public boolean esDens() {
        // un document �s dens quan t� m�s de 600 paraules per p�gina
        return (paraules/pagines > 600);
    }
    
    public double pes (boolean paperQualitat, boolean dobleCara) {
        // quan pesa un document quan s'imprimeix?
        // depen del paper, del n�mero de p�gines i de si es fa 
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
