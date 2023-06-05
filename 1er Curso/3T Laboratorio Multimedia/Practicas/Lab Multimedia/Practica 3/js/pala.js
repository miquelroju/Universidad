class Pala {
    constructor(puntPosicio, amplada, alcada){      
        this.amplada = amplada;
        this.alcada = alcada;
        this.posicio = puntPosicio;
        this.vy = 2;     
        this.vx = 2;               
        this.color = "#fbb"; 
    }


    update(){
        if(joc.key.RIGHT.pressed){
            this.posicio.x = Math.min( joc.amplada -this.amplada,
                this.posicio.x + this.vx)
        }else
        if(joc.key.LEFT.pressed){
            this.posicio.x = Math.max(0, this.posicio.x - this.vx);
        }
    }

      
    draw(ctx) {
        ctx.save();
        ctx.fillStyle = this.color;
        ctx.fillRect(this.posicio.x, this.posicio.y, this.amplada, this.alcada);
        ctx.restore();

    }
    mou(x,y){
        this.posicio.x += x;
        this.posicio.y += y;
    }
}