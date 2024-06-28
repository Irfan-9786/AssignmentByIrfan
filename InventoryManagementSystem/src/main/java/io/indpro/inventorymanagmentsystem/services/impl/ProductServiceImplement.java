package io.indpro.inventorymanagmentsystem.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.indpro.inventorymanagmentsystem.entities.Product;
import io.indpro.inventorymanagmentsystem.exceptions.ResourceNotFoundException;
import io.indpro.inventorymanagmentsystem.repository.ProductRepository;
import io.indpro.inventorymanagmentsystem.services.ProductService;
@Service
public class ProductServiceImplement implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProductQuantity(Long id, Integer quantity) {
	Product product=this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
	product.setQuantity(quantity);	
	return productRepository.save(product);
	}

	@Override
	public BigDecimal getTotalInvetoryValue() {
		List<Product> products=productRepository.findAll();
		return products.stream().map(product->product.getPrice().multiply(new BigDecimal(product.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
