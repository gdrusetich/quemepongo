package ar.edu.utn.frba.dds;

import dds.quemepongo.exceptions.NoContieneEseGuardarropaException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	public List<Guardarropa> guardarropas = new ArrayList<>();
	int edad;
	private MotorSugerencias motorDeSugerencias;
	private List<Propuesta> propuestas = new ArrayList<>();

	public Usuario(int edad, MotorSugerencias unMotor) {
		this.edad = edad;
		this.motorDeSugerencias = unMotor;
	}

	public Guardarropa getGuardarropa(Guardarropa unGuardarropa) {
		if (guardarropas.contains(unGuardarropa)) {
			return unGuardarropa;
		} else {
			throw new NoContieneEseGuardarropaException("El usuario no dispone de ese guardarropa");

		}
	}

	public List<Prenda> getPrendas() {
		List<Prenda> prendas = new ArrayList<>();
		this.guardarropas.stream().map(guardarropa -> prendas.addAll(guardarropa.getPrendas()))
				.collect(Collectors.toList());
		return prendas;
	}

	List<Propuesta> getPropuestasAgregar() {
		PropuestaAgregar unaPropuesta = new PropuestaAgregar(new Prenda(null, null, null, null, null, null, null), new Guardarropa(new ArrayList<>()));
		return this.propuestas.stream().filter(propuesta->propuesta.getClass() == (unaPropuesta.getClass())).collect(Collectors.toList());
	}
	
	List<Propuesta> getPropuestasQuitar(){
		PropuestaQuitar unaPropuesta = new PropuestaQuitar(new Prenda(null, null, null, null, null, null, null), new Guardarropa(new ArrayList<>()));
		return this.propuestas.stream().filter(propuesta->propuesta.getClass() == (unaPropuesta.getClass())).collect(Collectors.toList());
	}
	/*
	 	public List<Prenda> getPrendas() {
		List<Prenda> prendas = new ArrayList<>();
		this.guardarropas.stream().map(guardarropa -> prendas.addAll(guardarropa.getPrendas()));
		return prendas;
	} 
	  
	 */

	/*
	  public List<Prenda> getPrendasDos(){ return
	 * this.guardarropas.concat(guardarropas).flatMap(g->g.getPrendas()); }
	 */
	Guardarropa crearGuardarropa() {
		Guardarropa guardarropa = new Guardarropa(new ArrayList<>());
		guardarropa.compartirCon(this);
		this.agregarGuardarropa(guardarropa);
		return guardarropa;
	}

	void agregarGuardarropa(Guardarropa unGuardarropas) {
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

	void proponerAgregar(Usuario unUsuario, Prenda unaPrenda, Guardarropa unGuardarropa) {
	PropuestaAgregar unaPropuesta = new PropuestaAgregar(unaPrenda, unGuardarropa);
		unUsuario.agregarPropuesta(unaPropuesta);
	}

	void proponerQuitar(Usuario unUsuario, Prenda unaPrenda, Guardarropa unGuardarropa) {
		PropuestaQuitar unaPropuesta = new PropuestaQuitar(unaPrenda, unGuardarropa);
		unUsuario.agregarPropuesta(unaPropuesta);
	}
	
	void agregarPropuesta(Propuesta unaPropuesta) {
		this.propuestas.add(unaPropuesta);
	}
	
	
	void aceptarTodasLasPropuestas() {
		this.propuestas.stream().forEach(propuesta->propuesta.aceptar());
		this.propuestas.clear();
	}


}