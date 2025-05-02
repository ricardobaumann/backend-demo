package com.getambush.backend.backend_demo.output;

import java.util.UUID;

public record ProductPayload(
        UUID id,
        Integer priceInCents,
        String name,
        String category
) {
}
