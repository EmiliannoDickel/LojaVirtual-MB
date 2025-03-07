package com.mbpreparacoes.backend.controller;

import com.mbpreparacoes.backend.entity.Permissao;
import com.mbpreparacoes.backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")

public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/") //pegar lista de todas permissoes
    public ResponseEntity<List<Permissao>> pegarPermissoesLista () {
        List<Permissao> permissaoLista = permissaoService.pegarPermissoesLista();
        return ResponseEntity.status(HttpStatus.OK).body(permissaoLista);
    }

    @GetMapping("/{id}") //pegar permissao pelo ID
    public ResponseEntity<?> pegarPermissaoId (@PathVariable Long id) {
        Permissao permissoes = permissaoService.pegarPermissaoId(id);
        if (permissoes != null) {
            return ResponseEntity.ok(permissoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Permissão: " + id + " não Encontrada!");
        }
    }

    @PostMapping("/") //Criar permissao
    public ResponseEntity<String> criarPermissao (@RequestBody Permissao permissao) {
        Permissao permissaoNova = permissaoService.criarPermissao(permissao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Permissão Criada com Sucesso! "+ permissaoNova.getNome() );
    }

    @DeleteMapping("/{id}") //deletar pelo ID
    public ResponseEntity<String> excluir (@PathVariable("id") Long id) {
        if (permissaoService.pegarPermissaoId(id) != null) {
            permissaoService.excluirPermissaoID(id);
            return ResponseEntity.ok("Permissão" + id + " removida do Sistema!");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Permissão Com ID " + id + "não Encontrada!");
        }
    }

    @PutMapping("/alterar/{id}") //atualizar pelo ID
    public ResponseEntity<String> atualizarPermissao(@PathVariable Long id, @RequestBody Permissao permissaoAtualizada ) {

        if (permissaoService.pegarPermissaoId(id) != null) {
            permissaoService.atualizarPermissaoID(id, permissaoAtualizada);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Permissão " + permissaoAtualizada.getNome() + " Alterada!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Permissão não encontrada!");
        }
    }





}
