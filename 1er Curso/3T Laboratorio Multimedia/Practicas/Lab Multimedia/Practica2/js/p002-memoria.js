var ampladaCarta, alcadaCarta;
var separacioH = 20,
  separacioV = 20;
var nFiles = 2,
  nColumnes = 2,
  clicks = 0,
  primeraCarta;

var jocCartes = ["carta5", "carta5", "carta15", "carta15"];

$(function () {
  var f, c, carta;

  ampladaCarta = $(".carta").width();
  alcadaCarta = $(".carta").height();
  // mida del tauler
  $("#tauler").css({
    width: "220px",
    height: "300px",
  });
  // inicialitzem totes les cartes: posició
  for (f = 1; f <= nFiles; f++)
    for (c = 1; c <= nColumnes; c++) {
      carta = $("#f" + f + "c" + c);
      carta.css({
        left: (c - 1) * (ampladaCarta + separacioH) + separacioH + "px",
        top: (f - 1) * (alcadaCarta + separacioV) + separacioV + "px",
      });
      carta.find(".davant").addClass(jocCartes.pop());
    }

  $(".carta").click(function () {
    $(this).toggleClass("carta-girada");
    clicks++;

    if (clicks == 1) {
        primeraCarta=$(this).attr("id");
        $(this).data("class", primeraCarta); //set
        primeraCarta = $(this).data("class") // get

     }
     if(clicks==2){
         var segonaCarta=$(this).attr("id");
         $(this).data("class", segonaCarta); //set
         segonaCarta = $(this).data("class") // get
     }else if (primeraCarta==segonaCarta) {
         //$(primeraCarta).attr("davant");
         //$(segonaCarta).attr("davant");
         $(primeraCarta).hide(400);
         $(segonaCarta).hide(400);

         clicks=0;
     }else{
         $(primeraCarta).attr("darrera");
         $(segonaCarta).attr("darrera");
         clicks=0;
     }
});
});

