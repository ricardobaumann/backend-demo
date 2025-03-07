package com.getambush.backend.backend_demo.controllers;

public record ProductSearchPayload(
        String name,
        String category,
        PriceRange price
) {
}
