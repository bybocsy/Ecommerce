package com.ecommerce.ComercioOnline.domain.company;

import com.ecommerce.ComercioOnline.domain.product.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public record CompanyResponseDTO(UUID companyId, String nameCompany, String description, List<ProductResponseDTO> products) {
    public CompanyResponseDTO(Company company) {
        this(
                company.getCompanyId(),
                company.getNameCompany(),
                company.getDescription(),
                company.getProducts().stream().map(ProductResponseDTO::new).toList()
        );
    }
}
