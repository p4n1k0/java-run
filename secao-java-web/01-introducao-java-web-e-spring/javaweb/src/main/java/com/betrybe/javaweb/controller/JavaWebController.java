package com.betrybe.javaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/javaweb")
public class JavaWebController {

  @GetMapping
  public String getJavaWeb() {
    return "Estou aprendendo a criar aplicações Java para a Web!";
  }

}
