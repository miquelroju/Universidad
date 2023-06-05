var ampladaCarta, alcadaCarta;
var separacioH = 20, separacioV = 20;
var nFiles = 4, nColumnes = 4; //Almenos uno de los dos tiene que ser parell

var jocCartes = new Array(nFiles * nColumnes);

$(function () {
    var f, c, carta, cont;

    //ampladaCarta=$(".carta").width(); 
    //alcadaCarta=$(".carta").height();

    ampladaCarta = 80;
    alcadaCarta = 120;

    // mida del tauler
    $("#tauler").css({
        "width": (separacioH + nColumnes * (ampladaCarta + separacioH)) + "px",
        "height": (separacioV + nFiles * (alcadaCarta + separacioV)) + "px"
    });

    // inicialitzem totes les cartes: posició
    cont = 0;

    for (f = 1; f <= nFiles; f++) {
        for (c = 1; c <= nColumnes; c++) {

            let mig = jocCartes.length;
            let n = Math.floor((Math.random() * 51) + 1);
            let carta = "carta" + n;

            if (cont < mig) {
                jocCartes[cont] = carta;
                jocCartes[cont + mig] = carta;
                cont++;
            }

            $("#tauler").append("<div class='carta' id='f" + f + "c" + c + "'> <div class='cara darrera'></div><div class='cara davant'></div>    </div>");

            $("#f" + f + "c" + c).css({
                "left": ((c - 1) * (ampladaCarta + separacioH) + separacioH) + "px",
                "top": ((f - 1) * (alcadaCarta + separacioV) + separacioV) + "px",
            });

            $("#f" + f + "c" + c).data("carta", carta);
            $("#f" + f + "c" + c).find(".davant").addClass(jocCartes.pop());

        }
    }

    $(".carta").click(function () {
        $(this).toggleClass("carta-girada");
    });

});