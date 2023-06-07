package com.cacti.workshop.microservices.web;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by domix on 8/12/16.
 */
@RestController
@RequestMapping("/path/{nombre}")
public class Lab02 {

  @GetMapping
  Map index(@PathVariable("nombre") String nombre) {
    Map result = Lab01.getMap();
    result.put("nombre", nombre);

    return result;
  }

  @PostMapping
  Map indexPost(@PathVariable("nombre") String nombre) {
    Map result = Lab01.getMap();
    result.put("nombre", nombre);
    result.put("method", "post");

    return result;
  }
}
