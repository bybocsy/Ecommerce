package com.ecommerce.ComercioOnline.domain.product;

import java.util.UUID;

public record BuyProductRequestDTO(
        UUID id,
        int qtyPurchased
) {
}
