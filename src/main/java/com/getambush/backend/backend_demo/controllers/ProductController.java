package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductSearchPayload> search(@ModelAttribute @Valid ProductSearchPayload productSearchPayload) {
        log.info("Filters: {}", productSearchPayload);
        return productService.search(productSearchPayload);
    }
}