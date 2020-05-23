package com.xupt.read.service.impl;

import com.xupt.read.mapper.BookTypeMapper;
import com.xupt.read.model.BookType;
import com.xupt.read.model.BookTypeExample;
import com.xupt.read.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    public Integer addBookType(BookType bookType) {
        return bookTypeMapper.insertSelective(bookType);
    }

    @Override
    public List<BookType> getBookTypes() {
        BookTypeExample example = new BookTypeExample();
        return bookTypeMapper.selectByExample(example);
    }

    @Override
    public BookType getById(Integer id) {
        return bookTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BookType> getByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        BookTypeExample example = new BookTypeExample();
        example.createCriteria().andIdIn(ids);
        return bookTypeMapper.selectByExample(example);
    }

    @Override
    public Integer isHasBookType(String name) {
        BookTypeExample example = new BookTypeExample();
        example.createCriteria().andNameEqualTo(name);
        BookType bookType = bookTypeMapper.selectByExample(example).stream().findFirst().orElse(null);
        return bookType == null ? null : bookType.getId();
    }
}
