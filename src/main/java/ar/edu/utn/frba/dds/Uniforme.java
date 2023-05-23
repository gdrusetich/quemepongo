package ar.edu.utn.frba.dds;

public class Uniforme {
	Prenda prendaSuperior;
	Prenda prendaInferior;
	Prenda calzado;

	public Uniforme(Prenda fabricarParteSuperior, Prenda fabricarParteInferior, Prenda fabricarCalzado) {
		this.prendaSuperior = fabricarParteSuperior;
		this.prendaInferior = fabricarParteInferior;
		this.calzado = fabricarCalzado;
	}

	Uniforme fabricar(Sastre unSastre) {
		return new Uniforme(unSastre.fabricarParteSuperior(), unSastre.fabricarParteInferior(),
				unSastre.fabricarCalzado());
	}
}
