package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Produto;
import com.mbpreparacoes.backend.entity.ProdutoImagens;
import com.mbpreparacoes.backend.repository.ProdutoImagensRepository;
import com.mbpreparacoes.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objetoNovo = new ProdutoImagens();

        try { if (!file.isEmpty()) {
        byte[] bytes = file.getBytes();
        String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
        Path caminho = Paths
                .get("C:\\Users\\Usuario\\Documents\\Programação\\MB Preparações\\img\\" + nomeImagem); //caminho da img
            Files.write(caminho, bytes);
            objetoNovo.setNome(nomeImagem);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        objetoNovo.setProduto(produto);
        objetoNovo.setDataCriacao(new Date());
        objetoNovo = produtoImagensRepository.saveAndFlush(objetoNovo);
        return objetoNovo;
    }

    public ProdutoImagens alterar(ProdutoImagens objeto) {
        objeto.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(objeto);
    }

    public void excluir(Long Id) {
        ProdutoImagens objeto = produtoImagensRepository.findById(Id).get();
        produtoImagensRepository.delete(objeto);
    }
}
