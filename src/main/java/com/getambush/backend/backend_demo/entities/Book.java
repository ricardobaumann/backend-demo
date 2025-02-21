package com.getambush.backend.backend_demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    private UUID id;

    private String name;
}
