package com.getambush.backend.backend_demo.controllers.output;

import java.util.UUID;

public record BookOutput(
        UUID id,
        String name
) {
}
