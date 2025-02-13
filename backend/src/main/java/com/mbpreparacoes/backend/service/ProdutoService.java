package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Produto;
import com.mbpreparacoes.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto inserir (Produto objeto) {
        objeto.setDataCriacao(new Date());
        Produto objetoNovo = produtoRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Produto alterar (Produto objeto) {
        objeto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(objeto);
    }

    public void excluir (Long id) {
        Produto objeto = produtoRepository.findById(id).get();
        produtoRepository.delete(objeto);
    }
}
