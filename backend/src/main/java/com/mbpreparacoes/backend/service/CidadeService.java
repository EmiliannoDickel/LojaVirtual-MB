package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Cidade;
import com.mbpreparacoes.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodas() {
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade objeto) {
        objeto.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepository.saveAndFlush(objeto);
        return cidadeNova;
    }

    public Cidade alterar (Cidade objeto) {
        objeto.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(objeto);
    }

    public void excluir(Long Id) {
        Cidade objeto = cidadeRepository.findById(Id).get();
        cidadeRepository.delete(objeto);
    }


}
