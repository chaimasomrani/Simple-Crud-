package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	@NonNull 
	private String designation;
	//@DecimalMin(100)
	private double prix;
	private int quantite;
	

}
