/*
var ampladaCarta, alcadaCarta;
var separacioH=20, separacioV=20;
var nFiles=2, nColumnes=2;

var lectura = 0;

var jocCartes = [
    'carta5', 'carta5',
    'carta15', 'carta15',

];

$(document).ready(function() {

    crearTaulell();

    $(".carta").click(function(){
        $(this).toggleClass("carta-girada");
        lectura++;
    });

    if (lectura = 1) {
        
    }

/*
    if (lectura % 2 != 0) {

    }
*/ /*
});

function crearTaulell () {

    var f, c, carta;

    ampladaCarta=$(".carta").width(); 
    alcadaCarta=$(".carta").height();
    // mida del tauler
    $("#tauler").css({
        "width" : "220px",
        "height": "300px"
    });

    // inicialitzem totes les cartes: posició

    for(f=1; f<=nFiles; f++) {
        for(c=1; c<=nColumnes; c++){
            carta=$("#f"+f+"c"+c);
            carta.css({
                "left" :  ((c-1)*(ampladaCarta+separacioH)+separacioH)+"px",
                "top"  :  ((f-1)*(alcadaCarta+separacioV) +separacioV)+"px"
            });
            carta.find(".davant").addClass(jocCartes.pop());
           
        }
    }
        


};


*/

// CODI NOU PER PROVAR

let icones;

generarTauler();

function carregarIcones() {
    cartes = [
        '<i class = ".carta1"></i>',
        '<i class = ".carta2"></i>',
        '<i class = ".carta3"></i>',
        '<i class = ".carta4"></i>',
        '<i class = ".carta5"></i>',
        '<i class = ".carta6"></i>',
        '<i class = ".carta7"></i>',
        '<i class = ".carta8"></i>',
        '<i class = ".carta9"></i>',
        '<i class = ".carta10"></i>',
        '<i class = ".carta11"></i>',
        '<i class = ".carta12"></i>',
    ]
}

function generarTauler() {
    carregarIcones();
    seleccio=[];
    let tauler = document.getElementById("tauler");
    let cartes = [];
    for (let i = 0; i < 24; i++) {
        cartes.push(`
            <div class="area-carta" onclick="seleccionarCarta(${i})>
                <div class="carta" id="carta${i}">
                    <div class="carta_darrera" id="darrera${i}">
                    ${cartes[0]}
                    </div>
                    <div class="carta_davant">
                    </div>
                </div>
            </div>
        `)
        if (i % 2 == 1) {
            cartes.splice(0,1);
        }
    }
    cartes.sort(()=>Math.random() - 0.5)
    tauler.innerHTML = cartes.join(" ");

}

let seleccio = [];

function seleccionarCarta(i) {
    let carta = document.getElementById("carta"+i);
    seleccio.push(i);
    if (seleccio.length == 2) {
        deseleccionar(seleccio)
        seleccio = []
    }

}

function deseleccionar (seleccio) {
    setTimeout(() => {
        let darrera1 = document.getElementById("darrera" + seleccio[0]);
        let darrera2 = document.getElementById("darrera" + seleccio[1]);
        if (darrera1.innerHTML != darrera2.innerHTML) {
            let c1 = document.getElementById("carta" + seleccio[0]);
            let c2 = document.getElementById("carta" + seleccio[1]);
            c1.style.transform = "rotateY(0deg)";
            c2.style.transform = "rotateY(0deg)";
        } else {
            c1.hide(400);
            c2.hide(400);
        }
    }, 1000);
}