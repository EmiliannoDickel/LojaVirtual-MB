package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.dto.PessoaClienteRequestDTO;
import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.service.PessoaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")

public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaService;
//usado para o cliente se registrar - automaticamente vai ser permissao - cliente


    @PostMapping("/")
    public ResponseEntity<PessoaClienteRequestDTO> inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        try {
            Pessoa objeto = pessoaService.inserir(pessoaClienteRequestDTO);
            PessoaClienteRequestDTO responseDTO = new PessoaClienteRequestDTO(objeto);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}

