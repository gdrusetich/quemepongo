package ar.edu.utn.frba.dds;

public class SastreSanJuan implements Sastre {

@Override
	public Prenda fabricarParteSuperior() {
	Borrador borrador = new Borrador(TipoDePrenda.CHOMBA);
	borrador.especificarCategoria(Categoria.ParteSuperior);
	borrador.especificarMaterial(Material.PIQUE);
	borrador.especificarColorPrincipal(new Color (0,200,0));
	return borrador.crearPrenda();
	}

	public Prenda fabricarParteInferior() {
		Borrador borrador = new Borrador(TipoDePrenda.PANTALON);
		borrador.especificarCategoria(Categoria.ParteInferior);
		borrador.especificarMaterial(Material.ACETATO);
		borrador.especificarColorPrincipal(new Color (100,100,100));
		return borrador.crearPrenda();
	}

	public Prenda fabricarCalzado() {
		Borrador borrador = new Borrador(TipoDePrenda.ZAPATILLAS);
		borrador.especificarCategoria(Categoria.Calzado);
		borrador.especificarMaterial(Material.TELA);
		borrador.especificarColorPrincipal(new Color (255,255,255));
		return borrador.crearPrenda();
	}


}
