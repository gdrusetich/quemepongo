package ar.edu.utn.frba.dds;

import java.time.LocalDateTime;

public record RespuestaMeteorologica(Temperatura unaTemperatura, LocalDateTime expiracion) {
  public boolean expiro() {
    return this.expiracion.isAfter(LocalDateTime.now());
  }
}

