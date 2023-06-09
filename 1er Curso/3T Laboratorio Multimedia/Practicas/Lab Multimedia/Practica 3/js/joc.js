class Joc{
    constructor(canvas,ctx) {
        this.canvas = canvas;
        this.ctx = ctx;
        this.amplada = canvas.width;
        this.alcada = canvas.height;
        this.totxoamplada = 75;
        this.totxoalcada = 20; // MIDES DEL TOTXO EN PÍXELS
        this.totxocolor = "#0ad";

        this.bola = new Bola(new Punt(this.canvas.width/2,this.canvas.height/2),3);
        this.pala = new Pala(new Punt((this.canvas.width-60)/2,this.canvas.height-15),60,4);
        this.totxo = new Totxo(new Punt((this.canvas.width-120)/2,(this.canvas.height-20)/3), 120, 20, "#0ad");  // només posem un totxo gegant, per veure els xocs
       

        this.key = {
            LEFT:{code:37, pressed:false},
            RIGHT:{code:39, pressed:false}
        };
       

      
    }

    draw(){
        this.clearCanvas();
        this.pala.draw(this.ctx);
        this.bola.draw(this.ctx);
        this.totxo.draw(this.ctx);


    }
    clearCanvas(){
        this.ctx.clearRect(0,0,this.canvas.width, this.canvas.height)
    }

    inicialitza(){

        this.pala.draw(this.ctx);
        $(document).on("keydown",{joc:this}, function(e){
            if(e.keyCode == e.data.joc.key.LEFT.code){
                e.data.joc.key.LEFT.pressed = true;
            }
            else if(e.keyCode == e.data.joc.key.RIGHT.code){
                e.data.joc.key.RIGHT.pressed = true;
            }
        });
        $(document).on("keyup", {joc:this}, function(e){
            if(e.keyCode == e.data.joc.key.RIGHT.code){
                e.data.joc.key.RIGHT.pressed = false;
            }
            else if(e.keyCode == e.data.joc.key.LEFT.code){
                e.data.joc.key.LEFT.pressed = false;
            }
        });


        requestAnimationFrame(animacio);
    }

    update(){
        this.bola.update();
        this.pala.update();
        this.totxo.draw(this.ctx);
        this.draw();

    }
}