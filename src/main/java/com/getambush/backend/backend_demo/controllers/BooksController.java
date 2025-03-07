package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.controllers.input.BookInput;
import com.getambush.backend.backend_demo.controllers.output.BookOutput;
import com.getambush.backend.backend_demo.controllers.output.ResourceRef;
import com.getambush.backend.backend_demo.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;
    private final ConversionService conversionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceRef post(@RequestBody @Valid BookInput bookInput) {
        return bookService.create(bookInput);
    }

    @GetMapping("/{id}")//books/123
    public ResponseEntity<BookOutput> get(@PathVariable UUID id) {
        return bookService.getByID(id)
                .map(book -> conversionService.convert(book, BookOutput.class))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable UUID id, @RequestBody @Valid BookInput bookInput) {

        return bookService.update(id, bookInput) ? ResponseEntity.ok().build() :
                ResponseEntity.created(new URI("/books/" + id)).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bookService.delete(id);
    }
}
