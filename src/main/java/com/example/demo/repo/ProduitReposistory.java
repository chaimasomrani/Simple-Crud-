package com.example.demo.repo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Produit;

public interface ProduitReposistory  extends JpaRepository<Produit,Long>{
	public Page<Produit> findByDesignationContains(String mc,PageRequest pageRequest);
}
