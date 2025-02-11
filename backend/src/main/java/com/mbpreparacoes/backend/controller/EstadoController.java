package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Estado;
import com.mbpreparacoes.backend.repository.EstadoRepository;
import com.mbpreparacoes.backend.service.EstadoService;
import jakarta.websocket.server.PathParam;
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
    public Estado inserir(Estado estado) {
        return estadoService.inserir(estado);
    }

    @PutMapping("/")
    public Estado alterar(Estado estado) {
        return estadoService.alterar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id) {
        estadoService.remover(id);
        return ResponseEntity.ok().build();
    }

}
