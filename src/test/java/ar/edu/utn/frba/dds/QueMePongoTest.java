package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dds.quemepongo.exceptions.NoCondiceConSuCategoriaException;
import dds.quemepongo.exceptions.NoCondiceConSuMaterialException;

public class QueMePongoTest {
	
	@Test
	public void sePuedeCrearUnaRemeraBlancaLisa() {
		Borrador borrador = new Borrador(TipoDePrenda.REMERA);
		borrador.especificarCategoria(Categoria.ParteSuperior);
		borrador.especificarTrama(Trama.Lisa);
		borrador.especificarMaterial(Material.ALGODON);
		borrador.especificarColorPrincipal(new Color(0,0,1));
		borrador.especificarColorSecundario(new Color(1,1,0));
		Prenda remeraBlancaLisa = borrador.crearPrenda();
		Assertions.assertEquals(remeraBlancaLisa.getCategoria() == Categoria.ParteSuperior, true);
	}

	@Test
	public void noSePuedeCrearUnaRemeraDeCuero() {
		Borrador borrador = new Borrador(TipoDePrenda.REMERA);
		Assertions.assertThrows(NoCondiceConSuMaterialException.class, () -> borrador.especificarMaterial(Material.CUERO));
	}
	
	@Test
	public void unaRemeraNoPuedeSerParteInferior() {
		Borrador borrador = new Borrador(TipoDePrenda.REMERA);
		Assertions.assertThrows(NoCondiceConSuCategoriaException.class, () -> borrador.especificarCategoria(Categoria.ParteInferior));
	}


	
	@Test
	public void unaRemeraNoPuedeSerDeCuero() {
		Assertions.assertEquals(Material.CUERO.condiceConElTipo(TipoDePrenda.REMERA),false);
	}
	
	@Test
	public void unaRemeraPuedeSerDeAlgodon() {
		Assertions.assertEquals(Material.ALGODON.condiceConElTipo(TipoDePrenda.REMERA), true);
	}
}

