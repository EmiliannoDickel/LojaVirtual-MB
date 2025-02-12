package com.mbpreparacoes.backend.repository;

import com.mbpreparacoes.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
