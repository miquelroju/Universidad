/**
 * 
 */
package llistes;

import llistes.ArrayListEDA_B.Iterador;

/**
 * @author joan
 *
 */
public class Cua<Cosa> {

	// Classe per definir el node
	private class Node {
		public Cosa dada;
		public Node següent;
	}

	private Node cap, cua;
	private int mida; // nombre de nodes

	// Zero argument constructor
	public Cua() {
		cap = null;
		cua = null;
		mida = 0;
	}

	// afegim una nova dada a al final de la llista
	public void enqueue(Cosa dada) {
		Node nou = new Node();
		nou.dada = dada;

		if (mida == 0) {
			cap = nou;
		} else {
			cua.següent = nou;
		}
		cua = nou;
		mida++;
	}

	public int size() {
		return mida;
	}

	public boolean isEmpty() {
		return (mida == 0);
	}

	// Elimina el primer element de la llista.
	public Cosa dequeue() {
		Cosa valor;
		if (mida == 0) {
			return null;
		} else if (mida == 1) {
			valor = cap.dada;
			cap = null;
			cua = null;
			mida--;
		} else {
			cap = cap.següent;
			mida--;
		}

		return null;
	}

	// si ho mirem con una llista
	public void add(Cosa data) {
		enqueue(data);
	}

	// afegir a una posició concreta (no al final)

	// si ho mirem con una llista
	public void add(int index, Cosa dada) {
		Node nou = new Node();
		// si index > mida -> error
		// si index == mida.... enqueue
		// si index == 0 l'he de posar a l'inici
		// si eindex < mida... hem de buscar on posar-lo
		if (index > mida) {
			throw new IndexOutOfBoundsException();
		}
		if (index == mida) {
			enqueue(dada);
		}
		if (index == 0) {
			nou.dada = dada;
			nou.següent = cap;
			cap = nou;
			mida++;
		} else {
			Node prev = cap;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.següent;
			}
			nou.següent = prev.següent;
			prev.següent = nou;
		}
		mida++;
	}

	// si ho mirem con una llista
	public Cosa get(int index) {
		
	}

	/**
	 * volem saber si hi ha un element i si hi és que ens el torni. Cal que en el
	 * torni? si i és ja no cal no? si, perquè és un element que té es igual (amb el
	 * que això vulgui dir... però no és el mateix, ni totes les parts són iguals)
	 * cal que en el torni? si i és ja no cal no? si, perquè és un element que té
	 * 
	 * @param elem : element a buscar
	 * @return Element trobat o null si no hi és
	 */

	public Cosa troba(Cosa elem) {
		return null;
	}

	/**
	 * Si trobem l'element el treiem i el retornem Sino retornem null
	 * 
	 * @param elem : element a buscar
	 * @return Element trobat o null si no hi és
	 */

	public Cosa treu(Cosa elem) {

		return null;
	}

	public Iterador iterator() {
		return new Iterador();
	}

	// classe interna té accés als atributs de la classe...
	public class Iterador {

		private Node prev = null; // primer element

		public Iterador() {
			prev = null;
		}

		public boolean hasNext() {
			if (prev == null) {
				return cap != null;
			} else {
				if (prev.següent == null)
					return false;
				return prev.següent.següent != null;
			}
		}

		public Cosa next() throws Exception {

			if (prev == null) {
				prev = new Node();
				prev.següent = cap;
			} else {
				prev = prev.següent;
			}
			return prev.següent.dada;
		}

		public void remove() throws Exception {
			mida--;
			// si no queden elements.
			if (mida == 0) {
				cap = null;
				cua = null;
			} else {
				if (cap == prev.següent) {
					cap = prev.següent.següent;
					prev = null;
				} else {
					// el previ apunta al següent del que elimino.
					prev.següent = prev.següent.següent;
					// tiro un enerera
					Node aux = new Node();
					aux.següent = prev;
					prev = aux;
					// si eliminem l'element de la ultima posició (i no era l'unic)
					if (prev.següent.següent == null) {
						cua = prev.següent;
					}
				}
			}
		}

	}

	public void pinta() {
		// pintem el cap apuntant al primer
		// pintem la llista com capses encadenades
		// pintem la cua apuntant a l'últim...
		if (mida > 0) {
			System.out.println("cap 🠗");
			System.out.println(" ┌──┐".repeat(mida));
			Node elem = cap;
			String prev = " ";
			while (elem != null) {
				System.out.printf(prev + "│%2d│", elem.dada);
				prev = "→";
				elem = elem.següent;
			}
			System.out.println("⏚");
			System.out.println(" └──┘".repeat(mida));
			System.out.println(".....".repeat(mida - 1) + "cua↑");
		} else {
			System.out.println("cap ⏚");
			System.out.println("cua ⏚");
		}
	}

	public static void main(String[] arg) {
		Cua<Integer> queue = new Cua<>();
		try {
			queue.enqueue(6);
			queue.enqueue(3);
			queue.enqueue(99);
			queue.enqueue(56);
			queue.pinta();
			System.out.println("surt de la cua: " + queue.dequeue());
			queue.pinta();
			queue.enqueue(43);
			queue.pinta();
			System.out.println("surt de la cua: " + queue.dequeue());
			queue.pinta();
			queue.enqueue(89);
			queue.enqueue(77);
			queue.pinta();
			System.out.println("surt de la cua: " + queue.dequeue());
			queue.enqueue(32);
			queue.enqueue(22);
			queue.pinta();
			Cua<Integer>.Iterador it = queue.iterator();
			while (it.hasNext()) {
				System.out.println("element  de la cua: " + it.next());
			}
			it.remove();
			queue.enqueue(99);
			queue.pinta();
			it = queue.iterator();
			int i = 0;
			while (it.hasNext()) {
				int val = it.next();
				if ((i++ % 2) == 0) {
					System.out.println("eliminem de la cua: " + val);
					it.remove();
				}
			}
			queue.pinta();
			it = queue.iterator();
			while (it.hasNext()) {
				int val = it.next();
				System.out.println("eliminem de la cua: " + val);
				it.remove();
			}
			queue.enqueue(16);
			queue.enqueue(2);
			queue.enqueue(39);
			queue.enqueue(36);

			System.out.println("surt de la cua: " + queue.dequeue());
			System.out.println("surt de la cua: " + queue.dequeue());
			System.out.println("surt de la cua: " + queue.dequeue());
			System.out.println("surt de la cua: " + queue.dequeue());
			System.out.println("surt de la cua: " + queue.dequeue());
			System.out.println("surt de la cua: " + queue.dequeue());
			queue.pinta();
		} catch (Exception e) {
			System.out.println("error, posició fora de rang");
		}
		Teclat teclat = new Teclat();
		int valor;
		String opcio = teclat.Llegir_opcions("atrpf", "a:add, t:troba , r:remove,p:pinta,  f:fi");
		while (!opcio.contentEquals("f")) {
			switch (opcio) {
			case "a":
				valor = teclat.llegirInt(100, "valor a afegir?");
				queue.enqueue(valor);
				break;
			case "r":
				try {
					System.out.println("surt de la cua: " + queue.dequeue());
				} catch (Exception e) {
					System.out.println("error, cua buida");
				}
				break;
			case "t":
				valor = teclat.llegirInt(queue.size(), "valor a cercar?");
				try {
					System.out.println("esta a la cua: " + queue.get(valor));
				} catch (Exception e) {
					System.out.println("error, posició fora de rang");
				}
				break;
			case "p":
				queue.pinta();
				break;
			}
			opcio = teclat.Llegir_opcions("atrpf", "a:add, t:troba , r:remove,p:pinta,  f:fi");
		}
		System.out.println("Adeu!!");
	}
}
