package com.productService.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productService.dto.ProductRequest;
import com.productService.dto.ProductResponse;
import com.productService.model.Product;
import com.productService.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    org.slf4j.Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository prodRepo;


    public void createProduct(ProductRequest prodReq) {
        Product prod = Product.builder()
                .description(prodReq.getDescription())
                .name(prodReq.getName())
                .price(prodReq.getPrice()).build();

        prodRepo.save(prod);
        logger.info("product {} saving ", prod.getId());

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = prodRepo.findAll();

        return products.stream().map(this::mapToProdRes).collect(Collectors.toList());
    }

    public ProductResponse mapToProdRes(Product prod) {
        ProductResponse ps = ProductResponse.builder()
                .description(prod.getId())
                .id(prod.getId())
                .name(prod.getName())
                .price(prod.getPrice()).build();

        return ps;
    }

}
