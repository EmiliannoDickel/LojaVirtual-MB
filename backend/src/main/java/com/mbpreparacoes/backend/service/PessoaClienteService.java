package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.dto.PessoaClienteRequestDTO;
import com.mbpreparacoes.backend.entity.Email;
import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PessoaClienteRepository;
import com.mbpreparacoes.backend.validation.CpfValidar;
import com.mbpreparacoes.backend.validation.MailValidar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private CpfValidar cpfValidar;

    @Autowired
    private MailValidar mailValidar;

    @Autowired
    private EmailService emailService;

    public Pessoa inserir(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        try {
            if (!cpfValidar.validarCpf(pessoaClienteRequestDTO.getCpf())) {
                throw new IllegalArgumentException("CPF inválido: " + pessoaClienteRequestDTO.getCpf());
            }
            if (!MailValidar.validarMail(pessoaClienteRequestDTO.getEmail())) {
                throw new IllegalArgumentException("E-mail inválido: " + pessoaClienteRequestDTO.getEmail());
            }
            Pessoa pessoa = pessoaClienteRequestDTO.converter(pessoaClienteRequestDTO);
            pessoa.setDataCriacao(new Date());
            Pessoa objetoNovo = pessoaClienteRepository.saveAndFlush(pessoa);
            permissaoPessoaService.vincularPessoaPermisaoCliente(objetoNovo);
            Map<String, Object> proprMap = new HashMap<>();
            proprMap.put("nome", objetoNovo.getNome());
            proprMap.put("mensagem", "Cadastro Realizado Com sucesso!! Em alguns instântes você irá receber sua senha de acesso!");
            emailService.enviarEmailTemplate(objetoNovo.getEmail(),"Cadastro Loja MB-Preparações", proprMap);
            return objetoNovo;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
