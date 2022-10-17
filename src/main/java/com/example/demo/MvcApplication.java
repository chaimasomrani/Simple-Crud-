package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Roles;
import com.example.demo.repo.ProduitReposistory;
import com.example.demo.repo.RolesRepository;
import com.example.demo.repo.UsersRepository;

@SpringBootApplication
public class MvcApplication implements CommandLineRunner{
	@Autowired
	private ProduitReposistory produitReposistory;
	



	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitReposistory.save(new Produit(null,"PC",5000,30));
		produitReposistory.save(new Produit(null,"Scanner",2500,25));
		produitReposistory.save(new Produit(null,"Clavier",20,100));
		produitReposistory.save(new Produit(null,"Souris",5,28));
		produitReposistory.save(new Produit(null,"Chargeur",5000,30));
		produitReposistory.save(new Produit(null,"Telephone",2500,25));
		produitReposistory.save(new Produit(null,"Cable",20,100));
		produitReposistory.save(new Produit(null,"Souris",5,28));
		produitReposistory.save(new Produit(null,"PC",5000,30));
		produitReposistory.save(new Produit(null,"Scanner",2500,25));
		produitReposistory.save(new Produit(null,"Clavier",20,100));
		produitReposistory.save(new Produit(null,"Souris",5,28));
		produitReposistory.save(new Produit(null,"PC",5000,30));
		produitReposistory.save(new Produit(null,"Scanner",2500,25));
		produitReposistory.save(new Produit(null,"Clavier",20,100));
		produitReposistory.save(new Produit(null,"Souris",5,28));
		produitReposistory.save(new Produit(null,"PC",5000,30));
		produitReposistory.save(new Produit(null,"Scanner",2500,25));
		produitReposistory.save(new Produit(null,"Clavier",20,100));
		produitReposistory.save(new Produit(null,"Souris",5,28));
		//usersRepository.save(new Users(null,"Souris",5,28));
		
		
		
		
		
	}

}
