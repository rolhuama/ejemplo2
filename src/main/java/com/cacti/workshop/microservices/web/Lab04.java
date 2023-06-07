package com.cacti.workshop.microservices.web;

import com.cacti.workshop.microservices.web.dto.Persona;
import com.cacti.workshop.microservices.web.resources.PersonaResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by domix on 8/12/16.
 */
@RestController
@RequestMapping("/people")
public class Lab04 {
  List<Persona> personas = new ArrayList<>();
  private AtomicInteger contador = new AtomicInteger();

  @GetMapping
  HttpEntity<PersonaResource> index() {

    PersonaResource resource = new PersonaResource(personas);
    resource.add(linkTo(methodOn(Lab04.class).index()).withRel("self"));
    resource.add(linkTo(methodOn(Lab04.class).add(new Persona())).withRel("add"));

    return ResponseEntity.ok(resource);

  }

  @GetMapping("/{id}")
  HttpEntity<PersonaResource> read(@PathVariable("id") Integer id) {

    PersonaResource resource = new PersonaResource(personas);
    resource.add(linkTo(methodOn(Lab04.class).index()).withSelfRel());
    resource.add(linkTo(methodOn(Lab04.class).add(new Persona())).withRel("add"));

    return ResponseEntity.ok(resource);

  }

  @PostMapping
  HttpEntity<PersonaResource> add(@RequestBody @Valid Persona nuevaPersona) {
    nuevaPersona.setId(contador.incrementAndGet());
    personas.add(nuevaPersona);

    PersonaResource resource = new PersonaResource(personas);
    resource.add(linkTo(methodOn(Lab04.class).index()).withRel("all"));
    resource.add(linkTo(methodOn(Lab04.class).add(nuevaPersona)).withSelfRel());
    resource.add(
      linkTo(methodOn(Lab04.class).read(nuevaPersona.getId()))
        .slash(nuevaPersona).withRel("read"));

    return ResponseEntity.ok(resource);
  }


}
