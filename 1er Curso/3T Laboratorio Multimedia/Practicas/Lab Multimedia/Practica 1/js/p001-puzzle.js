var numFiles = 2;
var numColumnes = 2;
var nomImatge = "img-2";
var extImatge = ".jpg";

// comença el programa
$(document).ready(function(){

    //Esdeveniments de l'usuari
    //Menú inicial
    /**TASCA *****************************
    * Addicional.- codi del menú que permet escollir imatges i/o el número de peces**/

    $("#files").on("change", function(){
        numFiles = document.getElementById("files").value;
    })

    $("#columnes").on("change", function(){
        numColumnes = document.getElementById("columnes").value;
    })

    // No hem sabut seleccionar les imatges perquè fos la imatge amb la que realitzar el puzzle.


    /*****************************************************************/
    
      
   
    //Comença el joc
    $("#jugar").on("click",function(){
        $("#felicitacio").hide(1000);
        creaPuzzle();
        $(".peca")
        .mousedown(function(){
            zIndexPeca = $(this).css("z-index");
            $(this).css("z-index",100);
        })
        .mouseup(function(){
            /**
            * PosicionaPeca calcula la posició correcte i 
            * revisa si la distànca entre la posició actual
            * i la posició correcte és inferior a una 
            * distància determinada
            */           
            posicionaPeca($(this));
            /**
            * puzzleResolt revisa si totes les peces
            * estan a la seva posició correcte i 
            * En cas afirmatiu, mostra la felicitació
            */ 
            if(puzzleResolt()){
                /**TASCA *****************************
                * 6.- Codi que mostra la felicitació si puzzleResolt = true
                * És valora alguna animació o efecte
                */ 

                $("#felicitacio").show(1000);
            }
        });

    });    
    $("#resolPuzzle").on("click",function(){
        /**
        * Si l'usuari fa clic, totes les peces
        * es posicionen a la seva posició correta
        * resolent el puzle
        */ 
        resolPuzzle();
    });

    $("#nouPuzzle").on("click",function(){
        $("#felicitacio").hide(1000);
        creaPuzzle();
        $(".peca")
        .mousedown(function(){
            zIndexPeca = $(this).css("z-index");
            $(this).css("z-index",100);
        })
        .mouseup(function(){
            posicionaPeca($(this));
            if(puzzleResolt()){
                $("#felicitacio").show(1000);
            }
        });
    });    
    $("#resolPuzzle").on("click",function(){
        resolPuzzle();
    });
});

/**
* Calcula les mides de les peces en funció de la mida de la imatge
* i del nombre de files i columnes
* Estableix les mides dels contenidors
*/
function creaPuzzle(){
  
    ampladaPeca = Math.floor($("#p-"+nomImatge).width()/numColumnes);
    alcadaPeca = Math.floor($("#p-"+nomImatge).height()/numFiles);

    $("#peces-puzzle").html(crearPeces());
    $(".peca").css({
        "width" : ampladaPeca+"px",
        "height" : alcadaPeca+"px",
    });   
    
    setImatgePosicioPeces();
   
	$("#marc-puzzle").css("width", (ampladaPeca*numColumnes)+"px");
	$("#marc-puzzle").css("height",( alcadaPeca*numFiles   )+"px");
    $("#solucio").css("width", "100%");
    $("#solucio").css("height","100%");
    $("#solucio").css("background-image","url(imatges/"+nomImatge+ extImatge+")");

    $(".peca").draggable();
     

}

/**
* Crea codi HTML per representar les peces
* amb un sistema d'identificació f0c0, f0c1,...fxcy
*
* @return text (divs html per cada peça)
*/
function crearPeces(){
    var htmlPeces = "";
    for (let fila=0; fila<numFiles; fila++){
        for (let columna=0; columna<numColumnes; columna++){
                htmlPeces +="<div id='f"+fila+"c"+columna+"' class='peca'></div>"; 
        }
        htmlPeces+="\n";
    }   
    return htmlPeces;
}

/**
* Estableix els backgroud de la peça, ajustada a la imatge i 
* a la posició correcte de la peça
* Estableix una posició aleatoria (left, top) per a cada peça. Barreja.
*
*/
function setImatgePosicioPeces(){
    $(".peca").css("background-image","url(imatges/"+nomImatge+ extImatge+")");
    for (let fila=0; fila<numFiles; fila++){
        for (let columna=0; columna<numColumnes; columna++){
            $("#f"+fila+"c"+columna).css("background-position", (-(columna)*ampladaPeca)+"px "+(-(fila)*alcadaPeca)+"px");   
            $("#f"+fila+"c"+columna).css("top", Math.floor(Math.random()*((numColumnes-1)*ampladaPeca))+"px ");
            $("#f"+fila+"c"+columna).css("left", Math.floor(Math.random()*((numFiles-1)*alcadaPeca))+"px ");
            
        }        
   }   

}


/**
* PosicionaPeca calcula la posició correcte i 
* revisa si la distància entre la posició actual
* i la posició correcte és inferior a una 
* distància determinada, utilitzant la funció distanciaDosPunts.
* Si aquesta avaluació és positiva, mou la peça a la posició correcte
*
* @para peca (peça que l'usuari ha alliberat amb el ratolí)
*  
*/   

function posicionaPeca(peca){
   
    let posicioPeca = peca.position();
    let posicioPecaCorrecte;
    let i,j;

    i=parseInt(peca.attr('id').charAt(1));
    j=parseInt(peca.attr('id').charAt(3));
    posicioPecaCorrecte={
        left: j*ampladaPeca,
        top: i*alcadaPeca,
    }
    
    


    /**TASCA *****************************
    * 1.- Identifica la peça pel seu id (fxcy) i en calcula la
    * seva posició correcte  (posicioPecaCorrecte) 
    *  
    */ 

   
    
    if (distanciaDosPunts(posicioPeca, posicioPecaCorrecte)<10){      
        /**TASCA *****************************
        * 2.- Si la distancia és dins del marge determinat
        * mou la peça a la seva posició correcta
        *
        *  La peça ja no és podrà tornar a moure
        *  
        */
        peca.css("top", parseInt(posicioPecaCorrecte.top)+"px ");
        peca.css("left", parseInt(posicioPecaCorrecte.left)+"px ");
        peca.draggable("disable");     
    }

}

/**
* Posa totes les peces al seu lloc correcte
*
* @para 
* @return 
*/
function resolPuzzle(){
    /**TASCA *****************************
    * 4.- Posiciona totes les peces a la 
    * seva posició correcte, resolent el puzle
    *  
    */ 
     for(let i=0;i<numFiles;i++){
        for(let j=0;j<numColumnes;j++){
            $("#f"+i+"c"+j).css("top", alcadaPeca*i+"px ");
            $("#f"+i+"c"+j).css("left", ampladaPeca*j+"px ");
           $("#f"+i+"c"+j).draggable("disable");       
        }
    }

   
}

/*
* Revisa si totes les peces son al seu lloc
*
* @return bool (true si totes les peces son al seu lloc)
*/

function puzzleResolt(){
    /**TASCA *****************************
    * 5.- Revisa totes les peces i les seves posicions actuals i compara
    * aquestes poscions amb les posicions correctes que haurien de tenir
    * En cas que totes les peces siguin a la seva posició 
    * correcte, retorna cert
    *  
    */ 
   let y=0;
   while(y<numFiles){
       let x=0;
       while(x<numColumnes){
       let obj = $("#f" + y + "c" + x).position();
       let topcorrect=alcadaPeca*y;
       let leftcorrect= ampladaPeca*x;

       if(topcorrect != obj.top || leftcorrect != obj.left){
           return false;
       }
       x++;
    }
    y++;

   }
   return true;
	
}

/**
* Calcula la distància entre dos punts
*
* @para puntA, puntB 
* coordenada superior esquerra de la peca (pA) i de la seva posició correcte (pB)
* @return Distancia entre els dos punts en un pla cartesià
*/

function distanciaDosPunts(puntA, puntB){
   /**TASCA *****************************
    * 3.- Reviseu la fórmula de càlcul de distància entre dos punts
    * a la lliçó 5: Col·lisions  dels apunts
    *  
    */    
   return Math.sqrt(Math.pow(puntB.top-puntA.top,2) + Math.pow(puntB.left-puntA.left,2));
   
}