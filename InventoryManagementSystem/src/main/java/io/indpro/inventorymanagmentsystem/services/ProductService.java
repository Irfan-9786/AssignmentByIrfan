package io.indpro.inventorymanagmentsystem.services;

import java.math.BigDecimal;

import io.indpro.inventorymanagmentsystem.entities.Product;

public interface ProductService {
public Product addProduct(Product product);
public Product updateProductQuantity(Long id, Integer quantity);
public BigDecimal getTotalInvetoryValue();

}
