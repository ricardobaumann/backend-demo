package com.getambush.backend.backend_demo.controllers;

public record ProductPayload(
        String name,
        String category,
        PriceRange price
) {
}
