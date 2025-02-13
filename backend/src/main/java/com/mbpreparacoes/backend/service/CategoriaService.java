package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Categoria;
import com.mbpreparacoes.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir (Categoria objeto) {
        objeto.setDataCriacao(new Date());
        Categoria categoriaNova = categoriaRepository.saveAndFlush(objeto);
        return categoriaNova;
    }

    public Categoria alterar (Categoria objeto) {
        objeto.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(objeto);
    }

    public void excluir (Long Id){
        Categoria objeto = categoriaRepository.findById(Id).get();
        categoriaRepository.delete(objeto);
    }
}
