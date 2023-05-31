package ar.edu.utn.frba.dds;

import java.util.List;

public class AsesorDeImagen {
private ServicioMeteorologico servicioMeteorologico;

public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico) {
	this.servicioMeteorologico = servicioMeteorologico;
}

public Sugerencia sugerirAtuendo(Usuario unUsuario, String unaCiudad) {
	Temperatura temperaturaDelDia = this.servicioMeteorologico.getTemperaturaEnLaCiudad(unaCiudad);
	List<Sugerencia> combinaciones = unUsuario.generarSugerencias(unaCiudad);
	return combinaciones.stream().filter(combinacion -> combinacion.esAptaParaTemperatura(temperaturaDelDia)).findFirst().get();
}
}
