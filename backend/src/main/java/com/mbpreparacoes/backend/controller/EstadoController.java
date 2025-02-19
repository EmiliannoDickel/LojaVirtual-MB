package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Estado;
import com.mbpreparacoes.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Long id) {
        Estado objeto = estadoService.buscarPorId(id);
        if (objeto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(objeto, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Estado> inserir(@RequestBody Estado objeto) {
        try {
            Estado estadoNovo = estadoService.inserir(objeto);
            return ResponseEntity.status(HttpStatus.CREATED).body(estadoNovo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
