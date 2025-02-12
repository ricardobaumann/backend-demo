package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.controllers.input.BookInput;
import com.getambush.backend.backend_demo.controllers.output.ResourceRef;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/books")
public class BooksController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceRef post(@RequestBody @Valid BookInput bookInput) {
        log.info("Payload: {}", bookInput);
        return new ResourceRef(UUID.randomUUID());
    }

    @GetMapping("/{id}")
    public BookInput get(@PathVariable UUID id) {
        return new BookInput("foo", List.of("author1"));
    }

}
