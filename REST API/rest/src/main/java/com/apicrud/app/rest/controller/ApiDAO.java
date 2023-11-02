package com.apicrud.app.rest.controller;
import com.apicrud.app.rest.Repo.ProdutoRepo;
import com.apicrud.app.rest.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiDAO {
    @Autowired
    private ProdutoRepo produtoRepo;

    @GetMapping(value="/")
    public String getPage(){
        return "Hello World";
    }
    @GetMapping(value = "/produto")
    public List<Produto> getProduto(){
        return produtoRepo.findAll();
    }

    @PostMapping(value="/gravar")
    public String gravarProduto(@RequestBody Produto produto){
        produtoRepo.save(produto);
        return "salvo com sucesso";
    }

    @PutMapping(value = "/atualiza/{codigo}")
    public String atualizarProduto(@PathVariable Long codigo,@RequestBody Produto produto){
        Produto p = produtoRepo.findById(codigo).get();
        p.setDescricao(produto.getDescricao());
        p.setPreco(produto.getPreco());
        p.setQtde(produto.getQtde());
        produtoRepo.save(p);
        return  "atualizado";
    }

    @DeleteMapping(value = "/deletar/{codigo}")
    public String removeProduto(@PathVariable Long codigo){
        Produto p = produtoRepo.findById(codigo).get();
        produtoRepo.delete(p);
        return "removido";
    }
}
