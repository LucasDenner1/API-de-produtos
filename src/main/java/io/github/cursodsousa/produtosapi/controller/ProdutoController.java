package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Produto;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto obertPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletarProduto(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }
}

