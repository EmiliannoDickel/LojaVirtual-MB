package com.mbpreparacoes.backend.controller;


import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.service.PessoaGestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gerenciamento")
public class PessoaGestaoController {

    @Autowired
    PessoaGestaoService pessoaGestaoService;


    @PostMapping("/solicitar-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa) {
        return pessoaGestaoService.soliciarCodigo(pessoa.getEmail());
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha (@RequestBody Pessoa objeto) {
        return pessoaGestaoService.alterarSenha(objeto);
    }


}
