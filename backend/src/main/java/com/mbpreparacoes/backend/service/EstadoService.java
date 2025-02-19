package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Estado;
import com.mbpreparacoes.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado buscarPorId(Long id) {
        Estado objeto = estadoRepository.findById(id).get();
        return objeto;
    }

    public Estado inserir(Estado objeto) {
        objeto.setDataCriacao(new Date());
        Estado objetoSalvo = estadoRepository.saveAndFlush(objeto);
        return objetoSalvo;
    }

    public Estado alterar(Estado objeto) {
        objeto.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long Id) {
        Estado objeto = estadoRepository.findById(Id).get();
        estadoRepository.delete(objeto);
    }

}
