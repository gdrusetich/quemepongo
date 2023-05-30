package ar.edu.utn.frba.dds;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class MotorSugerenciasPorFormalidad implements MotorSugerencias{

	List<Prenda> getPrendasValidas(Usuario unUsuario){
		return unUsuario.getEdad() > 55 ? unUsuario.getPrendas().stream().filter(p->p.getFormalidad() != Formalidad.Informal).collect(Collectors.toList()) : unUsuario.getPrendas();
	}
	
	public List<Sugerencia> generarSugerencias(Usuario unUsuario){
		List<Prenda> prendasSuperiores = this.getPrendasValidas(unUsuario).stream().filter(prenda -> prenda.getCategoria() == Categoria.ParteSuperior).collect(Collectors.toList());
		List<Prenda> prendasInferiores = this.getPrendasValidas(unUsuario).stream().filter(prenda -> prenda.getCategoria() == Categoria.ParteInferior).collect(Collectors.toList());
		List<Prenda> calzados = this.getPrendasValidas(unUsuario).stream().filter(prenda -> prenda.getCategoria() == Categoria.Calzado).collect(Collectors.toList());
		
		List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);
		
		return combinaciones.stream().map(c -> new Sugerencia(c.get(0), c.get(1), c.get(2))).collect(Collectors.toList());
	}
	
}