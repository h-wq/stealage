package com.xupt.read.service.impl;

import com.xupt.read.mapper.BookTypeMapper;
import com.xupt.read.model.BookType;
import com.xupt.read.model.BookTypeExample;
import com.xupt.read.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public Integer addBookType(String name) {
        BookType bookType = new BookType();
        bookType.setName(name);
        return bookTypeMapper.insertSelective(bookType);
    }

    @Override
    public List<BookType> getBookTypes() {
        BookTypeExample example = new BookTypeExample();
        return bookTypeMapper.selectByExample(example);
    }
}
