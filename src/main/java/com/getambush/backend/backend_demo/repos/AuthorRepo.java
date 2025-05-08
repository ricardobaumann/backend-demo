package com.getambush.backend.backend_demo.repos;

import com.getambush.backend.backend_demo.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepo extends CrudRepository<Author, UUID> {}
