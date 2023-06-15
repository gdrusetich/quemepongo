package com.accuweather;

import ar.edu.utn.frba.dds.Temperatura;

public interface ServicioMeteorologico {
	Temperatura obtenerTemperaturaActualEnLaCiudad(String ciudad);
}