package com.getambush.backend.backend_demo.converters;

import com.getambush.backend.backend_demo.controllers.TestInput;
import com.getambush.backend.backend_demo.entity.TestEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface TestToEntityConverter extends Converter<TestInput, TestEntity> {

    @Override
    @Mapping(source = "name", target = "foo")
    TestEntity convert(TestInput source);

    @InheritInverseConfiguration
    TestInput convert(TestEntity source);
}
