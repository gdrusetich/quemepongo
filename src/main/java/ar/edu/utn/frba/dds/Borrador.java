package ar.edu.utn.frba.dds;

import com.google.common.base.Preconditions;

import dds.quemepongo.exceptions.NoCondiceConSuCategoriaException;
import dds.quemepongo.exceptions.NoCondiceConSuMaterialException;

public class Borrador {
	private Categoria categoria;
	private TipoDePrenda tipo;
	private Material material;
	private Trama trama;
	private Color colorPrincipal;
	private Color colorSecundario;
	private Prenda prendaBorrador;
	
	public Borrador(TipoDePrenda unTipo) {
		Preconditions.checkNotNull(unTipo, "Debe elegir un tipo");
		this.tipo = unTipo;
	}

	void especificarCategoria(Categoria unaCategoria) {
		Preconditions.checkNotNull(categoria, "Debe elegir una categoría");
		this.validarCategoria(this.categoria);
		this.categoria = unaCategoria;
	}
	private void validarCategoria(Categoria categoriaAEvaluar) {
		if(!categoriaAEvaluar.condiceConElTipo(tipo)) {
			throw new NoCondiceConSuCategoriaException("La categoria no condice con su tipo");
		}
	}
	
	void especificarTipo(TipoDePrenda unTipo) {
		Preconditions.checkNotNull(tipo, "Debe elegir un tipo de prenda");
		this.tipo = unTipo;
	}
		
	void especificarMaterial(Material unMaterial) {
		Preconditions.checkNotNull(material, "Debe elegir un material");
		this.validarMaterial(this.material);
		this.material = unMaterial;
	}	
	private void validarMaterial(Material materialAEvaluar) {
		if(!materialAEvaluar.condiceConElTipo(this.tipo)) {
			throw new NoCondiceConSuMaterialException("El material no condice con su tipo");		
		}
	}

	void especificarTrama(Trama unaTrama) {
		this.trama = unaTrama == null ? Trama.Lisa : trama;
	}
	
	void especificarColorPrincipal(Color unColorPrincipal) {
		Preconditions.checkNotNull(colorPrincipal, "Debe elegir un color principal");
		this.colorPrincipal = unColorPrincipal;
	}
	
	public void especificarColorSecundario(Color unColorSecundario) {
		this.colorSecundario = unColorSecundario;
	}
	
	public Prenda crearPrenda() {
		Preconditions.checkNotNull(this.categoria, "Debe elegir una categoría");
		Preconditions.checkNotNull(this.material, "Debe elegir un material");
		Preconditions.checkNotNull(this.colorPrincipal, "Debe elegir un color principal");
		prendaBorrador = new Prenda(categoria, tipo, material, trama, colorPrincipal, colorSecundario);
		return prendaBorrador;
				
	}
	
	
}
