package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.ProductSearchPayload;
import com.getambush.backend.backend_demo.repos.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<ProductSearchPayload> search(final ProductSearchPayload productSearchPayload) {
        return productRepo.findBy(
                productSearchPayload.name(),
                productSearchPayload.category(),
                productSearchPayload.price().min(),
                productSearchPayload.price().max()
        ).stream().map(
                product -> new ProductSearchPayload(
                        product.getName(),
                        product.getCategory(),
                        null
                )
        ).collect(Collectors.toList());
    }

    // business rules

}
