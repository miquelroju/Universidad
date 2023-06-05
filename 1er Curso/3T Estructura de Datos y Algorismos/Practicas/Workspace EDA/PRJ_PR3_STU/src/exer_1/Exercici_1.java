	package exer_1;
	
	import java.util.*;
	
	public class Exercici_1 {
		
		/* Punt d'entrada en execuci� per a fer proves */
		public static void main (String [] args) {
			Random alea = new Random();
			int original, resultat;
			String cadena;
			
			for (original = 0; original<=1000; original++) {
				cadena = Integer.toString(original);
				resultat = conversio(cadena); /* Invoqueu aqu� la vostra funci� de conversi� */
				if (original!=resultat) {
					System.out.println("Error. String era: "+cadena+" resultat ha estat: "+resultat);
				}
			}
			
			for (int i=1; i<=100000; i++) {
				original = alea.nextInt(Integer.MAX_VALUE);
				cadena = Integer.toString(original);
				resultat = conversio(cadena); /* Invoqueu aqu� la vostra funci� de conversi� */
				if(original == resultat) {
					System.out.println("correcte");
				}
				if (original!=resultat) {
					System.out.println("Error. String era: "+cadena+" resultat ha estat: "+resultat);
				}
			}
		}
		
		
		
		/* ESCRIVIU AQU� LA VOSTRA FUNCI� DE CONVERSI� String -> int */ 
		
		private static int conversioIteratiu (String cadena) {
			int res = 0;
			for (int i = 0; i < cadena.length(); i++) {
				res += translateChar(cadena.charAt(i)) * (int)Math.pow(10, (cadena.length() - i - 1));
			}
			return res;
		}
		
		private static int conversioRecursiu (String cadena) {
			// el professor agafava l'string, agafava els numeros d'un en un, del principi al final
			// multiplica el nombre per 10 i suma el current numero
			// 123, en el cas del numero 1 multiplicaria res per 0 mes 1, en el cas del 2 multiplicaria 1 * 10 + 2 = 12,
			// en el cas del numero 3 multiplicaria 12 * 10 + 3 = 123
		}
		
		
		/* funci� que "transforma" un car�cter en el d�git (int) corresponent */
		private static int translateChar (char c) {
			switch (c) {
			case '0': return 0;
			case '1': return 1;
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;
			default: throw new IllegalArgumentException("Not a digit "+c);
			}
		}
	
	}
