// Importações necessárias
package com.soulcode.estudandospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.estudandospring.model.Sessao;
import com.soulcode.estudandospring.model.Filme;
import com.soulcode.estudandospring.repository.SessaoRepository;
import com.soulcode.estudandospring.repository.FilmeRepository;

// Declaração da classe controladora Spring Boot para Sessões
@Controller
public class SessaoController {

    // Injeção de dependência dos repositórios de Sessão e Filme
    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    // Mapeamento para a rota "/sessoes" utilizando o método HTTP GET
    @GetMapping(value = "/sessoes")
    public ModelAndView sessoes() {
        // Obtém a lista de todas as sessões e filmes dos repositórios
        List<Sessao> sessoes = sessaoRepository.findAll();
        List<Filme> filmes = filmeRepository.findAll();
        
        // Cria e configura um objeto ModelAndView para a view "sessoes"
        ModelAndView mv = new ModelAndView("sessoes");
        mv.addObject("ses", sessoes); // Adiciona a lista de sessões como atributo para a view
        mv.addObject("fils", filmes); // Adiciona a lista de filmes como atributo para a view
        return mv; // Retorna o ModelAndView
    }

    // Mapeamento para a rota "/sessoes" utilizando o método HTTP POST
    @PostMapping(value = "/sessoes")
    public String create(@RequestParam Integer filmeId, Sessao sessao) {
        // Obtém um filme pelo ID fornecido no parâmetro da requisição
        Optional<Filme> filmeOpt = filmeRepository.findById(filmeId);
        
        // Verifica se o filme foi encontrado
        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();
            sessao.setFilme(filme); // Associa o filme à sessão
            sessaoRepository.save(sessao); // Salva a nova sessão no repositório
        }
        return "redirect:/sessoes"; // Redireciona para a rota "/sessoes"
    }
}
