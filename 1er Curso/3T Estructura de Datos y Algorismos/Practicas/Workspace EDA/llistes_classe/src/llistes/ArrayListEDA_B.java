package llistes;

public class ArrayListEDA_B {
	private int[] dades;
	private int mida;
	private int ultim;
	private static final int CAPACITAT_INICIAL = 2;

	public ArrayListEDA_B() {
		mida = CAPACITAT_INICIAL; // nombre mÃ xim d'elements disponibles
		ultim = 0; // ultim apunta al primer element buit. TambÃ© ens diu quans elements hi ha
		dades = new int[CAPACITAT_INICIAL];
	}

	public int size() {
		return ultim;
	}

	public void add(int element) {
		if (this.ultim != this.dades.length) {
			dades[ultim] = element;
			ultim++;
		} else {
			int copia[] = dades;
			this.dades = new int[dades.length * 2];

			for (int i = 0; i < ultim; i++) {
				dades[i] = copia[i];
			}
			dades[ultim] = element;
			ultim++;
		}
	}

	public void addAll(ArrayListEDA_B elements) throws Exception {
		int total = this.ultim + elements.ultim;
		int copia[] = dades;
		dades = new int[total];
		for (int i = 0; i < ultim; i++) {
			dades[i] = copia[i];
		}
		for (int i = 0; i < elements.ultim; i++) {
			add(elements.dades[i]);
		}
	}

	public void add(int index, int element) throws Exception {
		for (int i = ultim; i > index; i--) {
			dades[i] = dades[i+1];
		}
		dades[index] = element;
		ultim++;
	}

	public void remove(int index) throws Exception {
		dades[index] = null;
		ultim--;
		for (int i = ultim; i > index; i--) {
			
		}
	}

	public boolean removeObj(int elem) throws Exception {
		return true;
	}

	public Iterador iterator() {
		return new Iterador();
	}

	// classe interna tÃ© accÃ©s als atributs de la classe...
	public class Iterador {

		private int current = 0; // primer element

		public boolean hasNext() {
			return current < ultim;
		}

		public int next() throws Exception {
			if (!hasNext())
				throw new Exception("no queden elements per fer next");
			return dades[current++];
		}

		public void remove() throws Exception {
			ArrayListEDA_B.this.remove(--current); // si fem this.remove pensaria que es el remove de la prÃ²pia classe
		}

		public void pinta() {
			System.out.println("...".repeat(current) + "..ðŸ — ");
			ArrayListEDA_B.this.pinta();
		}

	}

	public void pinta() {

		System.out.println("â”Œâ”€â”€" + "â”¬â”€â”€".repeat(mida - 1) + "â”�");
		for (int i = 0; i < ultim; i++) {
			System.out.printf("â”‚%2d", dades[i]);
		}
		for (int i = ultim; i < mida; i++) {
			System.out.printf("â”‚  ", dades[i]);
		}
		System.out.println("|");
		System.out.println("â””â”€â”€" + "â”´â”€â”€".repeat(mida - 1) + "â”˜");
	}

	public static void main(String a[]) throws Exception {

		ArrayListEDA_B llista = new ArrayListEDA_B();
		llista.add(1);
		llista.pinta();
		llista.add(3);
		llista.add(5);
		llista.add(12);
		llista.pinta();
		llista.add(1);
		llista.pinta();
		llista.add(9);
		llista.add(23);
		llista.pinta();
		llista.add(4, 34);
		llista.add(3, 35);
		llista.pinta();
		Iterador it = llista.iterator();
		it.pinta();
		while (it.hasNext()) {
			try {
				int elem = it.next();
				System.out.println(elem);
				it.pinta();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Teclat teclat = new Teclat();
		int valor;
		String opcio = teclat.Llegir_opcions("atrpf", "a:add, t:troba , r:remove,p:pinta,  f:fi");
		while (!opcio.contentEquals("f")) {
			switch (opcio) {
			case "a":
				valor = teclat.llegirInt(100, "valor a afegir?");
				llista.add(valor);
				break;
			case "r":
				valor = teclat.llegirInt(100, "valor a eliminar?");
				try {
					llista.removeObj(valor);
				} catch (Exception e) {
					System.out.println("error, valor no trobat");
				}
				break;
			case "p":
				llista.pinta();
				break;
			}
			opcio = teclat.Llegir_opcions("atrpf", "a:add, t:troba , r:remove,p:pinta,  f:fi");
		}
		System.out.println("Adeu!!");
	}

}
