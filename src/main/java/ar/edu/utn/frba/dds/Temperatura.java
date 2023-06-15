package ar.edu.utn.frba.dds;

public class Temperatura {

	UnidadTemperatura unidad;
	Double valor;

	public Temperatura(UnidadTemperatura unidad, Double valor) {
		this.unidad = unidad;
		this.valor = valor;
	}

	public UnidadTemperatura getUnidad() {
		return this.unidad;
	}

	public double getValue() {
		return this.valor;
	}
	

}

