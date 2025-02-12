package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PessoaRepository;
import com.mbpreparacoes.backend.validation.CpfValidar;
import com.mbpreparacoes.backend.validation.MailValidar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CpfValidar cpfValidar;

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa objeto) {
        // Verifica se o CPF é inválido
        if (!cpfValidar.validarCpf(objeto.getCpf())) {
            throw new IllegalArgumentException("CPF inválido: " + objeto.getCpf());
        }
        // Verifica se o e-mail é inválido
        if (!MailValidar.validarMail(objeto.getEmail())) {
            throw new IllegalArgumentException("E-mail inválido: " + objeto.getEmail());
        }
        return pessoaRepository.save(objeto);
    }



    public Pessoa alterar(Pessoa objeto) {
        if (!cpfValidar.validarCpf(objeto.getCpf())) {
            objeto.setDataAtualizacao(new Date());
            return pessoaRepository.saveAndFlush(objeto);
        } else {
            IllegalAccessError error = new IllegalAccessError();
            error.printStackTrace();
            return null;
        }
    }

    public void excluir (Long Id) {
        Pessoa objeto = pessoaRepository.findById(Id).get();
        pessoaRepository.delete(objeto);
    }
}