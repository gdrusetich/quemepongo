import ar.edu.utn.frba.dds.Material;
import ar.edu.utn.frba.dds.Prenda;
import ar.edu.utn.frba.dds.TipoDePrenda;
import ar.edu.utn.frba.dds.Trama;

public class Borrador{
private static final Trama Lisa = null;
TipoDePrenda tipo;
Material material;
Trama trama = Lisa;

Borrador(TipoDePrenda unTipo, Material unMaterial, Trama unaTrama){
this.tipo = unTipo;
this.material = unMaterial;
this.trama = unaTrama;
}

	void especificarTipo(TipoDePrenda unTipo) {
this.tipo = unTipo;
}

void especificarMaterial(Material unMaterial) {
	this.material = unMaterial;
}

void especificarTrama(Trama unaTrama) {
	this.trama = unaTrama;
}

Prenda crearPrenda() {
	return new Prenda(this.tipo, this.material, this.trama);
}

}
