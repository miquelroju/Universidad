package Examen1Curs201920;

class NodeA {
	
	Comparable inf;
	NodeA esq, dret;

	public NodeA(Comparable m, NodeA e, NodeA d) {
		inf = m;
		esq = e;
		dret = d;
	}
	
	NodeA hiEs (Comparable a) {
		int re = inf.compareTo(a);
		if (re == 0) return this;
		if (re > 0) {
			if (esq != null) return esq.hiEs(a);
			return null;
		}
		if (dret != null) return dret.hiEs(a);
		return null;
	}
	
	public String toString() {
		String r = "";
		if (dret != null) r += dret.toString();
		r = r + this.inf.toString();
		if (esq != null) r += esq.toString();
		return r;
	}
	
} // fi classe