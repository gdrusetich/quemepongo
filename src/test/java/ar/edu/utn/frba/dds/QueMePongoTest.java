package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dds.quemepongo.exceptions.NoCondiceConSuCategoriaException;
import dds.quemepongo.exceptions.NoCondiceConSuMaterialException;

public class QueMePongoTest {
/*
	@Test
	public void sePuedeCrearUnaPrendaSuperior() {
		Borrador borrador = new Borrador(TipoDePrenda.Remera);
		borrador.especificarCategoria(Categoria.ParteSuperior);
		borrador.especificarTrama(Trama.Estampado);
		borrador.especificarMaterial(Material.ALGODON);
		borrador.especificarFormalidad(Formalidad.Informal);
		borrador.especificarColorPrincipal(new Color(0, 0, 1));
		borrador.especificarColorSecundario(new Color(1, 1, 0));
		Prenda remeraBlancaLisa = borrador.crearPrenda();
		Assertions.assertEquals(remeraBlancaLisa.getCategoria() == Categoria.ParteSuperior, true);
	}
*/
	
	@Test
	public void sePuedeHacerUnNewDeRemera() {
		Prenda remeraNegraEstampada = new Prenda(Categoria.ParteSuperior, TipoDePrenda.Remera, Material.ALGODON, Trama.Estampado, Formalidad.Informal, new Color(0,0,0), null);
		Assertions.assertEquals(remeraNegraEstampada.getCategoria() == Categoria.ParteSuperior, true);
		Assertions.assertEquals(remeraNegraEstampada.getTipo() == TipoDePrenda.Remera, true);
		Assertions.assertEquals(remeraNegraEstampada.getMaterial() == Material.ALGODON, true);
		Assertions.assertEquals(remeraNegraEstampada.getTrama() == Trama.Estampado, true);
		Assertions.assertEquals(remeraNegraEstampada.getFormalidad() == Formalidad.Informal, true);
	}
	
	@Test
	public void sePuedeCrearUnaRemeraBlancaLisaConBorrador() {
		Borrador borrador = new Borrador(TipoDePrenda.Remera);
		borrador.especificarCategoria(Categoria.ParteSuperior);
		borrador.especificarTrama(Trama.Estampado);
		borrador.especificarMaterial(Material.ALGODON);
		borrador.especificarFormalidad(Formalidad.Informal);
		borrador.especificarColorPrincipal(new Color(255, 255, 255));
		Prenda remeraBlancaLisa = borrador.crearPrenda();
		Assertions.assertEquals(remeraBlancaLisa.getTipo() == TipoDePrenda.Remera, true);
	}
	
	
	@Test
	public void noSePuedeCrearUnaRemeraDeCuero() {
		Borrador borrador = new Borrador(TipoDePrenda.Remera);
		Assertions.assertThrows(NoCondiceConSuMaterialException.class,
				() -> borrador.especificarMaterial(Material.CUERO));
	}

	@Test
	public void unaRemeraNoPuedeSerParteInferior() {
		Borrador borrador = new Borrador(TipoDePrenda.Remera);
		Assertions.assertThrows(NoCondiceConSuCategoriaException.class,
				() -> borrador.especificarCategoria(Categoria.ParteInferior));
	}

	@Test
	public void unaRemeraNoPuedeSerDeCuero() {
		Assertions.assertEquals(Material.CUERO.condiceConElTipo(TipoDePrenda.Remera), false);
	}

	@Test
	public void unaRemeraPuedeSerDeAlgodon() {
		Assertions.assertEquals(Material.ALGODON.condiceConElTipo(TipoDePrenda.Remera), true);
	}
	
	@Test
	public void unaRemeraEsParteSuperior() {
		Assertions.assertEquals(Categoria.ParteSuperior.condiceConElTipo(TipoDePrenda.Remera), true);
	}
	
	@Test
	public void noCondiceSuCategoria() {
		Assertions.assertEquals(Categoria.ParteSuperior.condiceConElTipo(TipoDePrenda.Pantalon), false);
	}
	
	@Test
	public void noCondiceConSuCategoriaException() {
		Borrador borrador = new Borrador(TipoDePrenda.Remera);
		Assertions.assertThrows(NoCondiceConSuCategoriaException.class,
				() -> borrador.validarCategoria(Categoria.ParteInferior));
	}
}
