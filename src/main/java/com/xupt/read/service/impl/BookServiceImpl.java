package com.xupt.read.service.impl;

import com.xupt.read.mapper.BookMapper;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookExample;
import com.xupt.read.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getByIds(List<Integer> ids) {
        BookExample example = new BookExample();
        example.createCriteria().andIdIn(ids);
        return bookMapper.selectByExample(example);
    }
}
