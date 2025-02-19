package com.getambush.backend.backend_demo.controllers;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TestInput(
        //TODO create custom validation for name
        @NotNull @NotEmpty String name
) {
}
