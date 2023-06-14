package ar.edu.utn.frba.dds;

import java.util.List;

public enum Material {
	ALGODON(List.of(TipoDePrenda.Remera, TipoDePrenda.Camisa, TipoDePrenda.Musculosa)),
	PIQUE(List.of(TipoDePrenda.Chomba)),
	CUERO(List.of(TipoDePrenda.Zapatos, TipoDePrenda.Pollera, TipoDePrenda.Pantalon)),
	TELA(List.of(TipoDePrenda.Zapatillas, TipoDePrenda.Panuelo, TipoDePrenda.Pollera, TipoDePrenda.Pantalon)),
	ACETATO(List.of(TipoDePrenda.Pantalon));

	public List<TipoDePrenda> tiposValidos;

	Material(List<TipoDePrenda> tiposValidos) {
		this.tiposValidos = tiposValidos;
	}

	public boolean condiceConElTipo(TipoDePrenda unTipo) {
		return tiposValidos.contains(unTipo);
	}
}
