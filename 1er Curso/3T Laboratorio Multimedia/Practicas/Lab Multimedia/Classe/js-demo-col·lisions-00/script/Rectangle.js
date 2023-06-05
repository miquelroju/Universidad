class Rectangle extends Figura{
        constructor(puntPosicio, amplada, alcada){
            super(puntPosicio);
            this.amplada = amplada;
            this.alcada = alcada;
            
        }
        set setColor(color){
            this.color = color;
        }

        get getArea(){
            return this.amplada * this.alcada;
        }

        dibuixa(ctx){
            ctx.fillStyle = this.color;
            ctx.fillRect(this.posicio.x, this.posicio.y, 
                this.amplada, this.alcada);
        }

        mou(x,y) {
            this.posicio.x += x;
            this.posicio.y += y;
        }
             


}