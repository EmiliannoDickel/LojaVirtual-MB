package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Permissao;
import com.mbpreparacoes.backend.entity.Pessoa;
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

    @PostMapping("/")
    public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa objeto) {
        System.out.println("CPF recebido: " + objeto.getCpf());

        try {
            // Chama o serviço para salvar a pessoa e obter a pessoa com ID gerado
            Pessoa novaPessoa = pessoaService.inserir(objeto);

            // Retorna a nova pessoa com o ID gerado no banco
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
        } catch (IllegalArgumentException e) {
            // Se ocorrer erro de validação, retorna 400 com erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



    @PutMapping ("/{id}") //atualizar pelo ID
    public ResponseEntity<String> alterar (@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        if (pessoaService.pegarPessoaId(id) != null) {
            pessoaService.atualizarPessoaId(id, pessoaAtualizada);
            return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa não encontrada!");
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable("id") Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }





}
