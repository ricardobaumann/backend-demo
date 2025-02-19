package com.getambush.backend.backend_demo.repos;

import com.getambush.backend.backend_demo.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends CrudRepository<TestEntity, String> {
}
