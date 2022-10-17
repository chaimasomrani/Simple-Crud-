package com.example.demo.entities;

import java.util.List;

//import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Users {
	@Id 
	private String username;
	private String passworrd;
	//private Boolean active;
	@ManyToMany(mappedBy = "users")
	private List<Roles> roles;

}
