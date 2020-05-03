package com.xupt.read.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.read.common.result.PageResult;
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
    public Integer addBook(Book book) {
        return bookMapper.insertSelective(book);
    }

    @Override
    public List<Book> getByIds(List<Integer> ids) {
        BookExample example = new BookExample();
        example.createCriteria().andIdIn(ids);
        return bookMapper.selectByExample(example);
    }

    @Override
    public List<Book> getBooks() {
        BookExample example = new BookExample();
        return bookMapper.selectByExample(example);
    }

    @Override
    public PageResult<Book> getBooks(int offset, int size) {
        BookExample example = new BookExample();
        example.setOrderByClause("score desc");

        return getByPage(example, offset,size);
    }

    @Override
    public PageResult<Book> getByBookTypeId(Integer bookTypeId, int offset, int size) {
        BookExample example = new BookExample();
        example.createCriteria().andTypeIdEqualTo(bookTypeId);
        example.setOrderByClause("score desc");

        return getByPage(example, offset,size);
    }

    @Override
    public PageResult<Book> getByPopularity(int offset, int size) {
        BookExample example = new BookExample();
        example.setOrderByClause("popularity desc");

        return getByPage(example, offset,size);
    }

    @Override
    public PageResult<Book> getByNewest(int offset, int size) {
        BookExample example = new BookExample();
        example.createCriteria().andIsNewestEqualTo(true);
        example.setOrderByClause("score desc");

        return getByPage(example, offset,size);
    }

    @Override
    public PageResult<Book> getByEnd(int offset, int size) {
        BookExample example = new BookExample();
        example.createCriteria().andIsEndEqualTo(true);
        example.setOrderByClause("score desc");

        return getByPage(example, offset,size);
    }

    private PageResult<Book> getByPage(BookExample example, int offset, int size) {
        PageHelper.offsetPage(offset, size, true);
        List<Book> bookList = bookMapper.selectByExample(example);
        PageInfo<Book> pageInfo = new PageInfo<>(bookList);
        bookList = pageInfo.getList();
        return PageResult.create(pageInfo, bookList);
    }
}
