$(function() {
    let myCanvas  = $("canvas");
    let ctx = myCanvas[0].getContext("2d");

    let centre = new Punt (50,20);

    let cercle = new Cercle (centre, 10);

    cercle.draw(ctx);

    let linia = new Linia (
        new Punt (100, 50),
        new Punt (200, 200)
    );

    linia.draw(ctx);
})