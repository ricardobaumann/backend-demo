package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.converters.ProductMapper;
import com.getambush.backend.backend_demo.input.CreateProductBody;
import com.getambush.backend.backend_demo.output.EntityRef;
import com.getambush.backend.backend_demo.output.ProductPayload;
import com.getambush.backend.backend_demo.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductSearchPayload> search(@ModelAttribute @Valid ProductSearchPayload productSearchPayload) {
        log.info("Filters: {}", productSearchPayload);
        return productService.search(productSearchPayload);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityRef post(@RequestBody @Valid CreateProductBody createProductBody) {
        log.info("Product create body: {}", createProductBody);
        return new EntityRef(productService.create(createProductBody).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPayload> get(@PathVariable UUID id) {
        return productService.getByID(id)
                .map(productMapper::toProductPayload)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        //homework
    }

    @PutMapping("/{id}")
    public void put(@RequestBody @Valid CreateProductBody createProductBody,
                    @PathVariable UUID id) {
        //homework
    }

    @PatchMapping("/{id}")
    public void patch(,
                      @PathVariable UUID id) {

    }
}