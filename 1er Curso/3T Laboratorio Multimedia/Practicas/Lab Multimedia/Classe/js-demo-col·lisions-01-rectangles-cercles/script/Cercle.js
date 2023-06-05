class Cercle extends Figura{
    constructor(puntPosicio, radi){
        super(puntPosicio);
        this.radi = radi;
    }

    set setColor(color){
        this.color = color;
    }
    get getArea(){
        return Math.PI * Math.pow(this.radi,2);        
    }

    puntInteriorCercle(punt){
        return(
            this.posicio.distanciaDosPunts(
                this.posicio, punt)< this.radi);
    }

    dibuixa(ctx){
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.arc(this.posicio.x, this.posicio.y, this.radi, 0, 2 * Math.PI);
        ctx.fill();
    }

    //mou ho fa el pare

    colisioCercles(cercle){
        return (Punt.distanciaDosPunts(
            this.posicio, cercle.posicio)<
             this.radi + cercle.radi);
    }
   

}