class Joc{
    constructor(canvas, ctx){
        this.canvas = canvas;
        this.ctx = ctx;
        this.rectangle = new Rectangle(
            new Punt((canvas.width/2)-5,(canvas.height/2)-5),
            10,10);
        this.setColor = "#000";


        //2*************
        this.rectangleFix = new Rectangle(
            new Punt(10,10),
            30,30
        )
        this.rectangleFix.setColor = "#333";
    }

    set setVelocitat(velocitat){
        this.velocitat = velocitat;
    }

    dibuixa(){
        this.rectangleFix.dibuixa(this.ctx);
        this.rectangle.dibuixa(this.ctx);
    }

    mouRectangle(x,y){
        this.clearCanvas();
        this.rectangle.mou (
            x * this.velocitat,
            y * this.velocitat)
        this.rectangle.dibuixa(this.ctx);


        if (this.colisioRectangles()){
            this.rectangle.setColor = "#F00";
        }else{
           this.rectangle.setColor = "#000";
        }
        this.dibuixa();
        
   }

   colisioRectangles(){
       return !(
           this.rectangle.posicio.x + this.rectangle.amplada < this.rectangleFix.posicio.x ||
           this.rectangle.posicio.x > this.rectangleFix.posicio.x + this.rectangleFix.amplada ||
           this.rectangle.posicio.y + this.rectangle.alcada < this.rectangleFix.posicio.y ||
           this.rectangle.posicio.y > this.rectangleFix.posicio.y + this.rectangleFix.alcada)
           
   }

    executaMoviment(codiTecla){
        switch (codiTecla){
            case 37:
                this.mouRectangle(-1,0);
                break;
            case 38:
                this.mouRectangle(0,-1);
                break;
            case 39:
                this.mouRectangle(1,0);
                break;
            case 40:
                this.mouRectangle(0,1);
                break;
        }
    }

    clearCanvas(){
        this.ctx.clearRect(0,0, this.canvas.width, this.canvas.height)
    }

    
}