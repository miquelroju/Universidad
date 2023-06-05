package Examen1Curs202122;

public class Plataforma {
	
	private class NodeAny {
		NodeProd inf;
		int any;
		NodeAny seg;
		
		public NodeAny (int any) {
			inf = null;
			seg = null;
			this.any = any;
		}
	}
	
	private class NodeProd {
		Produccio inf;
		NodeProd seg;
		
		public NodeProd (Produccio p, NodeProd aux) {
			inf = p;
			seg = aux;
		}
	}
	
	private NodeAny prod;
	
	public Plataforma() {
		prod = null;
	}
	
	private static boolean hiEs (Produccio o, NodeProd p) {
		while (p != null) {
			if (p.inf.compareTo(o) == 0) return true;
			p = p.seg;
		}
		return false;
	}
	
	private NodeAny onEs (int any) {
		if (prod == null) return null;
		NodeAny aux = prod;
		while (aux != null) {
			if (aux.any == any) return aux;
			aux = aux.seg;
		}
		return null;
	}
	
	public void afegirProduccio (Produccio p) throws ExcepcioPlataforma {
		NodeAny aux = onEs(p.getAny());
		if (aux == null) {
			aux = new NodeAny(p.getAny());
			aux.seg = prod;
			prod = aux;
		}
		if (!hiEs(p, aux.inf)) aux.inf = new NodeProd(p, aux.inf);
		else throw new ExcepcioPlataforma("ja hi es");
	}
	
	public int eliminarProduccio(int any) {
		int cont = 0;
		if (prod == null) return cont;
		if (prod.any == any) {
			cont = quants(prod.inf);
			prod = prod.seg;
			return cont;
		}
		NodeAny aux = prod;
		while (aux.seg != null) {
			if (aux.seg.any == any) {
				cont = quants(aux.seg.inf);
				aux.seg = aux.seg.seg;
				return cont;
			} else aux = aux.seg;
		}
		return cont;
	}
	
	private static int quants (NodeProd p) {
		int cont = 0;
		while (p != null) {
			cont++;
			p = p.seg;
		}
		return cont;
	}
	
	public String trobaTitol (int any, int durada) throws ExcepcioPlataforma {
		NodeAny aux = onEs (any);
		if(aux == null) throw new ExcepcioPlataforma ("No te cap produccio d'aquest any");
		NodeProd aux2 = aux.inf;
		while(aux2 != null) {
			if (aux2.inf instanceof Serie) {
				String titol = ((Serie) (aux2.inf)).teDurada(durada);
				if (titol != null) return titol;
			}
			aux2 = aux2.seg;
		}
		throw new ExcepcioPlataforma ("No te cap de la durada indicada");
	}
	
	private class ExcepcioPlataforma extends Throwable {
		ExcepcioPlataforma(String msg) {
			super(msg);
		}
	}

}
