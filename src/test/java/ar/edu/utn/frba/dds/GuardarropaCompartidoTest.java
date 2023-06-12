package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.*;
import java.util.ArrayList;

public class GuardarropaCompartidoTest {
Guardarropa guardarropaCompartido = new Guardarropa(new ArrayList<>());
Usuario german = new Usuario(32, new MotorSugerenciasBasico());
Usuario laura = new Usuario(42, new MotorSugerenciasBasico());
german.agregarGuardarropas(guardarropaCompartido);
}
