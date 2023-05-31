package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	List<Prenda> armario = new ArrayList<>();
	int edad;
	MotorSugerencias motorDeSugerencias;

	public Usuario(int edad, MotorSugerencias unMotor) {
		this.edad = edad;
		this.motorDeSugerencias = unMotor;
	}

	public List<Prenda> getPrendas() {
		return this.armario;
	}

	public int getEdad() {
		return edad;
	}

	public MotorSugerencias getMotor() {
		return motorDeSugerencias;
	}

	List<Atuendo> generarSugerencias(String ciudad) {
		return this.motorDeSugerencias.generarSugerencias(this, ciudad);
	}

}