package com.mbpreparacoes.backend.repository;

import com.mbpreparacoes.backend.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
