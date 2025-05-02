package com.getambush.backend.backend_demo.converters;

import com.getambush.backend.backend_demo.entity.Product;
import com.getambush.backend.backend_demo.input.CreateProductBody;
import com.getambush.backend.backend_demo.output.ProductPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product mapProduct(CreateProductBody createProductBody);

    ProductPayload toProductPayload(Product product);
}
