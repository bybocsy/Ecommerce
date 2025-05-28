package com.ecommerce.ComercioOnline.domain.company;

import jakarta.validation.constraints.NotBlank;

public record CompanyRequestDTO(
        @NotBlank
        String nameCompany,

        @NotBlank
        String description
) {
}
