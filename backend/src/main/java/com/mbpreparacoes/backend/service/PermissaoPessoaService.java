package com.mbpreparacoes.backend.service;
import com.mbpreparacoes.backend.entity.Permissao;
import com.mbpreparacoes.backend.entity.PermissaoPessoa;
import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PermissaoPessoaRepository;
import com.mbpreparacoes.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PermissaoPessoaService {
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermisaoCliente (Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");
        if (listaPermissao.size() > 0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }
}
