package com.ecommerce.ComercioOnline.repository;

import com.ecommerce.ComercioOnline.domain.company.Company;
import com.ecommerce.ComercioOnline.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    @Query("SELECT c FROM Company c JOIN FETCH c.products WHERE c.id = :id")
    Optional<Company> findCompanyWithProducts(UUID id);
    List<Company> findByOwner(User owner);
}
