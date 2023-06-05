class Joc {
    constructor(canvas, ctx) {
        this.canvas = canvas;
        this.ctx = ctx;

        this.rectangle = new Rectangle(
            new Punt((this.canvas.width/2)-5, (this.canvas.height/2)-5, 10, 10) 
            );
    }

    dibuixa() {
        this.rectangle.dibuixa(this.ctx);
        this.rectangleFix.dibuixa(this.ctx);
    }

    clearCanvas() {
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }

    mouRectangle(x,y) {
        this.clearCanvas();
        this.rectangle.mou(x,y);
        this.dibuixa();
    }

    colisioRectangle() {
        return (
            this.rectangle.posicio.x + this.rectangle.amplada < this.rectangleFix.posicio.x ||
            this.rectangle.posicio.x > this.rectangleFix.posicio.x + this.rectangleFix.amplada ||
            this.rectangle.posicio.y + this.rectangle.alcada < this.rectangleFix.posicio.y ||
            
        );
    }

    executaMoviment(codiTecla) {
        switch(codiTecla) {
            case 37:
                this.mouRectangle(-1, 0);
                break;

            case 38:
                this.mouRectangle(0, -1);
                break;

            case 39:
                this.mouRectangle(1, 0);
                break;

            case 40:
                this.mouRectangle(0, 1);
                break;

            
            
        }
    }
}