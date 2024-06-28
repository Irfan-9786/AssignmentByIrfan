package io.indpro.inventorymanagmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.indpro.inventorymanagmentsystem.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
