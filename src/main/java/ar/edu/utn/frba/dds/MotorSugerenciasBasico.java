package ar.edu.utn.frba.dds;

import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;

public class MotorSugerenciasBasico implements MotorSugerencias{

	  public List<Prenda> getPrendasValidas(Usuario unUsuario) {
		    return unUsuario.getPrendas();
		  }
}
