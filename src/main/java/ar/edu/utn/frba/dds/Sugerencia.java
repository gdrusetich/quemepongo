package ar.edu.utn.frba.dds;

import com.google.common.base.Preconditions;

public class Sugerencia {
Prenda parteSuperior;
Prenda parteInferior;
Prenda calzado;

Sugerencia(Prenda superior, Prenda inferior, Prenda calzado){
	Preconditions.checkNotNull(superior, "Debe elegir una parte superior");
	Preconditions.checkNotNull(inferior, "Debe elegir una parte inferior");
	Preconditions.checkNotNull(calzado, "Debe elegir un calzado");
	this.parteSuperior = superior;
	this.parteInferior = inferior;
	this.calzado = calzado;
}

public Prenda getParteSuperior() {
	return this.parteSuperior;
}

public Prenda getParteInferior() {
	return this.parteInferior;
}

public Prenda getCalzado() {
	return this.calzado;
}


}
