package com.getambush.backend.backend_demo.repos;

import com.getambush.backend.backend_demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Init implements CommandLineRunner {
    private final ProductRepo productRepo;

    @Override
    public void run(final String... args) {
        productRepo.deleteAll();
        productRepo.save(Product.builder()
                .priceInCents(100)
                .name("test1")
                .category("category1")
                .build());
        productRepo.save(Product.builder()
                .priceInCents(200)
                .name("test2")
                .category("category2")
                .build());
        log.info("Products created successfully: {}", productRepo.count());
    }
}
