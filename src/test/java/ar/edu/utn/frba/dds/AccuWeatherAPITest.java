package ar.edu.utn.frba.dds;

import com.accuweather.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccuWeatherAPITest {

	@Test
	void sePuedeConsultarAAccuWeatherElTiempoDeBuenosAires() {
		var cliente = new AccuWeatherAPICliente();
		var resultado = cliente.getWeather("Buenos Aires");

		Assertions.assertNotNull(resultado);
//		Assertions.assertEquals(resultado.get("Temperature"), 18);
	}
	
	@Test
	void sePuedeObtenerCondicionesClimaticas() {
	AccuWeatherAPI apiClima = new AccuWeatherAPI();
	String buenosAires = "Buenos Aires, Argentina";
	List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(buenosAires);
	Assertions.assertEquals(condicionesClimaticas.get(0).get("Temperature"), new Temperatura(18, 57, "F")); //Devuelve un número del 0 al 1
	}
}