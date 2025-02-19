package com.mbpreparacoes.backend.repository;

import com.mbpreparacoes.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {

}
