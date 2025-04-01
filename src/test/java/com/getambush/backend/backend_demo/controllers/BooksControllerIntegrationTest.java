package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.TestcontainersConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BooksControllerIntegrationTest {

    private MockMvc mockMvc;
    @Autowired
    private BooksController booksController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
    }

    @Test
    void shouldCreateBook() throws Exception {

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "foo",
                                    "authors": [
                                        "bar"
                                    ]
                                }
                                """)
                )
                .andDo(print())
                .andExpect(status().isCreated());

    }
}