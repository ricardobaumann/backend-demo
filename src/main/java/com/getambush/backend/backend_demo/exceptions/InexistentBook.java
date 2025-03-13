package com.getambush.backend.backend_demo.exceptions;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InexistentBook extends RuntimeException {
    private final UUID id;

    public InexistentBook(final @NotNull UUID id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("The id %s doesn't exist", id);
    }
}
