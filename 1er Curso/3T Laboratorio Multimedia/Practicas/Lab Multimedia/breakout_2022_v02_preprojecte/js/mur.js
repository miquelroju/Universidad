class mur {

    constructor(nivell) {//de momento ningun parametro, cuando tengamos niveles pues el nivel para escoger array para dibujar
        this.indexNivell = nivell;
        this.totxos = new Array();
        this.defineixNivells();

    }

    defineixNivells() { 

        this.nivell = [
            {
                estat: 1,
                color: "#4CF",//blau cel
                totxos: [
                    "aaaaa",
                    "aa aa",
                    "aaaaa",
                    "aa aa",
                ]
            },
            {
                estat: 1,
                color:"#4FC",
                totxos:[
                    "a a a",
                    " a a ",
                    "a a a",
                    " a a ",
                ]

            },
            {
                color:"red",
                totxos: [
                    "aaaaaa  aa",
                    "    aa  aa",
                    "aaaaaaaaaa",
                    "aa  aa    ",
                    "aa  aaaaaa",
                ]
            },
            {
                color: "#4bbd26",
                totxos: [
                    " aaaaaaaa ",
                    "aa aaaa aa",
                    "aaaaaaaaaa",
                    " aaaaaaaa ",
                    " a      a ",
                ]
            },
            {
                color: "#8f26bd",
                totxos: [
                    "a aa  aa a",
                    " a  aa  a ",
                    "  aa  aa  ",
                    "    aa    ",
                    "aaa    aaa",
                ]
                
            }

        ]
    }
    
    ferTotxo() {
        var X = 10, Y = 10;
        var amplada = 48, alcada = 20; //queda decidir
        var separacioX = 10, separacioY = 5; //falta
        var filaBucle = this.nivell[this.indexNivell].totxos;

        for (let i = 0; i < filaBucle.length; i++) { //this.nivell.length=1
            for (let col = 0; col < filaBucle[i].length; col++) {

                if (filaBucle[i].charAt(col) == 'a') {
                    this.totxos.push(new Totxo(new Punt(X, Y), amplada, alcada, this.nivell[this.indexNivell].color));                   
                } // la alcada es multiplica per i, la amplada per col
                X += amplada + separacioX;

            }
            X = 10;
            Y += alcada + separacioY;
        }       
    }
    dibuixa(ctx) {
        for (let i = 0; i < this.totxos.length; i++) {
            if (this.nivell[this.indexNivell].estat == 1) {
                this.totxos[i].draw(ctx);
            }
        }
        
    }
}