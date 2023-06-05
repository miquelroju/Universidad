package llistes;
import java.util.Scanner;

public class Teclat {

	    private Scanner inputReader;
	    
	    public Teclat() {
	        inputReader = new Scanner(System.in);
	    }
	
	    /**
	     * @param opcions string: string amb les lletres de cada opcio
	     * @param desc string
	     *  
	     * exemple Llegir_opcions("lre","l:login, r:registrarse, e:end");
	     * @return
	     */
	 
	    public String Llegir_opcions(String opcions, String desc)
	    {
	        String command="x";
	        String error="";
	        while (!command.matches("["+opcions+"]")){
	        System.out.println(error+"Opcions:: "+desc );
	        String input = inputReader.nextLine();
	        command=input.substring(0, 1);
	        error="Entrada incorrecte. ";
	        }
	        return command;
	    }
	    
	    /**
	     * @param sols
	     * @param string
	     * @return
	     */
	    public String escull_opcions(String op, String string)
	    {
	        String command="x";
	        String error="";
	        if (op=="")return null;
	        String[] ops=op.split(",");
	        int numOps=ops.length;
	        int val=-1;
	        while (!command.matches("[0-9]+") || !(val<=numOps) || val == -1){
	            for (int j=0;j<numOps;j++){
	                System.out.print("\t"+(j+1)+": "+ops[j]);
	            }
	            System.out.println();
	            System.out.println(error+"Introdueix la opció que vols  de 1 a "+numOps+" o 0 per acabar" );
	            command = inputReader.nextLine();
	            error="Entrada incorrecte. ";
	            val=Integer.valueOf(command);
	        }
	        if (val==0) return null;
	        System.out.println(val+":"+ ops[val-1]);
	        return ops[val-1];
	   }	    

	    
	    /**
	     * Llegim un int 
	     * @param int max: valor màxim admisible
	     * @return
	     */
	    public int llegirInt(int max, String desc)
	    {
	    	return llegirInt(max,desc,0); // minim per defecte 
	   }

		public int llegirInt(int max, String desc, int min) {
	        String command="x";
	        int val=-1;
	        String error="";
	        System.out.println(desc );
	        while (!command.matches("[0-9]+") || !(val<max+min && val >= min) ) {
	            System.out.println(error+"Introdueix un enter de "+ min +" a "+ (max-1+min) );
	            command = inputReader.nextLine();
	            error="Entrada incorrecte. ";
	            try {
	            	val=Integer.valueOf(command);
	            } catch (Exception e) {
	            	error="Valor numeric no vàlid.";
				}
	            
	        }
	        return val;
		}	    
	    
}
