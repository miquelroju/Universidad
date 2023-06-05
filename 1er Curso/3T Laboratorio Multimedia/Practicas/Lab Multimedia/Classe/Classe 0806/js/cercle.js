class Cercle extends Punt {
    constructor (puntCentre, radi) {
        super(puntCentre.x, puntCentre.y);
        this.radi = radi;
        this.color = "#fbb";
    }

    draw(ctx) {
        ctx.beginPath();
        ctx.arc(this.x,this.y,this.radi,0,2*Math.PI);
        
    }
}