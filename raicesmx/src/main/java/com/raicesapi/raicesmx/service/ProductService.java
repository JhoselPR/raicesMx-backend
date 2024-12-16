package com.raicesapi.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raicesapi.raicesmx.models.Product;
import com.raicesapi.raicesmx.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	// Get
		public List<Product> findAllProducts(){
			return productRepository.findAll();
		}
		
		public Optional<Product> findProductById(Integer id){
			return productRepository.findById(id);
		}
		
		// Post
		public Product saveProduct(Product product) {
			return productRepository.save(product);
		}
		
		// Put
		
		
		// Delete
		public void deleteProduct(Integer id) {
			productRepository.deleteById(id);
		}
}
