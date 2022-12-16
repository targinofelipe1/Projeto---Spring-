package br.edu.ifpb.mobiliaria.model.service;

import br.edu.ifpb.mobiliaria.model.entity.Produto;
import br.edu.ifpb.mobiliaria.model.repository.ProdutoIF;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoIF produtoRepository;

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @Transactional
    public void saveProduto(Produto newProduto){
        produtoRepository.save(newProduto);
    }

    @Transactional
    public void updateProduto(Produto produtoParaAtualizar){
        Produto produtoPesquisado = produtoRepository.findById(produtoParaAtualizar.getId()).orElse(null);
        if(produtoPesquisado == null){
            saveProduto(produtoParaAtualizar);
            return;
        }
        produtoRepository.save(produtoParaAtualizar);
    }

    @Transactional
    public void deletarProduto(Produto produtoParaDeletar){
        produtoRepository.deleteById(produtoParaDeletar.getId());
    }

}
