// Importações necessárias
package com.soulcode.estudandospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.estudandospring.model.Cliente;
import com.soulcode.estudandospring.repository.ClienteRepository;

// Declaração da classe controladora Spring Boot
@Controller
public class ClienteController {

  // Injeção de dependência do ClienteRepository
  @Autowired
  private ClienteRepository clienteRepository;
  
  // Mapeamento para a rota "/clientes" utilizando o método HTTP GET
  @GetMapping(value = "/clientes")
  public ModelAndView clientes() {
    // Obtém a lista de todos os clientes do repositório
    List<Cliente> clientes = clienteRepository.findAll();
    
    // Cria e configura um objeto ModelAndView para a view "clientes"
    ModelAndView mv = new ModelAndView("clientes");
    mv.addObject("cls", clientes); // Adiciona a lista de clientes como atributo para a view
    return mv; // Retorna o ModelAndView
  }

  // Mapeamento para a rota "/clientes/{id}" utilizando o método HTTP GET
  @GetMapping(value = "/clientes/{id}")
  public ModelAndView clientById(@PathVariable Integer id) {
    // Obtém um cliente pelo ID fornecido na URL
    Optional<Cliente> clienteOpt = clienteRepository.findById(id);
    
    // Verifica se o cliente foi encontrado
    if(clienteOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      // Cria e configura um objeto ModelAndView para a view "cliente"
      ModelAndView mv = new ModelAndView("cliente");
      mv.addObject("cl", cliente); // Adiciona o cliente como atributo para a view
      return mv; // Retorna o ModelAndView
    }
    else {
      // Se o cliente não foi encontrado, cria um ModelAndView para a view "erro"
      ModelAndView erro = new ModelAndView("erro");
      return erro; // Retorna o ModelAndView
    }
  }

  // Mapeamento para a rota "/clientes/delete" utilizando o método HTTP POST
  @PostMapping(value = "/clientes/delete")
  public String delete(@RequestParam Integer id) {
    // Deleta um cliente pelo ID fornecido no parâmetro da requisição
    clienteRepository.deleteById(id);
    return "redirect:/clientes"; // Redireciona para a rota "/clientes"
  }

  // Mapeamento para a rota "/clientes" utilizando o método HTTP POST
  @PostMapping(value = "/clientes")
  public String create(Cliente cliente) {
    // Salva um novo cliente no repositório
    clienteRepository.save(cliente);
    return "redirect:/clientes"; // Redireciona para a rota "/clientes"
  }

  // Mapeamento para a rota "/clientes/{id}/edit" utilizando o método HTTP GET
  @GetMapping(value = "/clientes/{id}/edit")
  public ModelAndView update(@PathVariable Integer id){
    // Obtém um cliente pelo ID fornecido na URL
    Optional<Cliente> clientOpt = clienteRepository.findById(id);
    
    // Verifica se o cliente foi encontrado
    if(clientOpt.isPresent()) {
      // Cria e configura um objeto ModelAndView para a view "cliente-edit"
      ModelAndView mv = new ModelAndView("cliente-edit");
      Cliente cliente = clientOpt.get();
      mv.addObject("cl", cliente); // Adiciona o cliente como atributo para a view
      return mv; // Retorna o ModelAndView
    }
    else {
      // Se o cliente não foi encontrado, cria um ModelAndView para a view "erro"
      ModelAndView erro = new ModelAndView("erro");
      return erro; // Retorna o ModelAndView
    }
  }

  // Mapeamento para a rota "/clientes/edit" utilizando o método HTTP POST
  @PostMapping(value = "/clientes/edit")
  public String edit(Cliente cliente) {
    // Obtém um cliente pelo ID fornecido no objeto Cliente e salva as alterações no repositório
    Optional<Cliente> clientOpt = clienteRepository.findById(cliente.getId());
    if(clientOpt.isPresent()) {
      clienteRepository.save(cliente);
    }
    return "redirect:/clientes"; // Redireciona para a rota "/clientes"
  }
}
