package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.ProductSearchPayload;
import com.getambush.backend.backend_demo.repos.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<ProductSearchPayload> search(final ProductSearchPayload productSearchPayload) {
        return null;
    }

    // business rules

}
