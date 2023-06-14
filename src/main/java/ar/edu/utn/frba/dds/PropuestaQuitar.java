package ar.edu.utn.frba.dds;

public class PropuestaQuitar extends Propuesta{

	PropuestaQuitar(Prenda unaPrenda, Guardarropa unGuardarropa) {
		super(unaPrenda, unGuardarropa);
	}

	void aceptar() {
		this.getGuardarropa().quitarPrenda(this.getPrenda());
	}
}
