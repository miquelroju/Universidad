package Arbres;

import java.util.*;

public class AcbEnll<E extends Comparable<E>> implements Acb{
	
	private class NodeA {
		NodeA esq, dret;
		E inf;
		public int cardinalitat() {
			int cont = 1;
			if (esq != null) cont += esq.cardinalitat();
			if (dret != null) cont += dret.cardinalitat();
			return cont;
		}
		public void inordre (Queue<E> cua) {
			if (esq != null) esq.inordre(cua);
			try {
				cua.add(inf);
			} catch (IllegalStateException e) {
			}
			
			if (dret!=null) dret.inordre(cua);
		}
	}
	
	private NodeA arrel;
	private Queue<E> cua;
	
	public void iniRecorregut (boolean sentit) {
		this.inordre();
		
	}
	
	public Queue<E> inordre() {
		this.cua = new LinkedList<E>();
		if (arrel != null) arrel.inordre(cua);
		return cua;
	}
	
	public boolean finalRecorregut() {
		if (this.abBuit()) return true;
		// if (this.segRecorregut() == Exception()) return true;
		return false;
	}
	
	public E segRecorregut() throws ArbreException {
		if (this.abBuit()) throw new ArbreException ("Arbre buit");
		if (this.arrel.esq == null) return this.arrel.dret;
	}
	
	public Object clone() {
		Object result = null;
		return result;
	}
	
	public int cardinalitat() {
		if (this.arrel == null) return 0;
		return (arrel.cardinalitat());
	}

	@Override
	public Comparable arrel() throws ArbreException {
		if (this.arrel == null) throw new ArbreException("Arbre buit");
		else return this.arrel.inf;	
	}

	@Override
	public Acb fillEsquerre() {
		Acb v = new AcbEnll();
		if (arrel!=null) {
			//Acb v = new AcbEnll();
			((AcbEnll)v).arrel = arrel.esq;
			return v;
		}
		return v = null;
	}

	@Override
	public Acb fillDret() {
		Acb v = new AcbEnll();
		if (arrel!=null) {
			((AcbEnll)v).arrel = arrel.dret;
			return v;
		}
		return v = null;
	}

	@Override
	public boolean abBuit() {
		return arrel == null;
	}

	@Override
	public void buidar() {
		arrel = null;		
	}

	@Override
	public void inserir(Comparable e) throws ArbreException {
		this.arrel = inserirRecursiu(this.arrel, e);		
	}
	
	private NodeA inserirRecursiu(NodeA a, Comparable<E> e) throws ArbreException {
		if (a==null) {
			a = new NodeA();
			a.esq = null;
			a.inf = (E) e;
			a.dret = null;
		} else {
			int cmp = e.compareTo((E)a.inf);
			if (cmp == 0) throw new ArbreException("Repetit " + e);
			if (cmp < 0) {
				a.esq = inserirRecursiu(a.esq, e);
			} else {
				a.dret = inserirRecursiu(a.dret, e);
			}
		}
		return a;
	}

	@Override
	public void esborrar(Comparable e) throws ArbreException {
		this.arrel = esborrarRec(this.arrel, e);
	}
	
	private NodeA esborrarRec(NodeA a, Comparable<E> e) throws ArbreException {
		if (a == null) throw new ArbreException ("Inexistent " + e);
		
		int cmp = e.compareTo((E)a.inf);
		
		if (cmp < 0) {
			a.dret = esborrarRec(a.dret, e);
		} else {
			if (a.esq == null && a.dret == null) a=null;
			else {
				if (a.esq != null && a.dret != null) {
					a.inf = buscarMinim(a.dret);
					a.dret = esborrarMinim (a.dret);
				}
				else {
					if (a.esq == null) a = a.dret;
					else a = a.esq;
				}
			}
		}
	}
	
	public Comparable<E> buscarMinim(NodeA a) {
		while (a.esq != null) a=a.esq;
		return (Comparable<E>)a.inf;
	}
	
	private NodeA esborrarMinim (NodeA a) {
		if (a.esq == null) return a.dret;
		else {
			a.esq = esborrarMinim(a.esq);
			return a;
		}
	}

	@Override
	public boolean membre(Comparable e) {
		return membreRec(this.arrel, e);
	}
	
	private boolean membreRec(NodeA a, Comparable<E> e) {
		if (a==null) return false;
		
		int cmp = e.compareTo((E)a.inf);
		
		if (cmp==0) return true;
		
		if (cmp<0) return membreRec(a.esq,e);
		else return membreRec(a.dret,e);
		
		
	}

}
