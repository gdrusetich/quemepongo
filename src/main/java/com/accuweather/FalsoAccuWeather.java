package com.accuweather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.utn.frba.dds.Temperatura;

public class FalsoAccuWeather implements ServicioMeteorologico {
	AccuWeatherAPI apiFalsa = new AccuWeatherAPI();

	Temperatura obtenerTemperaturaActualEnLaCiudad(String unaCiudad) {

		List<Map<String, Temperatura>> condicionesClimaticas = apiFalsa.getWeather(unaCiudad);
		Temperatura temperaturaActual = condicionesClimaticas.get(0).get("Temperature");

		return temperaturaActual;

	}

}
