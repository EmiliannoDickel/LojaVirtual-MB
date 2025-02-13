package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PessoaRepository;
import com.mbpreparacoes.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @PostMapping("/")
//    public Pessoa inserir (Pessoa objeto) {
//        return pessoaService.inserir(objeto);
//    }

    @PostMapping("/")
    public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa pessoa) {
        System.out.println("CPF recebido: " + pessoa.getCpf());

        try {
            Pessoa novaPessoa = pessoaService.inserir(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
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
