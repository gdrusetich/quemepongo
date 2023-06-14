package ar.edu.utn.frba.dds;

public class Temperatura {

	int unitType;
	int value;
	String unit;

	public Temperatura(int unitType, int value, String unit) {
		this.unitType= unitType;
		this.value = value;
		this.unit= unit;
	}

	public int getUnitType() {
		return this.unitType;
	}

	public int getValue() {
		return this.value;
	}
	
	public String unit() {
		return this.unit;
	}

}

