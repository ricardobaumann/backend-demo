package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductPayload> search(@ModelAttribute ProductPayload productPayload) {
        log.info("Filters: {}", productPayload);
        return List.of(
                new ProductPayload("name", "category",
                        new PriceRange(new BigDecimal(0), new BigDecimal(100)))
        );
    }

}


/*
Products list/search
- User should be able to search for products, applying the filters:
  - name (open input)
  - category (select input)
  - price range (select input OR slider) - we can abstract to min/max
  - page (query should be paginated)
- Server-side cache
  - We should implement a caching layer to avoid doing the same query multiple times
 */