package com.getambush.backend.backend_demo.repos;

import com.getambush.backend.backend_demo.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepo extends CrudRepository<Book, UUID> {
}
