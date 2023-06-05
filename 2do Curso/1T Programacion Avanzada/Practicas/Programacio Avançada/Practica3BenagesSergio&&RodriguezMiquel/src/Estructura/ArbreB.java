package Estructura;

public class ArbreB {

	private class NodeA {
		
		String contents;
		ArbreB yes, no;
		
		NodeA (String pregunta, ArbreB a1, ArbreB a2) {
			this.contents = pregunta;
			this.yes = a1;
			this.no = a2;
		}
		
		NodeA (String contents) {
			this(contents, null, null);
		}
		
	}
	
	private NodeA[] act, seg;
	
	public ArbreB(ArbreB a1, ArbreB a2, String pregunta) {
		new NodeA(pregunta, a1, a2);
	}
	
}
