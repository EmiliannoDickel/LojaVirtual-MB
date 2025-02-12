package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Cidade;
import com.mbpreparacoes.backend.repository.CidadeRepository;
import com.mbpreparacoes.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodas() {
        return cidadeService.buscarTodas();
    }

    @PostMapping("/")
    public Cidade inserir(Cidade objeto) {
        return cidadeService.inserir(objeto);
    }

    @PutMapping("/")
    public Cidade alterar(Cidade objeto) {
        return cidadeService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
