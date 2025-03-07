package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.input.BookInput;
import com.getambush.backend.backend_demo.controllers.output.ResourceRef;
import com.getambush.backend.backend_demo.entities.Book;
import com.getambush.backend.backend_demo.exceptions.DuplicatedBookName;
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
        if (bookRepo.existsByName(bookInput.name())) {
            throw new DuplicatedBookName(bookInput.name());
        }
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName(bookInput.name());

        bookRepo.save(book);

        return new ResourceRef(book.getId());
    }

    public Boolean update(final UUID id, final BookInput bookInput) {
        if (bookRepo.existsByName(bookInput.name())) {
            throw new DuplicatedBookName(bookInput.name());
        }
        Boolean existent = bookRepo.existsById(id);

        Book book = new Book();
        book.setId(id);
        book.setName(bookInput.name());
        bookRepo.save(book);
        return existent;
    }

    public Optional<Book> getByID(final UUID id) {
        return bookRepo.findById(id);
    }

    public void delete(final UUID id) {
        bookRepo.deleteById(id);
    }
}
