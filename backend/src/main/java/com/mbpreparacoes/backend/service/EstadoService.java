package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Estado;
import com.mbpreparacoes.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado) {
       Estado estadoSalvo = estadoRepository.saveAndFlush(estado);
       return estadoSalvo;
    }

    public Estado alterar(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void remover(Long Id) {
        Estado estado = estadoRepository.findById(Id).get();
        estadoRepository.delete(estado);
    }

}
