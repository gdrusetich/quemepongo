package ar.edu.utn.frba.dds;

public class Propuesta {
	Prenda prenda;
	Guardarropa guardarropas;

	Propuesta(Prenda unaPrenda, Guardarropa unGuardarropa) {
		this.prenda = unaPrenda;
		this.guardarropas = unGuardarropa;
	}

	Guardarropa getGuardarropa() {
		return this.guardarropas;
	}

	Prenda getPrenda() {
		return this.prenda;
	}

	void aceptar() {
		
	}

}