package ar.edu.utn.frba.dds;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.accuweather.AccuWeatherAPI;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico{
	  @Override
	  public Temperatura getTemperaturaEnLaCiudad(String ciudad) {
	    AccuWeatherAPI apiClima = new AccuWeatherAPI();
	    List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(ciudad);
	    HashMap temperature = (HashMap) condicionesClimaticas.get(0).get("Temperature");
	    Temperatura temperatura = new Temperatura((int) temperature.get("Value"),temperature.get("Unit") == "F" ? UnidadTemperatura.Fahrenheit: UnidadTemperatura.Celsius
	    );

	    return temperatura;
	  }
}
