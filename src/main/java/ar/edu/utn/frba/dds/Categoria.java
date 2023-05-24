package ar.edu.utn.frba.dds;

import java.util.List;

public enum Categoria {

		ParteSuperior(List.of(TipoDePrenda.REMERA, TipoDePrenda.CAMISA, TipoDePrenda.CHOMBA, TipoDePrenda.MUSCULOSA)),
		ParteInferior(List.of(TipoDePrenda.PANTALON)),
		Calzado(List.of(TipoDePrenda.ZAPATILLAS, TipoDePrenda.ZAPATOS, TipoDePrenda.POLLERA)),
		Accesorio(List.of(TipoDePrenda.PANUELO));
	
	private final List<TipoDePrenda> condecirCategoriaConTipo;
	
	Categoria(List<TipoDePrenda> condecirTipos){
		this.condecirCategoriaConTipo = condecirTipos;
	}
	
	public boolean condiceConElTipo(TipoDePrenda untipo) {
		return condecirCategoriaConTipo.contains(untipo);
	}
	
}