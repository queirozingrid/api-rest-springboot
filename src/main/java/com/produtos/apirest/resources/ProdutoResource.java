package com.produtos.apirest.resources;

import java.util.List;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }
    
    @GetMapping(value = "/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable (value="id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping(value = "/produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
