package ar.edu.utn.frba.dds;

import java.util.List;
import java.util.Map;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.accuweather.AccuWeatherAPI;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {

	  private final AccuWeatherAPI api;
	  private final Duration periodoDeValidez;
	  private Map<String, RespuestaMeteorologica> ultimasRespuestas;

	  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
	    this.api = api;
	    this.periodoDeValidez = periodoDeValidez;
	    this.ultimasRespuestas = new HashMap<>();
	  }

	  public Temperatura getTemperaturaEnLaCiudad(String ciudad) {
	    if (!this.ultimasRespuestas.containsKey(ciudad) || this.ultimasRespuestas.get(ciudad).expiro()) {
	      ultimasRespuestas.put(ciudad, this.consultarApi(ciudad));
	    }
	    return this.ultimasRespuestas.get(ciudad).unaTemperatura();
	  }

	  private LocalDateTime proximaExpiracion() {
	    return LocalDateTime.now().plus(this.periodoDeValidez);
	  }

	  private RespuestaMeteorologica consultarApi(String direccion) {
	    var weather = this.api.getWeather(direccion);
	    return new RespuestaMeteorologica(
	            new Temperatura((int) weather.get("Temperature"), (UnidadTemperatura) weather.get("Unit")),
	            this.proximaExpiracion());
	  }
}
