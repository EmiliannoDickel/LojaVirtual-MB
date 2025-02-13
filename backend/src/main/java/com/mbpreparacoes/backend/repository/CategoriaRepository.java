package com.mbpreparacoes.backend.repository;

import com.mbpreparacoes.backend.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
