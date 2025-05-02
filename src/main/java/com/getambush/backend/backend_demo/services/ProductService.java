package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.PriceRange;
import com.getambush.backend.backend_demo.controllers.ProductSearchPayload;
import com.getambush.backend.backend_demo.converters.ProductMapper;
import com.getambush.backend.backend_demo.entity.Product;
import com.getambush.backend.backend_demo.input.CreateProductBody;
import com.getambush.backend.backend_demo.repos.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public List<ProductSearchPayload> search(final ProductSearchPayload productSearchPayload) {
        final Optional<PriceRange> priceRangeOptional = Optional.ofNullable(productSearchPayload.price());
        return productRepo.findBy(
                productSearchPayload.name(),
                productSearchPayload.category(),
                priceRangeOptional
                        .map(PriceRange::min)
                        .orElse(null),
                priceRangeOptional
                        .map(PriceRange::max)
                        .orElse(null)
        ).stream().map(
                product -> new ProductSearchPayload(
                        product.getName(),
                        product.getCategory(),
                        null
                )
        ).collect(Collectors.toList());
    }

    public Product create(final CreateProductBody createProductBody) {
        return productRepo.save(
                productMapper.mapProduct(createProductBody)
        );
    }

    public Optional<Product> getByID(final UUID id) {
        return productRepo.findById(id);
    }
}
