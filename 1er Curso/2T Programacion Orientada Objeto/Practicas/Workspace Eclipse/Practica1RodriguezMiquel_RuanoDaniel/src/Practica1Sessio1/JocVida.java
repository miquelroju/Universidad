package Practica1Sessio1;
import Keyboard.*;
import java.util.Random;

public class JocVida {
	
	private static int coincidencies(int buscar, int[] taula) {
		int trobats=0;
		for(int i=0; i<taula.length; i++) {
			if(buscar==taula[i]) trobats++;
		}
		
		return trobats;
	}
	
	private static boolean extincio(boolean[][] taulell) {
		for(int y=0;y<taulell.length; y++) {
			for(int x=0; x<taulell[y].length; x++) {
				if (taulell[y][x]) return false;
			}
		}
		return true;
	}
	
	private static void imprimirTaulell(boolean[][] taulell) {
		for(int y=0;y<taulell.length; y++) {
			for(int x=0; x<taulell[y].length; x++) {
				if (taulell[y][x]) System.out.print('■');
				else System.out.print('□');
				
				System.out.print(' ');
			}
			System.out.println("");
		}
	}
	
	private static int quantsVeins(boolean[][] taulell, int coordenades1, int coordenades2) {
		// coordenades: [0]=X , [1]=Y
		int veins=0;
		for(int y=-1; y<=1; y++) {
			// comprovar que Y estigui dintre de la array
			if (coordenades1+y>=0 && (coordenades1+y)<taulell.length) {
				for(int x=-1; x<=1; x++) {
					if ( !(x==0 && y==0) ) {
						// comprovar que X estigui dintre de la array
						if (coordenades2+x>=0 && (coordenades2+x)<taulell[0].length) {
						
							if (taulell[coordenades1+y][coordenades2+x]) veins++;
						}
					}
				}
			}
		}
		
		return veins;
	}
	
	private static int updateAux(int veins,int coordenades1, int coordenades2, boolean casella, boolean[][] aux) {
		if (veins==2) aux[coordenades1][coordenades2]=casella;
		else if (veins==3) aux[coordenades1][coordenades2]=true;
		// death = default
		
		if (aux[coordenades1][coordenades2]) 
			return 1;
		
		return 0;
	}
	
	private static int demanarInt(String msg, int min, int max) {
		int triat=min-1;
		while(triat>max || triat<min) {
			System.out.print(msg+" ["+min+","+max+"]: ");
			triat=Keyboard.readInt();
		}
		
		return triat;
	}
	
	public static void main(String args[]) {
		
		boolean acabar = false;
		int partides=1;
		
		int dimensio1=demanarInt("Indica la dimensio X del taulell",5,15);
		int dimensio2=demanarInt("Indica la dimensio Y del taulell",5,15);
		System.out.println("");
		int organismes=demanarInt("Indica el num. d'organismes",1,dimensio1*dimensio2);
		
		while (!acabar) {
		
		int rand_x;
		int rand_y;
		
		Random r = new Random();
		
		rand_x = r.nextInt(dimensio1);
		rand_y = r.nextInt(dimensio2);
		
		boolean joc[][]=new boolean[dimensio2][dimensio1];
		for(int i=0; i<organismes; i++) {
			
			while(joc[rand_y][rand_x]) {
				rand_x = r.nextInt(dimensio1);
				rand_y = r.nextInt(dimensio2);
			}
			

			
			System.out.println("Organisme "+(i+1)+": "+rand_x+", "+rand_y);
			joc[rand_y][rand_x]=true;
		}
		
		System.out.println("\nTaulell inicial: ");
		imprimirTaulell(joc);
		System.out.println("");
		
		int generacions_totals=demanarInt("Indica el num. de generacions",1,10);		

		int[] resums_generacions=new int[generacions_totals];
		int gen=0;
		while(gen<generacions_totals && !extincio(joc)) {
			int organismes_vius=0;
			boolean aux[][]=new boolean[dimensio2][dimensio1];
			for(int y=0;y<joc.length; y++) {
				for(int x=0; x<joc[y].length; x++) {
					
					
					int veins=quantsVeins(joc, y, x);
					boolean casella=joc[y][x];
					
					organismes_vius+=updateAux(veins, y, x,casella,aux);
				}
			}
			joc=aux;
			
			System.out.println("----------------------------------");
			System.out.println("Gen: "+(gen+1)+"\n");
			
			imprimirTaulell(joc);
			
			System.out.println("");
			
			resums_generacions[gen]=organismes_vius;
			gen++;
		}
		
		if (extincio(joc)) {
			System.out.println("Tots els organismes han mort.");
			System.out.print("Vols tornar a jugar? (S/N): ");
			char decisio = Keyboard.readChar();
			System.out.println("");
			if (decisio == 'N' || decisio == 'n') {
				System.out.print("Has jugat " + partides + " partides");
				acabar = true;
			}
			else {
				partides++;
			}
		} else {
			
			for(int i=0; i<generacions_totals; i++) {
				System.out.println("Gen. "+(i+1)+": "+resums_generacions[i]+" organismes vius.");
			}
			
			int cnt=0;
			boolean found=false;
						
			
			while(cnt==0 && !found) {
				int search=resums_generacions[cnt];
				
				int nums=0;
				for(int u=0; u<generacions_totals; u++) {
					if (search==resums_generacions[u]) 
						nums++;
					
					if(nums>2)
						found=true;
					
				}
				cnt++;
			}
			if (found) {
				System.out.println("Hi ha mes d'una repeticio. Com per exemple la gen. "+cnt);
			}
			
			System.out.println("Vols tornar a jugar? (S/N): ");
			char decisio = Keyboard.readChar();
			System.out.println("");
			if (decisio == 'N' || decisio == 'n') {
				System.out.print("Has jugat " + partides + " partides");
				acabar = true;
			} else {
				partides++;
			}
			
		}
			
			
		}
	}
}
