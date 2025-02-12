package com.mbpreparacoes.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn (name = "idEstado")
    private Estado estado;
    private Date dataCriacao;
    private Date dataAtualizacao;

}
