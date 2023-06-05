package exercici_05_Ascensors;

public class Ascensor {
    
    private int pis;  //pis en el qual es troba l'ascensor
    private int max;  //numero del pis més alt
    private int min;  //numero del pis més baix
    
    public Ascensor(int inf, int sup) {
        /* Constructor. Un ascensor es contrueix donant el pis
        mes baix i el mes alt als quals pot anar */
        min=inf;
        max=sup;
        pis=min; //D'entrada queda situat en el pis més baix
    }
    
    public int getMax() {return max;}
    public int getMin() {return min;}
    public int getPis() {return pis;}
    
    /* mètode per pujar un pis més amunt, si es pot*/
    public void pujar() {
        if (pis<max) {pis=pis+1;}
    }
    
    /* mètode per baixar un pis més avall, si es pot*/
    public void baixar() {
        if (pis>min) {pis=pis-1;}
    }
    
    /* mètode per anar directament a un pis, si es pot */
    public void anar(int planta) {
        if ((planta>=min)&&(planta<=max)) {
            pis=planta;
        }
    }
}
