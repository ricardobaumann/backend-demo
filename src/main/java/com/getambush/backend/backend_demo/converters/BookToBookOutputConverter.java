package com.getambush.backend.backend_demo.converters;

import com.getambush.backend.backend_demo.controllers.output.BookOutput;
import com.getambush.backend.backend_demo.entities.Book;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface BookToBookOutputConverter extends Converter<Book, BookOutput> {

    @Override
    BookOutput convert(Book source);
}
