package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PermissaoRepository;
import com.mbpreparacoes.backend.repository.PessoaRepository;
import com.mbpreparacoes.backend.validation.CpfValidar;
import com.mbpreparacoes.backend.validation.MailValidar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private CpfValidar cpfValidar;

    @Autowired
    private MailValidar mailValidar;

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }

//    public Pessoa inserir(Pessoa objeto) {
//        // Verifica se o CPF é inválido
//        if (!cpfValidar.validarCpf(objeto.getCpf())) {
//            throw new IllegalArgumentException("CPF inválido: " + objeto.getCpf());
//        }
//        // Verifica se o e-mail é inválido
//        if (!MailValidar.validarMail(objeto.getEmail())) {
//            throw new IllegalArgumentException("E-mail inválido: " + objeto.getEmail());
//        }
//        return pessoaRepository.save(objeto);
//    }

    public Pessoa inserir(Pessoa objeto) {
        System.out.println("Recebendo objeto: " + objeto);

        try {
            if (!cpfValidar.validarCpf(objeto.getCpf())) {
                throw new IllegalArgumentException("CPF inválido: " + objeto.getCpf());
            }
            if (!MailValidar.validarMail(objeto.getEmail())) {
                throw new IllegalArgumentException("E-mail inválido: " + objeto.getEmail());
            }
            objeto.setDataCriacao(new Date());
            return pessoaRepository.save(objeto);

        } catch (IllegalArgumentException e) {
            throw e;  // Rethrow para ser capturado no controlador de exceções
        }
    }


    public Pessoa pegarPessoaId (Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    public Pessoa atualizarPessoaId (Long id, Pessoa pessoaAtualizada) {
        if (pessoaRepository.existsById(id) && cpfValidar.validarCpf(pessoaAtualizada.getCpf())) {
            pessoaAtualizada.setDataAtualizacao(new Date());
            pessoaAtualizada.setId(id);
            return pessoaRepository.save(pessoaAtualizada);
        } else {
            return null;
        }
    }

    public void excluir(Long Id) {
        Pessoa objeto = pessoaRepository.findById(Id).get();
        pessoaRepository.delete(objeto);
    }
}