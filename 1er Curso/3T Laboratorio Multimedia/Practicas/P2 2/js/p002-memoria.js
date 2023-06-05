var ampladaCarta, alcadaCarta;
var separacioH=20, separacioV=20;
var nFiles=10, nColumnes=2;

var jocCartes = [
    'carta5', 'carta1', 
    'carta15', 'carta15',
    'carta20', 'carta7',
    'carta14', 'carta2',
    'carta8', 'carta5',
    'carta15', 'carta20',
    'carta1', 'carta5',
    'carta15', 'carta14',
    'carta7', 'carta5',
    'carta2', 'carta8',
];

function creaCartas(){
    var card="";

    for(var fila=1;fila<=nFiles;fila++){
        for(var col=1;col<=nColumnes;col++){
            card+="<div class='carta' id='f"+fila+"c"+col+"'> <div class='cara darrera'</div><div class='cara davant'></div><div>";
        }
        card+="\n";
    }
    return card;
}

function creaParejas(){

    while (i<(nFiles*nColumnes/2)) {
        jocCartes.push(rnd)
        i++;
    }

}

$(function(){
    var f, c, carta;

    ampladaCarta=$(".carta").width(); 
    alcadaCarta=$(".carta").height();
    // mida del tauler
    $("#tauler").css({
        "width" : "1000px",
        "height": "600px"
    });
    // inicialitzem totes les cartes: posició
    for(f=1; f<=nFiles; f++) 
        for(c=1; c<=nColumnes; c++){
            carta=$("#f"+f+"c"+c);
            carta.css({
                "left" :  ((c-1)*(ampladaCarta+separacioH)+separacioH)+"px",
                "top"  :  ((f-1)*(alcadaCarta+separacioV) +separacioV)+"px"
            });
            carta.find(".davant").addClass(jocCartes.pop());
           
        }

    $(".carta").click(function(){
        $(this).toggleClass("carta-girada");

        // Guardo en un array todas las cartas giradas
        var cartas = document.querySelectorAll(".carta-girada");

        // Si el array tiene dos carts
        if (cartas.length === 2) {
            // Miro que las primeras tres letras de la id de las dos cartas sean iguales
            if (cartas[0].id.substring(0, 3) === cartas[1].id.substring(0, 3)) {
                // Si coincide hago delay para que tarden medio segundo en ocultarse i luego las elimino
                $(".carta-girada").delay(500).hide(400).delay(500).queue(function() { $(this).remove(); });
            } else {
                // Si no coincide hago delay para que tarden medio segundo en girarse
                $(".carta-girada").delay(500).queue(function() { $(this).toggleClass("carta-girada"); });
            }
        }
    });


});