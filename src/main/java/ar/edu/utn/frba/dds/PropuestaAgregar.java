package ar.edu.utn.frba.dds;

public class PropuestaAgregar extends Propuesta {
	PropuestaAgregar(Prenda unaPrenda, Guardarropa unGuardarropa) {
		super(unaPrenda, unGuardarropa);
	}
	

	void aceptar() {
		this.guardarropas.agregarPrenda(this.prenda);
	}

}
