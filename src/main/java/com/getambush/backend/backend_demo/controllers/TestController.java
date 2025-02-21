package com.getambush.backend.backend_demo.controllers;

import com.getambush.backend.backend_demo.services.TestService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping
    public List<TestInput> get() {
        return List.of(new TestInput("bar"));
    }

    @PostMapping
    public void post(@RequestBody @Valid TestInput testInput) {
        testService.create(testInput);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestInput> get(@PathVariable String id) {
        return testService.getTest(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

/*
Products list/search
- User should be able to search for products, applying the filters:
  - name (open input)
  - category (select input)
  - price range (select input OR slider) - we can abstract to min/max
  - page (query should be paginated)
- Server-side cache
  - We should implement a caching layer to avoid doing the same query multiple times
*/

