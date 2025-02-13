package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Marca;
import com.mbpreparacoes.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodas() {
        return marcaRepository.findAll();
    }

    public Marca inserir (Marca objeto) {
        objeto.setDataCriacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(objeto);
        return marcaNova;
    }

    public Marca alterar (Marca objeto) {
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public void excluir (Long Id){
        Marca objeto = marcaRepository.findById(Id).get();
        marcaRepository.delete(objeto);
    }

}
