package com.mbpreparacoes.backend.dto;

import com.mbpreparacoes.backend.entity.Cidade;
import com.mbpreparacoes.backend.entity.Pessoa;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaClienteRequestDTO {
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Pessoa converter (PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa);
        return pessoa;
    }

    public PessoaClienteRequestDTO (Pessoa pessoa){
        BeanUtils.copyProperties(pessoa, this);
    }
}
