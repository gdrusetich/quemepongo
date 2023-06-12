package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {
	List<Prenda> guardarropa = new ArrayList<>();
	List<Propuesta> propuestas = new ArrayList<>();


	public Guardarropa(List<Prenda> unGuardarropa) {
		this.guardarropa = unGuardarropa;
	}

	List<Prenda> getPrendas() {
		return this.guardarropa;
	}

	void propuestaDeQuitar(Prenda unaPrenda) {

	}
	void quitarPrenda(Prenda unaPrenda) {
		guardarropa.remove(unaPrenda);
	}
	
	void agregarPrenda(Prenda unaPrenda) {
		guardarropa.add(unaPrenda);
	}
	
	
	void agregarPropuestaTentativamente(Prenda prenda, Guardarropa unGuardarropa) {
		this.propuestas.add(new Propuesta(prenda, TipoPropuesta.AGREGAR, unGuardarropa));
	}

	void quitarPropuestaTentativamente(Prenda prenda, Guardarropa unGuardarropa) {
		this.propuestas.add(new Propuesta(prenda, TipoPropuesta.REMOVER, unGuardarropa));
	}

}
