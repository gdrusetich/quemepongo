package ar.edu.utn.frba.dds;

import com.google.common.base.Preconditions;

public class Atuendo {
	Prenda parteSuperior;
	Prenda parteInferior;
	Prenda calzado;

	Atuendo(Prenda superior, Prenda inferior, Prenda calzado) {
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

	boolean esAptaParaTemperatura(Temperatura unaTemperatura) {
		return this.parteSuperior.aptaParaTemperatura(unaTemperatura)
				&& this.parteInferior.aptaParaTemperatura(unaTemperatura)
				&& this.calzado.aptaParaTemperatura(unaTemperatura);
	}
}
