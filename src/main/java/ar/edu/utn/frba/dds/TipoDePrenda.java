package ar.edu.utn.frba.dds;

public class TipoDePrenda {
	Categoria categoria;

	TipoDePrenda(Categoria unaCategoria) {
		this.categoria = unaCategoria;
	}
}

enum Categoria {
	ParteSuperior, ParteInferior, Calzado, Accesorio;
}