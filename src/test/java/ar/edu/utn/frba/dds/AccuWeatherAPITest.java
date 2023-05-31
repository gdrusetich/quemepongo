package ar.edu.utn.frba.dds;

import com.accuweather.*;
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
}