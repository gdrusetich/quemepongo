package ar.edu.utn.frba.dds;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class UsuarioTest {
	Usuario german = new Usuario(32, new MotorSugerenciasBasico());
	
	
	@Test
	public void sePuedeObtenerGetPrendas() {
		Borrador borrador = new Borrador(TipoDePrenda.Remera);
	borrador.especificarCategoria(Categoria.ParteSuperior);
	borrador.especificarMaterial(Material.ALGODON);
	borrador.especificarColorPrincipal(new Color(0,0,0));
	borrador.especificarFormalidad(Formalidad.Formal);
	Prenda camisaLisaNegra = borrador.crearPrenda();
	Guardarropa guardarropaCompartido = new Guardarropa( new ArrayList<>());
	guardarropaCompartido.agregarPrenda(camisaLisaNegra);
	
	german.agregarGuardarropa(guardarropaCompartido);
	assertTrue(german.getPrendas().contains(camisaLisaNegra));		
	}
}
