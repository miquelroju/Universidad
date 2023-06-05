package exercici_08_09_CompteCorrent;

public class UsCorrent {
	
	private static boolean traspassar (CompteCorrent or, CompteCorrent des, double quant ) {
		
		boolean vaBe;
		
		vaBe = or.retirar(quant);
		if (vaBe) {
			des.ingressar(quant);
		}
		
		return vaBe;
		
	}
	
	private static CompteCorrent compteAmbMesSaldo
	(CompteCorrent a, CompteCorrent b, CompteCorrent c) {
		
		double saldoA, saldoB, saldoC;
		
		saldoA = a.getSaldo();
		saldoB = b.getSaldo();
		saldoC = c.getSaldo();
		
		if (saldoA >= saldoB && saldoA >= saldoC) {
			return a;
		}
		
		else {
			if (saldoB >= saldoC) {
				return b;
			}
			else {
				return c;
			}
		}
	}
	
	private static void escriureCompte (CompteCorrent c) {
		System.out.print("Número: "); System.out.print(c.getNumero());
		System.out.print(" Titular: "); System.out.print(c.getTitular());
		System.out.print(" Saldo: "); System.out.print(c.getSaldo());
		System.out.println("---");
	}
	
	public static void main(String[] args) {
		
	}

}
