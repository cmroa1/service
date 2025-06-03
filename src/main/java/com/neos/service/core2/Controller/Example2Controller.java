package com.neos.service.core2.Controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neos.service.core2.Entity.Example2;

@Profile("core2")
@RestController
@RequestMapping("/core2")
public class Example2Controller {
  @GetMapping
  private Example2 obtenerExample() {
    return new Example2(1L,"Nombre2", "Apellido2");
  }
}
