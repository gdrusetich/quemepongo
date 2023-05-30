package ar.edu.utn.frba.dds;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class MotorSugerenciasBasico implements MotorSugerencias{
	
	public List<Sugerencia> generarSugerencias(Usuario unUsuario){
		List<Prenda> prendasSuperiores = unUsuario.getPrendas().stream().filter(prenda -> prenda.getCategoria() == Categoria.ParteSuperior).collect(Collectors.toList());
		List<Prenda> prendasInferiores = unUsuario.getPrendas().stream().filter(prenda -> prenda.getCategoria() == Categoria.ParteInferior).collect(Collectors.toList());
		List<Prenda> calzados = unUsuario.getPrendas().stream().filter(prenda -> prenda.getCategoria() == Categoria.Calzado).collect(Collectors.toList());
		
		List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);
		
		return combinaciones.stream().map(c -> new Sugerencia(c.get(0), c.get(1), c.get(2))).collect(Collectors.toList());
	}
	
}
