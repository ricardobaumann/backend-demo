package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.input.BookInput;
import com.getambush.backend.backend_demo.exceptions.DuplicatedBookName;
import com.getambush.backend.backend_demo.repos.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class BookServiceTest {
    private final BookRepo bookRepo = Mockito.mock(BookRepo.class);
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepo);
    }

    @Test
    void shouldCreateBook() {
        //Given
        when(bookRepo.existsByName("foo"))
                .thenReturn(false);

        //When //Then
        assertThat(bookService.create(new BookInput(
                "foo",
                Collections.emptyList()
        ))).hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldNotCreateDuplicateBook() {
        // Given
        when(bookRepo.existsByName("foo"))
                .thenReturn(true);

        // When & Then
        assertThatThrownBy(() -> bookService.create(new BookInput(
                "foo",
                Collections.emptyList()
        ))).isInstanceOf(DuplicatedBookName.class)
                .hasMessage("The book name foo is already taken");
    }

    //TODO unit tests

}
