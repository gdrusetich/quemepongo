package ar.edu.utn.frba.dds;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public interface MotorSugerencias {
	List<Prenda> getPrendasValidas(Usuario unUsuario);

	default List<Atuendo> generarSugerencias(Usuario unUsuario, String ciudad) {
		Temperatura temperaturaDelDia = ElegirServicioMeteorologico.getServicioClimatico()
				.getTemperaturaEnLaCiudad(ciudad);

		List<Prenda> prendasSuperiores = this.getPrendasValidas(unUsuario).stream()
				.filter(prenda -> prenda.getCategoria() == Categoria.ParteSuperior
						&& prenda.aptaParaTemperatura(temperaturaDelDia))
				.collect(Collectors.toList());

		List<Prenda> prendasInferiores = this.getPrendasValidas(unUsuario).stream()
				.filter(prenda -> prenda.getCategoria() == Categoria.ParteInferior
						&& prenda.aptaParaTemperatura(temperaturaDelDia))
				.collect(Collectors.toList());

		List<Prenda> calzados = this.getPrendasValidas(unUsuario).stream().filter(
				prenda -> prenda.getCategoria() == Categoria.Calzado && prenda.aptaParaTemperatura(temperaturaDelDia))
				.collect(Collectors.toList());

		List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

		return combinaciones.stream().map(c -> new Atuendo(c.get(0), c.get(1), c.get(2))).collect(Collectors.toList());
	}

}
