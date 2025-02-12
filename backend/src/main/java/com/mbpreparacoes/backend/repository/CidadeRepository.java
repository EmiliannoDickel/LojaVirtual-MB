package com.mbpreparacoes.backend.repository;

import com.mbpreparacoes.backend.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
