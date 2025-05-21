package com.ecommerce.ComercioOnline.repository;

import com.ecommerce.ComercioOnline.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCategoryContainingIgnoreCase(String category);
}

