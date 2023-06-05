$(function() {

    var arr = new Array(10);
    var sortir = false;
    var i=0;

    while(!sortir) {
        generaNumero();
        sortir = i>9?true:false;
        i++;
    }

    function generaNumero() {
        var numero = Math.round(Math.random()*10);
        $("#numero").append("<div class='numero'>"+numero+"</div>");
        arr[numero]=arr[numero]+1;
    }

    arr.forEach(mostraResum);

    function mostraResum(element, index) {
        $("#resultat").append(`<p> El numero ${index} ha aparegut` + element + "vegades </p>");
    }
     
})
