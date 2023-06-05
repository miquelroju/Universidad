class Punt{
    constructor(x,y){
        this.y = y;
        this.x = x;
    }
    static distanciaDosPunts(a,b){
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
        
    }
}