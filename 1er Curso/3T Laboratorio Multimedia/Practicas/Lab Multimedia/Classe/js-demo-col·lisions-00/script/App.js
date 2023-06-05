$(function() {

    let myCanva = document.getElementById("canvaJoc");
    let myCtx = myCanva.getContext("2d");

    let joc = new Joc (myCanva, myCtx);
    joc.dibuixa();

    document.addEventListener("keydown", moviment);

    function moviment(e) {
        joc.executaMoviment(e.keyCode);
    }

});
