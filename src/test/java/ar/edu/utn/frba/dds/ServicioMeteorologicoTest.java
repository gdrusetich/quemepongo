package ar.edu.utn.frba.dds;
import com.accuweather.AccuWeatherAPI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;

public class ServicioMeteorologicoTest {

	@Test
void sePuedenGenerarAtuendosParaBsAsCon18Grados() {
	ServicioMeteorologico servicio = Mockito.mock(ServicioMeteorologico.class);
	var unUsuario = new Usuario(32, new MotorSugerenciasBasico());

	var asesor = new AsesorDeImagen(servicio);
	
	Assertions.assertNotNull(asesor.sugerirAtuendo(unUsuario, "Buenos Aires"));
	}	


@Test
void sePuedeConsultarPorElClimaEnBuenosAiresUnDiaFrio() {
	AccuWeatherAPI api = Mockito.mock(AccuWeatherAPI.class);
	
	var asesor = new ServicioMeteorologicoAccuWeather();
}
}
