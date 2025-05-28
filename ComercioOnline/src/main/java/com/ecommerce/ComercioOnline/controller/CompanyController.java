package com.ecommerce.ComercioOnline.controller;

import com.ecommerce.ComercioOnline.domain.company.Company;
import com.ecommerce.ComercioOnline.domain.company.CompanyRequestDTO;
import com.ecommerce.ComercioOnline.domain.company.CompanyResponseDTO;
import com.ecommerce.ComercioOnline.domain.user.User;
import com.ecommerce.ComercioOnline.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@RequestBody CompanyRequestDTO dto, @AuthenticationPrincipal User user) {
        Company company = new Company();
        company.setNameCompany(dto.nameCompany());
        company.setDescription(dto.description());
        company.setOwner(user); // Associa o usuário logado como dono

        companyRepository.save(company);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/companies")
    public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyResponseDTO> response = companies.stream()
                .map(CompanyResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }


}
