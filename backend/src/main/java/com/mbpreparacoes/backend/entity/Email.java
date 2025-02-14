package com.mbpreparacoes.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Email {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private Long id;


    private String destinatario;
    private String titulo;
    private String mensagem;
}
