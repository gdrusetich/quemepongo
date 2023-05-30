package ar.edu.utn.frba.dds;
import java.util.*;

public class AccuWeatherFalsa implements ServicioClimatico{
	@Override
	public Temperatura getTemperaturaEnLaCiudad(String unaCiudad) {
		AccuWeatherAPI accuSimulacro = new AccuWeatherAPI();
		List<Map<String, Object>> condicionesClimaticas = accuSimulacro.getWeather(unaCiudad);
		HashMap temperature = (HashMap) condicionesClimaticas.get(0).get("Temperature");
		Temperatura temperatura = new Temperatura((int) temperature.get("Value"),  temperature.get("Unit") == "F" ? UnidadTemperatura.Fahrenheit : UnidadTemperatura.Celsius);
		
		return temperatura;
	}

}
