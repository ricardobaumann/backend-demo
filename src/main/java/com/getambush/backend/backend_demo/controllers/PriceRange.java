package com.getambush.backend.backend_demo.controllers;

import java.math.BigDecimal;

public record PriceRange(
        BigDecimal min,
        BigDecimal max
) {
}
