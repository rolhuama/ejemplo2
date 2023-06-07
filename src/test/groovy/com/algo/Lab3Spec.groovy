package com.algo

import com.cacti.workshop.microservices.web.Lab03
import com.cacti.workshop.microservices.web.dto.Persona
import org.springframework.validation.BindingResult
import spock.lang.Specification

/**
 * Created by domix on 5/18/17.
 */
class Lab3Spec extends Specification {


  def 'agregar una nueva persona'() {
    given:
      Lab03 lab03 = new Lab03()
      Persona persona =
        new Persona(
          nombre: 'Juan', apellidos: 'Perez', edad: 35)

      BindingResult bindingResult = Mock()

      Persona personaResult =
        lab03.add(persona, bindingResult)
    expect:
      personaResult
      personaResult.id
  }

  def 'agregar una nueva persona con errores'() {
    given:
      Lab03 lab03 = new Lab03()
      Persona persona =
        new Persona(
          nombre: 'Juan', apellidos: 'Perez', edad: 35)

      BindingResult bindingResult = Stub()
      bindingResult.hasErrors() >> { true }

      Persona personaResult =
        lab03.add(persona, bindingResult)
    expect:
      personaResult
      !personaResult.id
  }
}
