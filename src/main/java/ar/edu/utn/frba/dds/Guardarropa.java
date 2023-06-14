package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {
	List<Prenda> guardarropa = new ArrayList<>();


	public Guardarropa(List<Prenda> unGuardarropa) {
		this.guardarropa = unGuardarropa;
	}
	
	void compartirCon(Usuario unUsuario) {
		unUsuario.agregarGuardarropa(this);
	}

	List<Prenda> getPrendas() {
		return this.guardarropa;
	}

	void quitarPrenda(Prenda unaPrenda) {
		this.guardarropa.remove(unaPrenda);
	}
	
	void agregarPrenda(Prenda unaPrenda) {
		this.guardarropa.add(unaPrenda);
	}

}
