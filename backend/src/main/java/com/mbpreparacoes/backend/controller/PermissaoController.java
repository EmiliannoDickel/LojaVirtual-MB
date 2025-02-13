package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Permissao;
import com.mbpreparacoes.backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")

public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodas () {
        return permissaoService.buscarTodas();
    }

    @PostMapping("/")
    public Permissao inserir (@RequestBody Permissao objeto) {
        return permissaoService.inserir(objeto);
    }

    @PutMapping("/")
    public Permissao alterar (@RequestBody Permissao objeto) {
        return permissaoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable("id") Long id) {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
