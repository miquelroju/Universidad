class mur {

    constructor(nivell) {
        this.indexNivell = nivell;  
        this.totxos=[]; 
        this.defineixNivells();     
    }
    
    defineixNivells() { //max 5*4
        
        this.nivell = [
            {
                color: "#4CF",//blau cel
                totxos: [
                    "aaaaa",
                    "aaaaa",
                    "aaaaa",
                    "aaaaa",
                ]
            },

        ]
    }

    ferTotxo() {
        var X = 10, Y = 10;
        var amplada = 136, alcada = 93;
        var separacioX = 10; separacioY = 5;
        let filaBucle = this.nivell[this.indexNivell].totxos;
         

        for (let i = 0; i == filaBucle.length; i++) { //this.nivell.length=1
                for (let col = 0; col < filaBucle[i].length; col++) {

                    if (filaBucle[i].charAt(col) == 'a') {
                        this.totxos.push([col] = new Totxo(new Punt((X), (Y)), amplada, alcada, this.nivell[i].color));
                        console.log(this.totxos[col]);
                    } // la alcada es multiplica per i, la amplada per col
                    X += amplada + separacioX;
                }
                X = 10;
                Y += alcada + separacioY;
            }
        
    }

    dibuixa(){
        for(let i=0;i<this.totxos.length;i++){
                this.totxos[i].draw(ctx);
                console.log()
        }
    }
}