package com.xupt.read.service;

import com.xupt.read.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getByIds(List<Integer> ids);
}
