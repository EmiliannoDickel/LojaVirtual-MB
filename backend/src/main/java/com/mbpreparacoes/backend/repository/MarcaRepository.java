package com.mbpreparacoes.backend.repository;

import com.mbpreparacoes.backend.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
