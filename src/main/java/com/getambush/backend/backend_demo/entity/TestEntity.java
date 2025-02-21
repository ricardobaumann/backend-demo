package com.getambush.backend.backend_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;

}
