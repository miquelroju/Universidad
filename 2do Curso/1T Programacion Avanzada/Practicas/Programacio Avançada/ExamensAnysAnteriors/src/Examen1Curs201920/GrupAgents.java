package Examen1Curs201920;

public class GrupAgents {

	private class Node {
		NodeA inf;
		Node seg;

		public Node(NodeA m, Node n) {
			this.inf = m;
			this.seg = n;
		}
	}

	private AcbEnll agents;
	private Node[] magatzems;

	public GrupAgents() {
		this.agents = new AcbEnll();
		this.magatzems = new Node[8];
		for (int i = 0; i < magatzems.length; i++)
			this.magatzems[i] = null;
	}

	public void incorporar(Agent a) throws Exception {
		agents.Inserir(a);
		NodeA aux = agents.localitzar(a);
		magatzems[a.getRang()] = new Node(aux, magatzems[a.getRang()]);
	}

	public void retirar(Agent a) throws Exception {
		int on = a.getRang();
		if (magatzems[on] == null)
			throw new Exception("no hi es");
		if (((magatzems[on].inf.inf)).compareTo(a) == 0) {
			magatzems[on] = magatzems[on].seg;
			agents.Esborrar(a);
		} else {
			boolean trobat = false;
			Node aux = magatzems[on];
			while (aux.seg != null && !trobat) {
				if (a.compareTo(aux.seg.inf.inf) == 0) {
					aux.seg = aux.seg.seg;
					agents.Esborrar(a);
					trobat = true;
				} else
					aux = aux.seg;
			}
			if (!trobat)
				throw new Exception("No hi es");
		}
	}

	public String mesRang() {
		int cont, max = quants(magatzems[2]);
		int quin = Agent.SERGENT;
		for (int i = Agent.SOTSINSPECTOR; i < magatzems.length; i++) {
			cont = quants(magatzems[i]);
			if (cont > max) {
				max = cont;
				quin = i;
			}
		}
		return quiEs(quin);
	}

	private static int quants(Node p) {
		int con = 0;
		while (p != null) {
			if (p.inf.inf instanceof AgentEspecial)
				con++;
			p = p.seg;
		}
		return con;
	}

	private static String quiEs(int i) {
		switch (i) {
		case 2:
			return "SERGENT";
		case 3:
			return "SOTSINSPECTOR";
		case 4:
			return "INSPECTOR";
		case 5:
			return "INTENDENT";
		case 6:
			return "COMISSARI";
		case 7:
			return "MAJOR";
		}
		return "";
	}
}
