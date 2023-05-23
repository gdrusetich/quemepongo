package ar.edu.utn.frba.dds;

import dds.quemepongo.exceptions.NoCondiceConSuCategoriaException;
import java.util.ArrayList;
import java.util.List;

public class Atuendo {

	private static final Categoria ParteSuperior = null;
	private static final Categoria ParteInferior = null;
	private static final Categoria Calzado = null;
	private static final Categoria Accesorio = null;

	private List<Prenda> prendas = new ArrayList<>();

	Atuendo(Prenda unaPrendaSuperior, Prenda unaPrendaInferior, Prenda unCalzado, Prenda unAccesorio) {
		if (unaPrendaSuperior.queCategoria() != ParteSuperior) {
			throw new NoCondiceConSuCategoriaException("La parte superior no condice con su tipo");
		}
		if (unaPrendaInferior.queCategoria() != ParteInferior) {
			throw new NoCondiceConSuCategoriaException("La parte inferior no condice con su tipo");
		}
		this.prendas.add(unaPrendaInferior);
		if (unCalzado.queCategoria() != Calzado) {
			throw new NoCondiceConSuCategoriaException("El calzado no condice con su tipo");
		}
		if (unAccesorio.queCategoria() != Accesorio) {
			throw new NoCondiceConSuCategoriaException("El accesorio no condice con su tipo");
		}
		this.prendas.add(unaPrendaSuperior);
		this.prendas.add(unaPrendaInferior);
		this.prendas.add(unCalzado);
		this.prendas.add(unAccesorio);
	}
}
