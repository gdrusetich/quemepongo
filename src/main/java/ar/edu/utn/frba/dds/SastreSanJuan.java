package ar.edu.utn.frba.dds;

public class SastreSanJuan implements Sastre {

	private static final Categoria ParteSuperior = null;
	private static final Material Pique = null;
	private static final Trama Lisa = null;
	private static final Material Acetado = null;
	private static final Categoria ParteInferior = null;
	private static final Categoria Calzado = null;

	public Prenda fabricarParteSuperior() {
		return new Prenda(Chomba, Pique, Lisa);
	}

	public Prenda fabricarParteInferior() {
		return new Prenda(Pantalon, Acetado, Lisa);
	}

	public Prenda fabricarCalzado() {
		return new Prenda(Zapatillas, null, null);
	}

	TipoDePrenda Chomba = new TipoDePrenda(ParteSuperior);
	TipoDePrenda Pantalon = new TipoDePrenda(ParteInferior);
	TipoDePrenda Zapatillas = new TipoDePrenda(Calzado);
}
