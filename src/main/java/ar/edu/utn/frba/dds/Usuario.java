package ar.edu.utn.frba.dds;

import dds.quemepongo.exceptions.NoContieneEseGuardarropaException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	public List<Guardarropa> guardarropas = new ArrayList<>();
	int edad;
	private MotorSugerencias motorDeSugerencias;
	public List<Prenda> prendasAQuitar = new ArrayList<>();
	public List<Prenda> prendasAAgregar = new ArrayList<>();

	public Usuario(int edad, MotorSugerencias unMotor) {
		this.edad = edad;
		this.motorDeSugerencias = unMotor;
	}

	public Guardarropa getGuardarropa(Guardarropa unGuardarropa) {
		if(guardarropas.contains(unGuardarropa)) {
			return unGuardarropa;	
		} else {
			throw new NoContieneEseGuardarropaException("El usuario no dispone de ese guardarropa");
			
		}
	}
	
	public List<Prenda> getPrendas(){
		List<Prenda> prendas = new ArrayList<>();
		this.guardarropas.stream().map(guardarropa ->
		prendas.addAll(guardarropa.getPrendas()));
		return prendas;
	}
/*
	public List<Prenda> getPrendasDos(){
		return this.guardarropas.concat(guardarropas).flatMap(g->g.getPrendas());
	}
*/
	
	void agregarGuardarropas(Guardarropa unGuardarropas) {
		this.guardarropas.add(unGuardarropas);
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
	
	void proponerAgregar(Usuario unUsuario, Prenda unaPrenda) {
		unUsuario.prendasAAgregar.add(unaPrenda);
	}

	void proponerQuitar(Usuario unUsuario, Prenda unaPrenda) {
		unUsuario.prendasAQuitar.add(unaPrenda);
	}
	

}