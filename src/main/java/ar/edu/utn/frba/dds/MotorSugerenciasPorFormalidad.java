package ar.edu.utn.frba.dds;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class MotorSugerenciasPorFormalidad implements MotorSugerencias{

	public List<Prenda> getPrendasValidas(Usuario unUsuario){
		return unUsuario.getEdad() > 55 ? unUsuario.getPrendas().stream().filter(p->p.getFormalidad() != Formalidad.Informal).collect(Collectors.toList()) : unUsuario.getPrendas();
	}
}