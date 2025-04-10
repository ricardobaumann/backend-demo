package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

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