$(document).ready(function () {

    let myCanvas = document.getElementById("joc");
    let ctx = myCanvas.getContext("2d");
    nivell = -1;
    console.log(nivell);
    $(".nivel").click(function () {
        let nivell = $(this).attr("id");
        // $(".nivel").removeClass("btactiu");
        // $("#" + nivell).addClass("btactiu");
        if (nivell == "menu1") nivell = 0;
        else if (nivell == "menu2") nivell = 1;
        else if (nivell == "menu3") nivell = 2;
        else if (nivell == "menu4") nivell = 3;
        else nivell = 4;
console.log(nivell);
        $("#inici").hide();
        $("#principal").show();
        joc = new Joc(myCanvas, ctx, nivell);
        joc.velocitat = 1;
        joc.inicialitza();

    });


    // joc = new Joc(myCanvas, ctx, nivell);
    // joc.velocitat = 1;
    // joc.inicialitza();






});
// function agafarNivell(nivell){
//     if (nivell == "menu1") nivell = 0;
//     else if (nivell == "menu2") nivell = 1;
//     else if (nivell == "menu3") nivell = 2;
//     else if (nivell == "menu4") nivell = 3;
//     else nivell = 4;   

//     return nivell;
// }

function animacio() {
    joc.update();
    requestAnimationFrame(animacio);
}