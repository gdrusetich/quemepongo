package ar.edu.utn.frba.dds;

import com.google.common.base.Preconditions;

import dds.quemepongo.exceptions.NoCondiceConSuCategoriaException;
import dds.quemepongo.exceptions.NoCondiceConSuMaterialException;

public class Borrador {
	private Categoria categoria;
	private TipoDePrenda tipo;
	private Material material;
	private Trama trama;
	private Formalidad formalidad;
	private Color colorPrincipal;
	private Color colorSecundario;
	private Prenda prendaBorrador;
	
	public Borrador(TipoDePrenda unTipo) {
		this.tipo = unTipo;
		Preconditions.checkNotNull(unTipo, "Debe elegir un tipo");
	}

	public void especificarCategoria(Categoria unaCategoria) {
		this.validarCategoria(this.categoria);
		this.categoria = unaCategoria;
		Preconditions.checkNotNull(unaCategoria, "Debe elegir una categoría");
	}
	private void validarCategoria(Categoria categoriaAEvaluar) {
		if(!categoriaAEvaluar.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuCategoriaException("La categoria no condice con su tipo");
		}
	}
	
	public void especificarTipo(TipoDePrenda unTipo) {
		this.tipo = unTipo;
		Preconditions.checkNotNull(tipo, "Debe elegir un tipo de prenda");
	}
		
	public void especificarMaterial(Material unMaterial) {
		this.validarMaterial(this.material);
		this.material = unMaterial;
		Preconditions.checkNotNull(material, "Debe elegir un material");

	}	
	private void validarMaterial(Material materialAEvaluar) {
		if(!materialAEvaluar.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuMaterialException("El material no condice con su tipo");		
		}
	}

	public void especificarTrama(Trama unaTrama) {
		this.trama = unaTrama == null ? Trama.Lisa : trama;
	}
	
	public void especificarColorPrincipal(Color unColorPrincipal) {
		this.colorPrincipal = unColorPrincipal;
		Preconditions.checkNotNull(colorPrincipal, "Debe elegir un color principal");
	}
	
	public void especificarColorSecundario(Color unColorSecundario) {
		this.colorSecundario = unColorSecundario;
	}
	
	public void especificarFormalidad(Formalidad unaFormalidad) {
		this.formalidad = unaFormalidad;
		Preconditions.checkNotNull(formalidad, "Debe elegir una formalidad");
	}
	
	public Prenda crearPrenda() {
		Preconditions.checkNotNull(this.categoria, "Debe elegir una categoría");
		Preconditions.checkNotNull(this.material, "Debe elegir un material");
		Preconditions.checkNotNull(this.colorPrincipal, "Debe elegir un color principal");
		prendaBorrador = new Prenda(categoria, tipo, material, trama, formalidad, colorPrincipal, colorSecundario);
		return prendaBorrador;
				
	}
	
	
}
