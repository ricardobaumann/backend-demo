package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.TestInput;
import com.getambush.backend.backend_demo.entity.TestEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {
    private final ConversionService conversionService;

    public void create(TestInput testInput) {
        log.info("Persisted: {}", conversionService.convert(testInput, TestEntity.class));
    }

    public Optional<TestInput> getTest(final String id) {
        return Optional.empty();
    }
}
