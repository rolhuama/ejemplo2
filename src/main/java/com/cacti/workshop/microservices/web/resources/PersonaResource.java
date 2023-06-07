package com.cacti.workshop.microservices.web.resources;

import com.cacti.workshop.microservices.web.dto.Persona;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by domix on 8/12/16.
 */
public class PersonaResource extends ResourceSupport {
  private final List<Persona> personas;

  public PersonaResource(List<Persona> personas) {
    this.personas = personas;
  }

  public List<Persona> getPersonas() {
    return personas;
  }
}
