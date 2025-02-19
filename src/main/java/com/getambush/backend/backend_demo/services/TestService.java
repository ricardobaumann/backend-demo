package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.controllers.Test;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {
    private final ConversionService conversionService;

    public void create(Test test) {
        log.info("Persisted: {}", conversionService.convert(test, com.getambush.backend.backend_demo.entity.Test.class));
    }
}
