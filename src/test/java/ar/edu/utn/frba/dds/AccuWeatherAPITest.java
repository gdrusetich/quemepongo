package ar.edu.utn.frba.dds;

import com.accuweather.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccuWeatherAPITest {

	@Test
	void sePuedeConsultarAAccuWeatherElTiempoDeBuenosAires() {
		List<Map<String, Object>> clima = Arrays.asList(new HashMap<String, Object>(){
			put("Value", 57);
			put("Unit", "F");
			put("UnitType", 18);
		});
		AccuWeatherAPI apiClima = new AccuWeatherAPI();
		List<Map<String, Object>> estadoDelTiempo = apiClima.getWeather("Buenos Aires, Argentina");  
		Assertions.assertEquals(estadoDelTiempo.get(0).get("Temperature"),new HashMap<String, Object>()); 


	}
	
	@Test
	void sePuedeObtenerCondicionesClimaticas() {
	AccuWeatherAPI apiClima = new AccuWeatherAPI();
	String buenosAires = "Buenos Aires, Argentina";
	List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(buenosAires);
	Assertions.assertEquals(condicionesClimaticas.get(0).get("Temperature"), new Temperatura(18, 57, "F")); //Devuelve un número del 0 al 1
	}
}