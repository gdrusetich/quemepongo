package ar.edu.utn.frba.dds;

public class ElegirServicioClimatico {
	static ServicioClimatico unServicioClimatico;

	static ServicioClimatico getServicioClimatico() {
		return unServicioClimatico;
	}
	
	static void setServicioClimatico(ServicioClimatico elegirServicioClimatico) {
		ElegirServicioClimatico.unServicioClimatico = elegirServicioClimatico;
	}

}
