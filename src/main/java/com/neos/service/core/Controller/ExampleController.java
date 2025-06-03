package com.neos.service.core.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neos.service.core.Entity.Example;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

@Profile("core")
@RestController
@RequestMapping("/core")
public class ExampleController {
  @GetMapping
  private Example obtenerExample() {
    return new Example(1L,"Christian", "Roa");
  }
}
