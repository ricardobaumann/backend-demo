package com.getambush.backend.backend_demo.converters;

import com.getambush.backend.backend_demo.entity.Test;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface TestToEntityConverter extends Converter<com.getambush.backend.backend_demo.controllers.Test, Test> {

    @Override
    Test convert(com.getambush.backend.backend_demo.controllers.Test source);
}
