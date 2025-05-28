package com.ecommerce.ComercioOnline.domain.company;

import com.ecommerce.ComercioOnline.domain.product.Product;
import com.ecommerce.ComercioOnline.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyId;

    private String nameCompany;

    private String description;

    @OneToMany(mappedBy = "company")
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Company(CompanyRequestDTO data){
        this.nameCompany = data.nameCompany();
        this.description = data.description();
    }

}
