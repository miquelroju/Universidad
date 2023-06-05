class Figura{
    constructor(puntPosicio){
        this.posicio = puntPosicio;
    }

    mou(x,y){
        this.posicio.x +=x;
        this.posicio.y +=y;
    }

}