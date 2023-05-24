package ar.edu.utn.frba.dds;

public class Prenda {
	private Categoria categoria;
	private TipoDePrenda tipo;
	private Material material;
	private Trama trama;
	private Color colorPrincipal;
	private Color colorSecundario;

	public Prenda(Categoria categoria, TipoDePrenda tipo, Material material, Trama trama, Color colorPrincipal, Color colorSecundario) {
		this.categoria = categoria;
		this.tipo = tipo;
		this.material = material;
		this.trama = trama;
		this.colorPrincipal = colorPrincipal;
		this.colorSecundario = colorSecundario;
	}

	TipoDePrenda getTipo() {
		return this.tipo;
	}

	Material getMaterial() {
		return this.material;
	}

	Categoria getCategoria() {
		return this.categoria;
	}

	Trama getTrama() {
		return this.trama;
	}
	
	Color getColorPrincipal() {
		return this.colorPrincipal;
	}
	
	Color getColorSecundario() {
		return this.colorSecundario;
	}
}