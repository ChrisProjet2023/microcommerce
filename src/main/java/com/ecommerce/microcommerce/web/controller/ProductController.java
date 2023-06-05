package com.ecommerce.microcommerce.web.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.dao.ProductDao;
import com.ecommerce.microcommerce.web.exceptions.ProduitIntrouvableException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	
	/*public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}*/
	
	//la liste des produits
	/*@GetMapping("/Produits")
	public List<Product> listeProduits() {
		return productDao.findAll();
	}*/
	
	@GetMapping(value = "/Produits/{id}")
	public Product afficherProduit(@PathVariable int id) {
		//Product product = new Product(id, new String("Aspirateur"), 400);
		//return product;
		//return "Vous avez demandé un produit avce l'id "+id;
		Product product = productDao.findById(id);
		if(product==null) throw new ProduitIntrouvableException("Le produict avec"
				+ "l'id "+id+"est introuvable. Ecran bleu si je pouvais");
		return productDao.findById(id);
	}

	@GetMapping(value = "test/produits/{prixLimit}")
	public List<Product> testDeRequetes(@PathVariable int prixLimit){
		return productDao.findByPrixGreaterThan(prixLimit);
	}
	
	//@Query("SELECT id, nom, prix FROM Product p where p.prix > :prixLimit")
	//List<Product> chercherUnProduitCher(@Param("prixLimit") int prix);
	
	@PostMapping(value = "/Produits")
	public ResponseEntity<Void> ajouterProduit(@Valid @RequestBody Product product) {
		productDao.save(product);
		return null;
	}
	
	@DeleteMapping(value = "/Produits/{id}")
	public void supprimeProduit(@PathVariable int id) {
		productDao.deleteById(id);
	}
	
	@PutMapping(value = "/Produits")
	public void updateProduit(@RequestBody Product product) {
		productDao.save(product);
	}
	
	
	//@PostMapping(value = "/Produits")
	/*public ResponseEntity<Product> ajouterProduit(@RequestBody Product product){
		Product productAdded = productDao.save(product);
		if(Objects.isNull(productAdded)) {
			return ResponseEntity.noContent().build();
			//code 204  Cette méthode est chaînée avec la méthode build() qui construit le header, et y ajoute le code choisi.
		}
		//Récupération de l'url de la requete
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(productAdded.getId())
				.toUri();
		return ResponseEntity.created(location).build();
			
	}*/
	
	//récupérer la liste des produits
	//cacher l'attribut prixAchat de produit
	//@GetMapping("/Produits")
	
	@RequestMapping(value="/Produits", method = RequestMethod.GET)
	
	public MappingJacksonValue listeProduits() {
		
		Iterable<Product> produits = productDao.findAll();
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
		
		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("FiltreDynamique", filter);
		
		MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);
		
		produitsFiltres.setFilters(listDeNosFiltres);
		
		return produitsFiltres;
	}
}