package Sessio6;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

class NodeA {
	Object inf;
	NodeA esq, drt;
	
	NodeA () {
		this(null);
	}
	NodeA(Object o) {
		this(o, null, null);
	}
	NodeA(Object o, NodeA e, NodeA d) {
		inf = o;
		esq = e;
		drt = d;
	}
}

public class AbEnll implements Ab {
	protected NodeA arrel;
	
	public AbEnll() {
		arrel = null;
	}
	public AbEnll(AbEnll a_esq, Object e, AbEnll a_drt) {
		arrel = new NodeA(e, a_esq.arrel, a_drt.arrel);
	}
	public Object Arrel() throws Exception {
		if (arrel == null) {
			throw new Exception ("L'arbre esta buit");
		} else return (arrel.inf);
	}
	@Override
	public Ab FillEsquerre() throws Exception {
		if (arrel != null) {
			Ab v = new AbEnll();
			((AbEnll)v).arrel = arrel.esq;
			return v;
		}
		throw new Exception ("L'arbre es buit");
	}
	@Override
	public Ab FillDret() throws Exception {
		if (arrel != null) {
			Ab v = new AbEnll();
			((AbEnll)v).arrel = arrel.drt;
			return v;
		}
		throw new Exception ("L'arbre es buit");
	}
	@Override
	public boolean AbBuit() {
		return arrel == null;
	}
	@Override
	public void buidar() {
		arrel = null;
	}
}

public interface Ab {
	Object Arrel() throws Exception;
	Ab FillEsquerre() throws Exception;
	Ab FillDret() throws Exception;
	boolean AbBuit();
	void buidar();
}

public class ImpEnll {
	public Queue<Object> preordre() {
		NodeA arrel = null;
		Queue<Object> c = new LinkedList<Object>();
		preordreR(c, arrel);
		return c;
	}

	private static void preordreR (Queue<Object> c, NodeA a) {
			if (a != null) {
				try {
					c.add(a.inf);
					preordreR(c, a.esq);
					preordreR(c, a.drt);
					
				} catch (IllegalStateException e) {
					
				}
			}
		}
}







