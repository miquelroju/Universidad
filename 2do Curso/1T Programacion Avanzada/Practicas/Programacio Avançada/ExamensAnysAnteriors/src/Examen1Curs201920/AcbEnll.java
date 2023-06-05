package Examen1Curs201920;

public class AcbEnll implements Acb {
	
	private NodeA arrel;
	
	public AcbEnll() {
		arrel = null;
	}

	@Override
	public void Inserir(Comparable e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Esborrar(Comparable e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Membre(Comparable e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable Arrel() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb FillEsquerre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb FillDret() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ArbreBuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Buidar() {
		// TODO Auto-generated method stub
		
	}
	
	NodeA localitzar(Comparable e) {
		if (arrel == null) return null;
		return arrel.hiEs(e);
	}
	
	public String toString() {
		if (arrel != null) return arrel.toString();
		return "";
	}

}
