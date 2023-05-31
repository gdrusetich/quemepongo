package ar.edu.utn.frba.dds;

import java.util.List;

public class MotorSugerenciasBasico implements MotorSugerencias {

	public List<Prenda> getPrendasValidas(Usuario unUsuario) {
		return unUsuario.getPrendas();
	}
}
