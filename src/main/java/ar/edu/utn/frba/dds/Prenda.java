package ar.edu.utn.frba.dds;
public class Prenda {
public TipoDePrenda tipo;
public Material material;
public Categoria categoria;
public Trama trama;
int Color;

public Prenda(TipoDePrenda tipo, Material material, Trama trama){
	this.tipo = tipo;
	this.material = material;
	this.trama = trama;
}
	TipoDePrenda queTipo() {
		return this.tipo;
	}
	Material queMaterial(){
		return this.material;
	}
	Categoria queCategoria() {
		return this.categoria;
	}
	
	Trama queTrama() {
		return this.trama;
	}
}