package Examen1Curs201819;

public class Zoo {
	
	private class Node {
		Animal inf;
		Node seg;
		
		public Node (Animal m, Node n) {
			this.inf = m;
			this.seg = n;
		}
	}
	
	private Object[] magatzems;
	private String nom;
	
	public Zoo (String nom) {
		this.nom = nom;
		magatzems = new Object[4];
		magatzems[0] = new AcbEnll();
		magatzems[1] = new AcbEnll();
		magatzems[2] = null;
		magatzems[3] = null;
	}
	
	public void addAnimal(Animal a) throws ExcepcioZoo {
		if (a.esCadell()) {
			if (a instanceof Lloro) {
				if (!hiEs((Node) magatzems[3], a))
					try {
						((Acb)magatzems[1]).Inserir(a);
					} catch (Exception e) {
						throw new ExcepcioZoo ("Repetit");
					}
			} else {
				if (!hiEs((Node)magatzems[2], a))
					try {
						((Acb)magatzems[0]).Inserir(a);
					} catch (Exception e) {
						throw new ExcepcioZoo("Repetit");
					}
				else throw new ExcepcioZoo("Repetit");
			} 
		} else {
			if (a instanceof Lloro) 
				if(!((Acb)magatzems[1]).Membre(a) && !hiEs((Node)magatzems[3], a)) addAnimal(3, a);
				else throw new ExcepcioZoo ("Repetit");
			else
				if (!((Acb)magatzems[0]).Membre(a) && !hiEs((Node)magatzems[2], a)) addAnimal(2, a);
				else throw new ExcepcioZoo ("Repetit");
		}
	}
	
	private void addAnimal(int quin, Animal a) {
		magatzems[quin] = new Node (a, (Node)(magatzems[quin]));
	}
	
	private static boolean hiEs (Node aux, Animal a) {
		while (aux != null && aux.inf.compareTo(a) != 0) 
			aux= aux.seg;
		return aux != null;
	}
	
	private static Node hiEs2 (Node aux, Animal a) {
		while (aux.seg != null && aux.seg.inf.compareTo(a) != 0)
			aux = aux.seg;
		return aux;
	}
	
	public void removeAnimal (Animal a) throws ExcepcioZoo {
		if (a.esCadell()) {
			if (a instanceof Lloro) {
				try {
					((Acb) magatzems[1]).Esborrar(a);
				} catch (Exception e) {
					throw new ExcepcioZoo ("No hi es");
				}
			} else {
				try {
					((Acb) magatzems[0]).Esborrar(a);
				} catch (Exception e) {
					throw new ExcepcioZoo ("No hi es");
				}
			}
		} else {
			if (a instanceof Lloro)
				remAnimal (3, a);
			else
				remAnimal (2, a);
		}
	}
	
	private void remAnimal (int quin, Animal a) throws ExcepcioZoo {
		if (magatzems[quin] == null)
			throw new ExcepcioZoo("No hi es!");
		if (((Node)magatzems[quin]).inf.compareTo(a) == 0)
			magatzems[quin] = ((Node) magatzems[quin]).seg;
	}

	public String magatzemMesPle() {
		int a = ((AcbEnll) magatzems[0]).quantsArbre();
		int b = ((AcbEnll) magatzems[1]).quantsArbre();
		int c = quantsSeq((Node) magatzems[2]);
		int d = quantsSeq((Node) magatzems[3]);
		if (a > b && a > c && a > d) return "Cadell Gossos";
		else if (b > c && b > d) return "Cadell Lloros";
		else if (c > d) return "Adults Gossos";
		else return "Adults Lloros";
	}
	
	private static int quantsSeq(Node aux) {
		int cont = 0;
		while (aux != null) {
			aux = aux.seg;
			cont++;
		}
		return cont;
	}
	
	public String quinCaracter(String nom) {
		return ((AcbEnll) magatzems[0]).quinCaracter(nom);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
