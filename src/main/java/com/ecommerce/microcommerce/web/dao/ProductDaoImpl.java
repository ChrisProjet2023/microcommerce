package com.ecommerce.microcommerce.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;

/*@Repository
public class ProductDaoImpl implements ProductDao{
	
	public static List<Product> products = new ArrayList<>();
	
	//création des produits
	static {
		products.add(new Product(1, "Ordinateur portable", 350, 400));
		products.add(new Product(2, "Aspirateur robot", 500, 400));
		products.add(new Product(3, "Table de ping pong", 750, 400));
	}
	
	@Override
	public List<Product> findAll(){
		return products;
	}
	
	@Override
	public Product findById(int id) {
		for(Product product: products) {
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}
	
	@Override
	public Product save(Product product) {
		products.add(product);
		return product;
	}

}*/
