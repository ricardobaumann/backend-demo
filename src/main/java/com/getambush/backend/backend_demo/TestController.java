package com.getambush.backend.backend_demo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Test get() {
        return new Test("bar");
    }

    @PostMapping
    public void post(@RequestBody @Valid Test test) {
        log.info("Payload: {}", test);
    }
}
