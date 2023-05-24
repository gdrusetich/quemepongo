package ar.edu.utn.frba.dds;

import java.util.List;

public enum Material {
	ALGODON(List.of(TipoDePrenda.REMERA, TipoDePrenda.CAMISA, TipoDePrenda.MUSCULOSA)),
	PIQUE(List.of(TipoDePrenda.CHOMBA)),
	CUERO(List.of(TipoDePrenda.ZAPATOS, TipoDePrenda.POLLERA, TipoDePrenda.PANTALON)),
	TELA(List.of(TipoDePrenda.ZAPATILLAS, TipoDePrenda.PANUELO, TipoDePrenda.POLLERA)),
	ACETATO(List.of(TipoDePrenda.PANTALON));
	
	public List<TipoDePrenda> tiposValidos;	
	Material(List<TipoDePrenda> tiposValidos){
		this.tiposValidos = tiposValidos;
	}
	
	public boolean condiceConElTipo(TipoDePrenda unTipo) {
		return tiposValidos.contains(unTipo);
	}
}
