// Importações necessárias
package com.soulcode.estudandospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Declaração da classe controladora Spring Boot para a home e o contato
@Controller
public class HomeController {
  
  // Mapeamento para as rotas "/", "/home" e "/h" utilizando o método HTTP GET
  @GetMapping(value = {"/", "/home", "/h"})
  public String home() {
    // Retorna o nome da view "index" para a home
    return "index";
  }

  // Mapeamento para a rota "/contato" utilizando o método HTTP GET
  @GetMapping(value = "/contato")
  public String contato() {
    // Retorna o nome da view "contato" para a página de contato
    return "contato";
  }
}
