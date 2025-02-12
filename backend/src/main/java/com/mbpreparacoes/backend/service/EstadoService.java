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

    public Estado inserir(Estado objeto) {
       Estado estadoSalvo = estadoRepository.saveAndFlush(objeto);
       return estadoSalvo;
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
