package com.cacti.workshop.microservices.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by domix on 8/12/16.
 */
//@Controller // Controller esta pensado para HTML (browser)
@RestController
public class Lab01 {


  //sirve para indicar que debe "renderizar" el objeto a un representación (JSON / XML)
  //@ResponseBody
  @RequestMapping("/")
  Map index() {
    return getMap();
  }

  @RequestMapping(path = "/", method = RequestMethod.POST)
  Map indexPost() {
    Map result = getMap();
    result.put("method", "post");
    return result;
  }

  public static Map getMap() {
    HashMap<String, Object> result = new HashMap<>();
    result.put("saludo", "Hola");
    return result;
  }

}
