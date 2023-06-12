package ar.edu.utn.frba.dds;

public class Propuesta {
	Prenda prenda;
	TipoPropuesta tipo;
	Guardarropa guardarropas;

	Propuesta(Prenda unaPrenda, TipoPropuesta unTipo, Guardarropa unGuardarropa) {
		this.prenda = unaPrenda;
		this.tipo = unTipo;
		this.guardarropas = unGuardarropa;
	}

	Guardarropa getGuardarropa() {
		return this.guardarropas;
	}

	Prenda getPrenda() {
		return this.prenda;
	}

	void aceptar() {
		if (tipo == TipoPropuesta.AGREGAR) {
			this.getGuardarropa().agregarPrenda(this.getPrenda());
		} else {
			this.getGuardarropa().quitarPrenda(this.getPrenda());
		}
	}
}

/*
class PropuestaRemover{
	void aceptar() {
		this.getGuardarropa().addPrenda(this.getPrenda());	
	}
class PropuestaAceptar{
	void rechazar() {
		this.getGuardarropa().removePrenda(this.getPrenda());
	}
*/