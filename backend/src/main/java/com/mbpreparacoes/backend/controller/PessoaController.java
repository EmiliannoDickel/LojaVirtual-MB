package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PessoaRepository;
import com.mbpreparacoes.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping ("/")
    public List<Pessoa> buscarTodas() {
        return pessoaService.buscarTodas();
    }

    @PostMapping("/")
    public Pessoa inserir (Pessoa objeto) {
        return pessoaService.inserir(objeto);
    }

    @PutMapping ("/")
    public Pessoa alterar (Pessoa objeto) {
        return pessoaService.alterar(objeto);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable("id") Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }




}
