package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.services.TestService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping
    public TestInput get() {
        return new TestInput("bar");
    }

    @PostMapping
    public void post(@RequestBody @Valid TestInput testInput) {
        testService.create(testInput);
    }
}
