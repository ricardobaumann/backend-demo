package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.services.ProductService;
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
    public List<ProductSearchPayload> search(@ModelAttribute ProductSearchPayload productSearchPayload) {
        log.info("Filters: {}", productSearchPayload);
        return productService.search(productSearchPayload);
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