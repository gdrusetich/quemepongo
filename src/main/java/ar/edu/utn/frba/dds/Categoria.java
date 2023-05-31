package ar.edu.utn.frba.dds;

import java.util.List;

public enum Categoria {

	ParteSuperior(List.of(TipoDePrenda.Remera, TipoDePrenda.Camisa, TipoDePrenda.Chomba, TipoDePrenda.Musculosa)),
	ParteInferior(List.of(TipoDePrenda.Pantalon)),
	Calzado(List.of(TipoDePrenda.Zapatillas, TipoDePrenda.Zapatos, TipoDePrenda.Pollera)),
	Accesorio(List.of(TipoDePrenda.Panuelo));

	private final List<TipoDePrenda> condecirCategoriaConTipo;

	Categoria(List<TipoDePrenda> condecirTipos) {
		this.condecirCategoriaConTipo = condecirTipos;
	}

	public boolean condiceConElTipo(TipoDePrenda untipo) {
		return condecirCategoriaConTipo.contains(untipo);
	}

}