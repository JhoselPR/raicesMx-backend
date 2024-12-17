package com.raicesapi.raicesmx.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.raicesapi.raicesmx.models.Product;
import com.raicesapi.raicesmx.service.ProductService;
import com.raicesapi.raicesmx.service.S3Service;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
    private S3Service s3Service;

	// Get
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		return productService.findProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// POST - Subir imagen a S3 y obtener URL
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("image", file.getOriginalFilename());
        file.transferTo(tempFile);
        String s3Key = "product-images/" + file.getOriginalFilename();
        s3Service.uploadFile(s3Key, tempFile);
        String fileUrl = s3Service.getFileUrl(s3Key);

        return fileUrl;
    }

	// Post
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	// PUT
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		return productService.findProductById(id).map(existingProduct -> {
			// Actualiza los campos del producto existente con los nuevos datos
			existingProduct.setName(product.getName());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setIngredients(product.getIngredients());
			existingProduct.setMeal_time(product.getMeal_time());
			existingProduct.setImage(product.getImage());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setExtras(product.getExtras());
			existingProduct.setStock(product.getStock());

			// Guarda el producto actualizado
			Product updateProduct = productService.saveProduct(existingProduct);
			return ResponseEntity.ok(updateProduct);
		}).orElse(ResponseEntity.notFound().build()); // 404
	}


	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
		return productService.findProductById(id).map(product -> {
			productService.deleteProduct(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
