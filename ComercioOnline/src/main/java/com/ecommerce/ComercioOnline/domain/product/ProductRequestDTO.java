package com.ecommerce.ComercioOnline.domain.product;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotNull
        Integer price,

        @NotBlank
        String description,

        @NotBlank
        String category,

        @NotNull
        Long stock,

        @NotBlank
        UUID companyId,

        @NotBlank
        String productImage

) {
    }
