package com.getambush.backend.backend_demo.controllers;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record Test(
        @NotNull @NotEmpty String foo
) {
}
