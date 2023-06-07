package com.cacti.workshop.microservices.web.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.hateoas.Identifiable;

import javax.validation.constraints.NotNull;

/**
 * Created by domix on 8/12/16.
 */
public class Persona implements Identifiable<Integer> {
  @NotBlank
  private String nombre;
  @NotBlank
  private String apellidos;
  @NotNull
  private Integer edad;
  private Integer id;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
