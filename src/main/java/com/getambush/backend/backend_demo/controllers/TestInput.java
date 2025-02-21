package com.getambush.backend.backend_demo.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TestInput(
        @NotNull @NotBlank String name
) {
}
