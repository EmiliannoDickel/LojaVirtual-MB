package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Permissao;
import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PermissaoRepository;
import com.mbpreparacoes.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    //Pegar permissoes
    public List<Permissao> pegarPermissoesLista() {
        return permissaoRepository.findAll();
    }

    public Permissao pegarPermissaoId(Long id) {
        Optional<Permissao> permissaoId = permissaoRepository.findById(id);
        return permissaoId.orElse(null); //ou me mostra a permissao, ou passa null
    }


    public Permissao criarPermissao( Permissao permissoes) {
        permissoes.setDataCriacao(new Date());
        return permissaoRepository.save(permissoes);
    }

    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        // Busca a permissão "Cliente" no banco
        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");

        if (!listaPermissao.isEmpty()) {
            // Associa a permissão "Cliente" à pessoa
            pessoa.setPermissao(listaPermissao.get(0));  // Agora é um único objeto de permissão

            // Atualiza a data de criação da pessoa (opcional)
            pessoa.setDataCriacao(new Date());

            // Salva a pessoa com a nova permissão
            pessoaRepository.save(pessoa);
        }
    }


    public Permissao atualizarPermissaoID(Long id, Permissao permissaoAtualizada) {
        if (permissaoRepository.existsById(id)) {
            permissaoAtualizada.setDataAtualizacao(new Date());
            permissaoAtualizada.setId(id);
            return permissaoRepository.save(permissaoAtualizada);
        } else {
            return null;
        }
        }

        public void excluirPermissaoID (Long id) {
            permissaoRepository.deleteById(id);
        }
}
