package com.getambush.backend.backend_demo;

import jakarta.validation.constraints.NotNull;

public record Test(
        @NotNull String foo
) {
}
