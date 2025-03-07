package com.getambush.backend.backend_demo.exceptions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicatedBookName extends RuntimeException {
    private final String name;

    public DuplicatedBookName(final @NotNull @NotBlank String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return String.format("The book name %s is already taken", name);
    }
}
