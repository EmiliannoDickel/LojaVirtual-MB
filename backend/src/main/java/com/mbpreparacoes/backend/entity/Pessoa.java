package com.mbpreparacoes.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
@ToString (exclude = "permissoes")
@Builder

public class Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String senha;
    private String codigoRecuperacaoSenha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodigo;
    private String endereco;
    private String cep;

    @ManyToOne
    @JoinColumn (name = "id_Cidade")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn (name = "permissao_id")
    private Permissao permissao;



    private Date dataCriacao;
    private Date dataAtualizacao;




}
