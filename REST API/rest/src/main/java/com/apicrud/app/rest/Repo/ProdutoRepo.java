package com.apicrud.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apicrud.app.rest.model.Produto;

public interface ProdutoRepo extends JpaRepository<Produto, Long>{

}
