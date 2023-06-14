package ar.edu.utn.frba.dds;

import com.google.common.base.Preconditions;

import dds.quemepongo.exceptions.NoCondiceConSuCategoriaException;
import dds.quemepongo.exceptions.NoCondiceConSuMaterialException;

public class Borrador {
	private TipoDePrenda tipo;
	private Categoria categoria;
	private Material material;
	private Trama trama;
	private Formalidad formalidad;
	private Color colorPrincipal;
	private Color colorSecundario;
	private Prenda prendaBorrador;

	public Borrador(TipoDePrenda unTipo) {
		Preconditions.checkNotNull(unTipo, "Debe elegir un tipo");
		this.tipo = unTipo;

	}

	public void especificarCategoria(Categoria unaCategoria) {
		Preconditions.checkNotNull(unaCategoria, "Debe elegir una categoría");
		if (!unaCategoria.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuCategoriaException("La categoria no condice con su tipo");		
		} else {

		this.categoria = unaCategoria;
		}
	}
	//Deberia ser private.
	public void validarCategoria(Categoria categoriaAEvaluar) {
		if (!categoriaAEvaluar.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuCategoriaException("La categoria no condice con su tipo");
		}
	}

	public void especificarTipo(TipoDePrenda unTipo) {
		Preconditions.checkNotNull(unTipo, "Debe elegir un tipo de prenda");
		this.tipo = unTipo;

	}

	public void especificarMaterial(Material unMaterial) {
		Preconditions.checkNotNull(unMaterial, "Debe elegir un material");
		if(!unMaterial.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuMaterialException("El materialno condice con su tipo");
		} else {
		this.material = unMaterial;
		}

	}
//Deberia ser private.
	public void validarMaterial(Material materialAEvaluar) {
		if (!materialAEvaluar.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuMaterialException("El material no condice con su tipo");
		}
	}

	public void especificarTrama(Trama unaTrama) {
		this.trama = unaTrama == null ? Trama.Lisa : trama;
	}

	public void especificarFormalidad(Formalidad unaFormalidad) {
		Preconditions.checkNotNull(unaFormalidad, "Debe elegir una formalidad");
		this.formalidad = unaFormalidad;
	}
	
	public void especificarColorPrincipal(Color unColorPrincipal) {
		Preconditions.checkNotNull(unColorPrincipal, "Debe elegir un color principal");
		this.colorPrincipal = unColorPrincipal;

	}

	public void especificarColorSecundario(Color unColorSecundario) {
		this.colorSecundario = unColorSecundario;
	}

	public Prenda crearPrenda() {
//		Preconditions.checkNotNull(this.categoria, "Debe elegir una categoría");
//		Preconditions.checkNotNull(this.material, "Debe elegir un material");
//		Preconditions.checkNotNull(this.colorPrincipal, "Debe elegir un color principal");
		this.prendaBorrador = new Prenda(this.categoria, this.tipo, this.material, this.trama, this.formalidad, this.colorPrincipal, this.colorSecundario);
		return this.prendaBorrador;
	}

}
