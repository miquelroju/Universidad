package Examen1;

public class Ubicacio {
	private String carrer;
	private int num;

	public Ubicacio(String carrer, int num) {
		this.carrer = carrer;
		this.num = num;
	}

	public String getCarrer() {
		return carrer;
	}

	public int getNum() {
		return num;
	}

	public String toString() {
		return "Carrer: " + carrer + "número " + num;
	}

	public boolean equals(Object ubi) {
		if (ubi instanceof Ubicacio)
			return (((Ubicacio) ubi).carrer).equals(carrer) && ((Ubicacio) ubi).num == num;
		return false;
	}
}

