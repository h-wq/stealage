package com.xupt.read.service;

import com.xupt.read.common.result.PageResult;
import com.xupt.read.model.Book;

import java.util.List;

public interface BookService {

    Integer addBook(Book book);

    Book getById(Integer id);

    List<Book> getByIds(List<Integer> ids);

    List<Book> getBooks();

    PageResult<Book> getBooks(int offset, int size);

    PageResult<Book> getByName(String name, int offset, int size);

    PageResult<Book> getByBookTypeId(Integer bookTypeId, int offset, int size);

    PageResult<Book> getByPopularity(int offset, int size);

    PageResult<Book> getByNewest(int offset, int size);

    PageResult<Book> getByEnd(int offset, int size);
}
