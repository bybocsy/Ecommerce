package com.ecommerce.ComercioOnline.controller;


import com.ecommerce.ComercioOnline.domain.company.Company;
import com.ecommerce.ComercioOnline.domain.product.BuyProductRequestDTO;
import com.ecommerce.ComercioOnline.domain.product.Product;
import com.ecommerce.ComercioOnline.domain.product.ProductRequestDTO;
import com.ecommerce.ComercioOnline.domain.product.ProductResponseDTO;
import com.ecommerce.ComercioOnline.repository.CompanyRepository;
import com.ecommerce.ComercioOnline.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CompanyRepository companyRepository;

//    @PostMapping("/cadastro")
//    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body) {
//        Product newProduct = new Product(body);
//
//        this.productRepository.save(newProduct);
//
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/cadastro")
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body) {
        Optional<Company> optionalCompany = companyRepository.findById(body.companyId());

        if (optionalCompany.isEmpty()) {
            return ResponseEntity.badRequest().body("Empresa não encontrada.");
        }

        Product newProduct = new Product(body);
        newProduct.setCompany(optionalCompany.get()); // seta a empresa antes do save

        this.productRepository.save(newProduct);

        return ResponseEntity.ok("Produto cadastrado com sucesso.");
    }


    @PostMapping("/comprar")
    public ResponseEntity buyProduct(@RequestBody BuyProductRequestDTO compra){
        Optional<Product> productOptional = productRepository.findById(compra.id());

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();

        if (product.getStock() < compra.qtyPurchased()) {
            return ResponseEntity.badRequest().body("Estoque insuficiente");
        }

        product.setStock(product.getStock() - compra.qtyPurchased());
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByName(@PathVariable("name") String name) {
        List<ProductResponseDTO> productResponseDTOList = productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(ProductResponseDTO::new)
                .toList();

        if (productResponseDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productResponseDTOList);
    }

    @GetMapping("/categoria/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@PathVariable("category") String category) {
        List<ProductResponseDTO> productResponseDTOList = productRepository.findByCategoryContainingIgnoreCase(category)
                .stream()
                .map(ProductResponseDTO::new)
                .toList();

        if (productResponseDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productResponseDTOList);
    }

    @GetMapping("/listagem")
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productResponseDTOList = this.productRepository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productResponseDTOList);
    }

}
