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

	  public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
	    if (!this.ultimasRespuestas.containsKey(direccion) || this.ultimasRespuestas.get(direccion).expiro()) {
	      ultimasRespuestas.put(direccion, this.consultarApi(direccion));
	    }
	    return this.ultimasRespuestas.get(direccion).getTemperaturaEnLaCiudad("Buenos Aires");
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
