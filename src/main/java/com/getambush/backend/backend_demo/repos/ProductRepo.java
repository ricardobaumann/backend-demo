package com.getambush.backend.backend_demo.repos;

import com.getambush.backend.backend_demo.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepo extends CrudRepository<Product, UUID> {
    
    @Query("""
            select p from Product p
                where (:name is null or p.name like %:name)
                AND (:category IS NULL OR p.category = :category)
                AND (:priceInCentsMin IS NULL OR p.priceInCents >= :priceInCentsMin)
                AND (:priceInCentsMax IS NULL OR p.priceInCents <= :priceInCentsMax)
            """)
    List<Product> findBy(String name, String category, Integer priceInCentsMin, Integer priceInCentsMax);
}
