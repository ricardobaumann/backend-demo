package com.getambush.backend.backend_demo.controllers.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BookInput(
        @NotNull @NotBlank String name,
        @NotEmpty List<@NotBlank String> authors
) {
}
