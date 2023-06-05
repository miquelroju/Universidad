class Linia {
    constructor (puntA, puntB) {
        this.puntA = puntA;
        this.puntB = puntB;
        this.color = "#f20";
    }

    draw(ctx) {
        ctx.beginPath();
        ctx.moveTo(this.puntA.x, this.puntA.y);
        ctx.moveTo(this.puntB.x, this.puntB.y);
        ctx.strokeStyle = this.color;
        ctx.stroke();
    }
}