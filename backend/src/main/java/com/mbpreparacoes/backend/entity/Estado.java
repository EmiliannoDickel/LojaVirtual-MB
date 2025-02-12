package com.mbpreparacoes.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table (name = "estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sigla;
    private Date DataCriacao;
    private Date dataAtualizacao;


}
