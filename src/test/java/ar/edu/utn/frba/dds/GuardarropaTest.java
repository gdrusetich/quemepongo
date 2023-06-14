package ar.edu.utn.frba.dds;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuardarropaTest {
	Usuario german = new Usuario(32, new MotorSugerenciasBasico());
	Usuario laura = new Usuario(42, new MotorSugerenciasBasico());
	Guardarropa guardarropaFormal;
	Prenda camisaLisaNegra;
	Borrador borrador;
	Prenda pantalonDeVestirNegro;

	@Test
	public void lauraYGermanCompartenGuardarropa() {
		this.german.agregarGuardarropa(this.guardarropaFormal());
		this.laura.agregarGuardarropa(guardarropaFormal);
		guardarropaFormal.agregarPrenda(this.camisaLisaNegra());
		assertTrue(guardarropaFormal.getPrendas().contains(camisaLisaNegra));
		assertTrue(german.getPrendas().contains(camisaLisaNegra));
		assertTrue(laura.getPrendas().contains(camisaLisaNegra));
	}

	@Test
	public void lauraProponeAgregarCamisaAGerman() {
		german.agregarGuardarropa(this.guardarropaFormal());
		guardarropaFormal.compartirCon(laura);
		laura.proponerAgregar(german, this.camisaLisaNegra(), guardarropaFormal);
		assertTrue(german.getPropuestasAgregar().stream().map(propuesta -> propuesta.getPrenda())
				.collect(Collectors.toList()).contains(camisaLisaNegra));
		Assertions.assertEquals(german.getPropuestasAgregar().size(), 1);
		Assertions.assertEquals(german.getPropuestasQuitar().size(), 0);
	}

	@Test
	public void usuarioAceptaTodasLasPropuestas() {
		this.lauraProponeAgregarCamisaAGerman();
		assertTrue(german.getPropuestasAgregar().stream().map(propuesta -> propuesta.getPrenda())
				.collect(Collectors.toList()).contains(camisaLisaNegra));
		laura.proponerAgregar(german, this.pantalonDeVestirNegro(), guardarropaFormal);
		Assertions.assertEquals(german.getPropuestasAgregar().size(), 2);

		german.aceptarTodasLasPropuestas();
		assertTrue(german.getPrendas().contains(camisaLisaNegra));
		assertTrue(laura.getPrendas().contains(pantalonDeVestirNegro));

		laura.proponerQuitar(german, camisaLisaNegra, guardarropaFormal);
		Assertions.assertEquals(german.getPropuestasQuitar().size(), 1);

		german.aceptarTodasLasPropuestas();
		Assertions.assertEquals(german.getPrendas().size(), 1);
	}

	@Test

	public void puedoVerTodasLasPropuestasDeAgregar() {
		this.lauraProponeAgregarCamisaAGerman();
		Assertions.assertEquals(german.getPropuestasAgregar().size(), 1);
		laura.proponerAgregar(german, pantalonDeVestirNegro, guardarropaFormal);
		Assertions.assertEquals(german.getPropuestasAgregar().size(), 2);

	}

	private Borrador borrador() {
		return borrador = new Borrador(TipoDePrenda.Remera);
	}

	private Prenda camisaLisaNegra() {
		this.borrador();
		borrador.especificarTipo(TipoDePrenda.Camisa);
		borrador.especificarCategoria(Categoria.ParteSuperior);
		borrador.especificarMaterial(Material.ALGODON);
		borrador.especificarColorPrincipal(new Color(0, 0, 0));
		borrador.especificarFormalidad(Formalidad.Formal);
		return camisaLisaNegra = borrador.crearPrenda();
	}

	private Prenda pantalonDeVestirNegro() {
		this.borrador();
		borrador.especificarTipo(TipoDePrenda.Pantalon);
		borrador.especificarCategoria(Categoria.ParteInferior);
		borrador.especificarMaterial(Material.TELA);
		borrador.especificarColorPrincipal(new Color(0, 0, 0));
		borrador.especificarFormalidad(Formalidad.Formal);
		return pantalonDeVestirNegro = this.borrador().crearPrenda();
	}

	private Guardarropa guardarropaFormal() {
		return guardarropaFormal = new Guardarropa(new ArrayList<>());
	}
}