package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.TestInput;
import com.getambush.backend.backend_demo.entity.TestEntity;
import com.getambush.backend.backend_demo.repos.AiClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {
    private final ConversionService conversionService;
    private final AiClient aiClient;

    public void create(TestInput testInput) {
        //TODO create conccurency
        log.info("Persisted: {}", conversionService.convert(testInput, TestEntity.class));
        aiClient.answer("foo");
    }
}
