package br.edu.ifpb.mobiliaria.model.repository;

import br.edu.ifpb.mobiliaria.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoIF extends JpaRepository<Produto,Long> {

}
