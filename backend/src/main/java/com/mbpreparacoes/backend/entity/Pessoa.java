package com.mbpreparacoes.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
@Builder

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereco;
    private String cep;
    @ManyToOne
    @JoinColumn (name = "idCidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //orphan vai apagar no banco de dados os elementos que nao estiverem na lista
    @Setter(value = AccessLevel.NONE) //removi o setter automatico do loombock
    private List<PermissaoPessoa>  permissaoPessoas;


    private Date dataCriacao;
    private Date dataAtualizacao;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for (PermissaoPessoa p : pp) {
            p.setPessoa(this);
        } this.permissaoPessoas = pp;
    }

}
