package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Produit;
import com.example.demo.repo.ProduitReposistory;

//import java.util.List;



@Controller
public class ProduitController {
	@Autowired
	private ProduitReposistory produitReposistory;
	@GetMapping("user/index") 
	
	public String chercher(Model model,@RequestParam(name="page",defaultValue = "0") int page,
			@RequestParam(name="motCle",defaultValue = "") String mc) {
		Page <Produit> produits=produitReposistory.findByDesignationContains(mc,PageRequest.of(page,5));
	model.addAttribute("listProduits",produits);
	model.addAttribute("page",new int[produits.getTotalPages()]);
	model.addAttribute("currentpage",page);
	model.addAttribute("motCle",mc);
		return "produits";
}
	@GetMapping("/admin/delete") 
	public String delete  (Long id,int page,String motCle) {
		produitReposistory.deleteById(id);
		return "redirect:/user/index?page="+page+"&motCle="+motCle;
		
		
	}
	
	@GetMapping("/admin/FormProduit") 
	public String form  (Model model) {
		model.addAttribute("produit",new Produit());
		
		return "FormProduit";
		
		
	}
	@PostMapping("/admin/save") 
	public String save  (Model model,@Validated Produit produit,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "FormProduit";		
		produitReposistory.save(produit);
		
		return "redirect:/user/index";
		
		
	}
	@GetMapping("/") 
	public String def  ()  {
		//model.addAttribute("produit",new Produit());
		
		return "redirect:user/index";
		
		
	}
	
	@GetMapping("/403") 
	public String notAutorized  () {
		//model.addAttribute("produit",new Produit());
		
		return "403";
		
		
	}
	
	@GetMapping("/admin/edit")
	public String edit(Model model, Long id) {
		Produit produit=produitReposistory.findById(id).get();
		model.addAttribute("produit",produit);
		return "EditProduit";
	}
	
	
	
	
	
}
