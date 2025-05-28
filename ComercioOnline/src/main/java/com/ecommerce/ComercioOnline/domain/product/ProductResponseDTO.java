package com.ecommerce.ComercioOnline.domain.product;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, Integer price, String description, String cattegory, Long stock, String productImage) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(),product.getDescription(), product.getCategory(), product.getStock(), product.getProductImage());
    }
}
