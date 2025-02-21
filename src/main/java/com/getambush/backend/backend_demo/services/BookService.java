package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.input.BookInput;
import com.getambush.backend.backend_demo.controllers.output.ResourceRef;
import com.getambush.backend.backend_demo.entities.Book;
import com.getambush.backend.backend_demo.repos.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    public ResourceRef create(final BookInput bookInput) {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName(bookInput.name());

        bookRepo.save(book);

        return new ResourceRef(book.getId());
    }

    public Optional<Book> getByID(final UUID id) {
        return bookRepo.findById(id);
    }
}
