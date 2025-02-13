package com.mbpreparacoes.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "produto_imagens")
public class ProdutoImagens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    @ManyToOne
    @JoinColumn(name = "IdProduto")
    private Produto produto;

    private Date dataCriacao;
    private Date dataAtualizacao;

}
