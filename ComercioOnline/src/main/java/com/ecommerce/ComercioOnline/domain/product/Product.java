package com.ecommerce.ComercioOnline.domain.product;

import com.ecommerce.ComercioOnline.domain.company.Company;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer price;

    private String description;

    private String category;

    private Long stock;

    private String productImage;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Product(ProductRequestDTO data){
        this.price = data.price();
        this.name = data.name();
        this.description = data.description();
        this.category = data.category();
        this.stock = data.stock();
        this.productImage = data.productImage();
    }
}
