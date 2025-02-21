package com.getambush.backend.backend_demo.converters;

import com.getambush.backend.backend_demo.controllers.TestInput;
import com.getambush.backend.backend_demo.entity.TestEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface TestToEntityConverter extends Converter<TestInput, TestEntity> {

    @Override
    TestEntity convert(TestInput source);
}
