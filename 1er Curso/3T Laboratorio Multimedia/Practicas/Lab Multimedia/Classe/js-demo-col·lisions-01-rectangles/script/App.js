$(function(){

    let myCanvas = document.getElementById("canvaJoc");
    let myCtx =  myCanvas.getContext("2d");
    let joc = new Joc(myCanvas, myCtx);
    joc.dibuixa();
    joc.setVelocitat = 5;

    document.addEventListener('keydown', moviment);

    function moviment(e){
        joc.executaMoviment(e.keyCode);
    }


})