package ar.edu.utn.frba.dds;

public class Temperatura {

	int valor;
	UnidadTemperatura unidad;

	public Temperatura(int unValor, UnidadTemperatura unaUnidad) {
		this.valor = unValor;
		this.unidad = unaUnidad;
	}

	public int getValor() {
		return this.valor;
	}

	public UnidadTemperatura getUnidad() {
		return this.unidad;
	}

}
