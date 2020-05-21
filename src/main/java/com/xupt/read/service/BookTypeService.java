package com.xupt.read.service;

import com.xupt.read.model.BookType;

import java.util.List;

public interface BookTypeService {

    Integer addBookType(String name);

    List<BookType> getBookTypes();

    BookType getById(Integer id);

    List<BookType> getByIds(List<Integer> ids);
}
