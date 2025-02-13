package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Estado;
import com.mbpreparacoes.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {


    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estadoService.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody Estado objeto) {
        return estadoService.inserir(objeto);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado objeto) {
        return estadoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id) {
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
