package com.getambush.backend.backend_demo.repos;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AiClient {

    public String answer(String query) {
        return "answer";
    }

}
