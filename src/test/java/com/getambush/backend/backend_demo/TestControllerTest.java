package com.getambush.backend.backend_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@EnableWebMvc
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnTest() throws Exception {
        mockMvc.perform(get("/test")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.foo", is("bar")));
    }

    @Test
    void shouldValidatePost() throws Exception {
        String resultBody = mockMvc.perform(post("/test")
                        .content("""
                                { "foo": "" }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        assertThat(resultBody).isEqualToIgnoringWhitespace("""
                {"code":"VALIDATION_FAILED",
                "message":"Validation failed for object='test'. Error count: 1",
                "fieldErrors":[{"code":"REQUIRED_NOT_EMPTY","property":"foo",
                "message":"must not be empty","rejectedValue":"","path":"foo"}]}
                """);
    }
}