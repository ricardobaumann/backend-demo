package com.getambush.backend.backend_demo.controllers.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record BookInput(
        @NotNull @NotBlank String name,
        @NotEmpty Set<@NotBlank String> authors
) {
}
