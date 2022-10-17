package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


//import org.apache.catalina.realm.JNDIRealm.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
 @AllArgsConstructor @NoArgsConstructor
public class Roles {
	@Id 
	private String role;
	@ManyToMany
	@JoinTable(name="users_roles")
	private List<Users> users;

}
