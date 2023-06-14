package ar.edu.utn.frba.dds;

import com.accuweather.AccuWeatherAPI;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoTest {
	
	@Test
	void sePuedenGenerarSugerenciasParaBsAsCon18Grados() {
		ServicioMeteorologicoAccuWeather servicio = Mockito.mock(ServicioMeteorologicoAccuWeather.class);
		Mockito.when(servicio.getTemperaturaEnLaCiudad("Buenos Aires"))
				.thenReturn(new Temperatura(18, UnidadTemperatura.Celsius));
		var unUsuario = new Usuario(32, new MotorSugerenciasBasico());

		var asesor = new AsesorDeImagen(servicio);

		Assertions.assertNotNull(asesor.sugerirAtuendo(unUsuario, "Buenos Aires"));
	}

	@Test
	void sePuedeConsultarPorElClimaEnBuenosAiresUnDiaFrio() {
		AccuWeatherAPI api = Mockito.mock(AccuWeatherAPI.class);
		var servicio = new ServicioMeteorologicoAccuWeather(api, Duration.ofMinutes(30));

		Map<String, Object> resultado = new HashMap<>();
		resultado.put("Temperature", 15);

		Mockito.when(api.getWeather("Buenos Aires")).thenReturn(resultado);
	}
}
