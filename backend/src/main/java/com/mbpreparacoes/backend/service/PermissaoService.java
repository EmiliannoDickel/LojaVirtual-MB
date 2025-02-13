package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Permissao;
import com.mbpreparacoes.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodas() {
        return permissaoRepository.findAll();
    }

    public Permissao inserir (Permissao objeto) {
        objeto.setDataCriacao(new Date());
        Permissao objetoNovo = permissaoRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Permissao alterar (Permissao objeto) {
        objeto.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    public void excluir (Long id) {
        Permissao objeto = permissaoRepository.findById(id).get();
        permissaoRepository.delete(objeto);
    }
}
