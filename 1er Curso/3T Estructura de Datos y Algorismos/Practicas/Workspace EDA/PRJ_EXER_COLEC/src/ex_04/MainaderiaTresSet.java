package ex_04;

import p0_material.Criatura;
import java.util.*;

/* implementació de la interficie MainaderiaTres basada en Set */
public class MainaderiaTresSet implements MainaderiaTres, Iterable<Criatura>{

    private Set<Criatura> infrastructura; //Conjunt que farà, com el seu nom
    //indica, d'infrastructura per a guardar les criatures
    
    public MainaderiaTresSet() {
        // constructor
        /* ENCARA S'HA DE COMPLETAR */
        
    }

    /* CAL IMPLEMENTAR TOTS ELS MÈTODES DEFINITS A LA INTERFICIE */
    // Excepte iterator que ja el teniu implementat de regal

    /* retorna un iterador que permet recórrer la mainaderia */
    public Iterator<Criatura> iterator() {
        return infrastructura.iterator();
    }
    
}
