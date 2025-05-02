package com.getambush.backend.backend_demo.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateProductBody(
        @NotNull @Positive Integer priceInCents,
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String category
) {
}
