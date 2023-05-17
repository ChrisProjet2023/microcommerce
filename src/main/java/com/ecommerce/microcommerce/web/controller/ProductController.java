package com.ecommerce.microcommerce.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	//la liste des produits
	@GetMapping("/Produits")
	public String listeProduits() {
		return "Un exemple de produit";
	}
	

}