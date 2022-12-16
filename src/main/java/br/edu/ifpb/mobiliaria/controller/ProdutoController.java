package br.edu.ifpb.mobiliaria.controller;

import br.edu.ifpb.mobiliaria.model.entity.Produto;
import br.edu.ifpb.mobiliaria.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Produto>> getAllProdutos(){
        return new ResponseEntity<>(produtoService.listarProdutos(), HttpStatus.OK) ;
    }

    @PostMapping
    public void saveProduto(@RequestBody Produto newProduto){
        produtoService.saveProduto(newProduto);
    }

    @PutMapping
    public void updateProduto(@RequestBody Produto produtoParaAtualizar){
        produtoService.updateProduto(produtoParaAtualizar);
    }

    @DeleteMapping
    public void deletarProduto(@RequestBody Produto produtoParaDeletar){
        produtoService.deletarProduto(produtoParaDeletar);
    }
}
