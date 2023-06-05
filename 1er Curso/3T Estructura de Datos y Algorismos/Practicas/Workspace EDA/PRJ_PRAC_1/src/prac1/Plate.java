package prac1;


// PLATE = (PLACA DE) MATR�CULA 

public class Plate implements Comparable, Cloneable {

	private static final int MIN_AREA_CODE = 1;
	private static final int MAX_AREA_CODE = 6;
	
	private int areaCode;
	private String prefix;
	private String suffix;
	
	public Plate (int areaCode, String prefix, String suffix) {
		checkParams(areaCode, prefix, suffix);
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	
	public int getAreaCode() {
		return areaCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}



	@Override
	public int compareTo (Object other) {
		
		/* this is how plates are sorted:
		 	first go plates with lower area codes. If they have the same area code...
		 	... first go plates with a lower prefix. If the have the same prefix...
		 	... first go plates with a lower suffix.
		 */
		
		/* COMPLETE */
		
		if (other instanceof Plate) {
			Plate altre = (Plate)other;
			int codi1 = this.areaCode, codi2 = altre.areaCode;
			String pref1 = this.prefix, pref2 = altre.prefix;
			String suf1 = this.suffix, suf2 = altre.suffix;
			if (codi1 > codi2) return 1;
			if (codi1 < codi2) return -1;
			if (codi1 == codi2) {
				if (pref1.compareTo(pref2) > 0) return 1;
				if (pref1.compareTo(pref2) < 0) return -1;
				if (pref1 == pref2) {
					if (suf1.compareTo(suf2) > 0) return 1;
					if (suf2.compareTo(suf2) < 0) return -1;
				}
			}
			return 0;
		} else throw new ClassCastException("Parametre no valid");
		
		
	}
	
	
	@Override
	public boolean equals (Object other) {
		/* COMPLETE */
		if(this.compareTo(other) == 0) return true;
		else return false;		
	}
	
	
	@Override
	public String toString () {
		return "["+this.areaCode+" "+this.prefix+"-"+this.suffix+"]";
	}
	
	
	private void checkParams(int areaCode, String prefix, String suffix) {
		if (areaCode>MAX_AREA_CODE || areaCode<MIN_AREA_CODE)
			throw new IllegalArgumentException ("area code out of range: "+areaCode);
		if (prefix.length()!=4 || !checkNumeric(prefix))
			throw new IllegalArgumentException ("invalid prefix: "+prefix);
		if (suffix.length()!=3 || !checkLetter(suffix)) 
			throw new IllegalArgumentException ("invalid suffix: "+suffix);
	}
	
	private boolean checkNumeric (String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}
	
	private boolean checkLetter (String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isLetter(c)) return false;
		}
		return true;
	}
	
	public Object clone () {
		try {
			Object r = super.clone();
			Plate p = (Plate)r;
			p.prefix = new String(this.prefix.toCharArray());
			p.suffix = new String(this.suffix.toCharArray());
			return p;
		}
		catch(CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
