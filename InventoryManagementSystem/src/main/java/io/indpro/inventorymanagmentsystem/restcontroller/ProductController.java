package io.indpro.inventorymanagmentsystem.restcontroller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.indpro.inventorymanagmentsystem.entities.Product;

import io.indpro.inventorymanagmentsystem.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	@PutMapping("/products/{id}")
	public Product updateProductQuantity(@PathVariable Long id,@RequestParam Integer quantity) {
		return  productService.updateProductQuantity(id, quantity);
	}
	@GetMapping("/inventory/value")
	public ResponseEntity<Map<String, BigDecimal>> getTotalInventoryValue() {
		BigDecimal total_inventory_value=productService.getTotalInvetoryValue();
		Map<String, BigDecimal> map=new HashMap<>();
		map.put("total_inventory_value", total_inventory_value);
		return new ResponseEntity<Map<String,BigDecimal>>(map,HttpStatus.OK);
	}
}
