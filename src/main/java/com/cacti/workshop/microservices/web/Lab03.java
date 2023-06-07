package com.cacti.workshop.microservices.web;

import com.cacti.workshop.microservices.web.dto.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by domix on 8/12/16.
 */
@RestController
@RequestMapping("/personas")
public class Lab03 {
  private AtomicInteger contador = new AtomicInteger();



  //No manejamos errores de manera correcta acorde a REST
  @PostMapping("/")
  public Persona add(@RequestBody @Valid Persona nuevaPersona, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      for (ObjectError error : bindingResult.getAllErrors()) {
        System.out.println(error.toString());
      }
    } else {
      nuevaPersona.setId(contador.incrementAndGet());
    }

    return nuevaPersona;
  }

  @PostMapping("/rest")
  public ResponseEntity addRestful(@RequestBody @Valid Persona nuevaPersona, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      for (ObjectError error : bindingResult.getAllErrors()) {
        System.out.println(error.toString());
      }
      return ResponseEntity.unprocessableEntity().body(bindingResult.getAllErrors());
    } else {
      nuevaPersona.setId(contador.incrementAndGet());
    }

    return ResponseEntity.ok(nuevaPersona);
  }
}
