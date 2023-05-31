package ar.edu.utn.frba.dds;

public class ElegirServicioMeteorologico {
	static ServicioMeteorologico unServicioClimatico;

	static ServicioMeteorologico getServicioClimatico() {
		return unServicioClimatico;
	}
	
	static void setServicioClimatico(ServicioMeteorologico elegirServicioClimatico) {
		ElegirServicioMeteorologico.unServicioClimatico = elegirServicioClimatico;
	}
}
