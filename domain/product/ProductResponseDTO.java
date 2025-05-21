package com.ecommerce.ComercioOnline.domain.product;

import com.ecommerce.ComercioOnline.domain.company.Company;
import com.ecommerce.ComercioOnline.domain.company.CompanyResponseDTO;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, Integer price, String description, String cattegory, Long stock) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(),product.getDescription(), product.getCategory(), product.getStock());
    }
}
