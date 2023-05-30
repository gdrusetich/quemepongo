package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;

public class Usuario implements MotorSugerencias{

	List<Prenda> armario = new ArrayList<>();
	int edad;
	MotorSugerencias motorDeSugerencias;
	
	public Usuario(int edad, MotorSugerencias unMotor ) {
		this.edad = edad;
		this.motorDeSugerencias=unMotor;
	}
	
	List<Prenda> getPrendas(){
		return this.armario;
	}
	
	int getEdad(){
		return this.edad;
	}
	

	
	List<Sugerencia> generarSugerencias(this){
		return this.motorDeSugerencias.generarSugerencias();
	}
	
}