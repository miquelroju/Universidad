package Cartes;

public class Carta implements Comparable<Carta>{
    private int numeracio;
    private String pal;

    public Carta(int numeracio, String pal) {
        this.numeracio = numeracio;
        this.pal = pal;
    }

    public String toString() {
        return numeracio + " de " + pal;
    }

    public int compareTo(Carta o) {
        if (o.tipus() > this.tipus()) {
            return -1;
        } else if (o.tipus() < this.tipus()) {
            return 1;
        } else {
            if (o.numeracio < this.numeracio) {
                return 1;
            } else if (o.numeracio > this.numeracio) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private int tipus() {
        switch (this.pal) {
        case "COPA":
            return 0;
        case "ESPASA":
            return 1;
        case "OROS":
            return 2;
        case "BASTONS":
            return 3;
        default : return 4;
        }
    }

}
