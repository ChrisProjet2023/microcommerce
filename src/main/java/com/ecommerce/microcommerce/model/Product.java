package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
//indique que ce Bean (Product) accepte un filtre qui porte le nom très créatif de monFiltreDynamique.
//@JsonFilter("FiltreDynamique")
@Data
@Entity
public class Product {
	//@JsonIgnore
	@Id
	private int id;
	
	@Size(min = 3, max = 25)
	private String nom;
	
	@Min(value = 1)
	private int prix;
	//informations que nous ne souhaitons pas afficher
	//Ajoutez l'annotation @JsonIgnore au-dessus des propriétés que vous souhaitez cacher
	//@JsonIgnore
//	@JsonIgnoreProperties(value = {"prixAchat","id"} )
	//ne autre notation qui peut être pratique quand vous avez beaucoup de choses à cacher..
	private int prixAchat;
	
	
	public Product() {
		
	}
	
	public Product(int id, String nom, int prix, int prixAchat ) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
		
		
		
	}
	
	/*public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}*/
	@Override
	public String toString() {
		return "Product{"+
				"id="+id+
				", nom = '"+nom+'\''+
				", prix="+prix+
				'}';
	}
	

}
