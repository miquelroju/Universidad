package Practica1Sessio2;
import java.util.Random;

public class Taulell {
	
	private boolean [][] taulell;
	private int files;
	private int columnes;
	private int vius;
	
	public Taulell (int files, int columnes) {
		this.files = files;
		this.columnes = columnes;
		this.taulell = new boolean [files][columnes];
		treureVida();
	}
	
	public void treureVida() {
		for(int i=0; i<this.files; i++) {
			for(int j=0; j<this.columnes; j++) {
				this.taulell[i][j] = false;
			}
		}
		this.vius=0;
	}
	
	public void posarVida(int N) {
		Random r = new Random();
		for (int i=0; i<N; i++) {
			int rand_fil, rand_col;
			do {
				rand_fil = r.nextInt(taulell.length);
				rand_col = r.nextInt(taulell[0].length);
			} while (taulell[rand_fil][rand_col] == true);
			
			System.out.println("Organisme " + (i+1) + " a la posició. : " + rand_fil + ", " + rand_col);
			this.taulell[rand_fil][rand_col] = true;
		}
	}
	
	public void mostraTaulell() {
		for(int x=0;x<this.files; x++) {
			for(int y=0; y<this.columnes; y++) {
				if (taulell[x][y]) {
					System.out.print('◼');
				}
				else {
					System.out.print('◻');
				}
				System.out.print(' ');
			}
			System.out.println("");
		}
	}

	public boolean ferGeneracio() {
		this.vius=0;
		boolean taulellAux[][];
		boolean diferent = false;
		taulellAux = copiar(this.taulell);
				for(int i=0; i<taulellAux.length; i++) {
					for(int j=0; j<taulellAux[0].length; j++) {
						if(taulellAux[i][j] == false && quantesVeines(i,j) == 3) {
							taulellAux[i][j] = true;
						} else if(taulellAux[i][j] == true) {
							if(quantesVeines(i,j) >= 4) {
								taulellAux[i][j] = false;
								this.vius--;
							} else if(quantesVeines(i,j) <= 1) {
								taulellAux[i][j] = false;
								this.vius--;
							}
						}
						if(taulellAux[i][j] != this.taulell[i][j]) {
							diferent = true;
						}
						if(taulellAux[i][j] == true) {
							this.vius++;
						}
					}
				}
				this.taulell = copiar(taulellAux);
				if(diferent == true) {
					return true;
				} else {
					return false;
				}
	}
	
	private int quantesVeines(int fil, int col) {
		int veins=0;
		for(int x=-1; x<=1; x++) {
			if (fil+x>=0 && (fil+x)<this.taulell.length) {
				for(int y=-1; y<=1; y++) {
					if ( !(y==0 && x==0) ) {
						if (col+y>=0 && (col+y)<this.taulell[0].length) {
							if (taulell[fil+x][col+y]) veins++;
						}
					}
				}
			}
		}
		return veins;
	}
	
	private boolean[][] copiar(boolean [][] origen) {
		boolean [][] taulellAux;
		taulellAux = origen;
		for(int i=0; i<this.files; i++) {
			for(int j=0; j<this.columnes; j++) {
				taulellAux[i][j] = origen[i][j];
			}
		}
		return taulellAux;
	}
	
	public boolean[][] getTaulell() {return this.taulell;}
	
	public int getFiles() {return this.files;}
	
	public int getColumnes() {return this.columnes;}
	
	public int getVius() {return this.vius;}

}
