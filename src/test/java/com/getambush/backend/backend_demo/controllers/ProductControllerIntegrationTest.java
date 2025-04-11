package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.TestcontainersConfiguration;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnProducts() throws Exception {
        mockMvc.perform(get("/products?name=test1&category=category1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", Is.is("test1")))
                .andExpect(jsonPath("$.[0].category", Is.is("category1")))
                .andDo(print())
        ;
    }

    @Test
    void shouldValidateAbsentCategory() throws Exception {
        mockMvc.perform(get("/products?name=test1"))
                .andExpect(status().isBadRequest())
                .andDo(print())
        ;
    }

    @Test
    void shouldValidateBlankCategory() throws Exception {
        mockMvc.perform(get("/products?name=test1&category="))
                .andExpect(status().isBadRequest())
                .andDo(print())
        ;
    }
}