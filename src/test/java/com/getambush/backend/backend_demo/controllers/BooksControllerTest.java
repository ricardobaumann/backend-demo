package com.getambush.backend.backend_demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@EnableWebMvc
class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldValidateRequestBody() throws Exception {
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {}
                                """)
                ).andExpect(status().isBadRequest())
                .andExpect(content().json("""
                        {
                            "code":"VALIDATION_FAILED","message":"Validation failed for object='bookInput'. Error count: 3",
                            "fieldErrors":[
                                {"code":"REQUIRED_NOT_EMPTY","property":"authors",
                                    "message":"must not be empty","rejectedValue":null,"path":"authors"},
                                {"code":"REQUIRED_NOT_BLANK","property":"name","message":"must not be blank",
                                    "rejectedValue":null,"path":"name"},
                                {"code":"REQUIRED_NOT_NULL","property":"name","message":"must not be null",
                                    "rejectedValue":null,"path":"name"}]
                        }
                        """))
                .andDo(print())
        ;
    }

    @Test
    @DisplayName("Should return Ok on valid input")
    void shouldReturnOkOnValidBody() throws Exception {
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "name": "foo",
                            "authors": [
                                "test"
                            ]
                        }
                        """)
        ).andExpect(status().isOk());
    }
}