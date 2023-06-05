package p0_material;

public class Element {
	
	private String name;
	private int value;
	
	
	// Constructor
	public Element (String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	// setters & getter
	public String getName() {return this.name;}
	public int getValue() {return this.value;}
	public void setValue(int newVal) {this.value=newVal;} 
	
	// equality (overriding of superclass equals)
	public boolean equals (Object o) {
		Element other;
		try {
			other = (Element)o;
			return this.name.equals(other.name);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	// toString (overriding of superclass toString)
	public String toString () {
		return "Element["+name+" "+value+"]";
	}

}
