package com.produtos.apirest.resources;

import java.util.List;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST - PRODUTOS")
@CrossOrigin("*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Retorna a lista de produtos do Banco de dados")
    @GetMapping(value = "/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }
    
    @ApiOperation(value = "Retorna um produto do Banco de dados a partir do id")
    @GetMapping(value = "/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable (value="id") long id){
        return produtoRepository.findById(id);
    }

    @ApiOperation(value = "Salva um produto no Banco de dados")
    @PostMapping(value = "/produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @ApiOperation(value = "Remove um produto do Banco de dadose")
    @DeleteMapping(value = "/produto")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @ApiOperation(value = "Atualiza um produto do Banco de dados")
    @PutMapping(value = "/produto")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
