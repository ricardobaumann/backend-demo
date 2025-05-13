package com.getambush.backend.backend_demo.services;

import com.getambush.backend.backend_demo.entities.Author;
import com.getambush.backend.backend_demo.repos.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepo authorRepo;

    public Set<Author> getOrCreateAuthors(Set<String> authorNames) {
        Set<Author> authors = new HashSet<>();
        
        for (String name : authorNames) {
            Author author = authorRepo.findByName(name)
                    .orElseGet(() -> {
                        Author newAuthor = new Author();
                        newAuthor.setId(UUID.randomUUID());
                        newAuthor.setName(name);
                        return authorRepo.save(newAuthor);
                    });
            authors.add(author);
        }
        
        return authors;
    }
}
