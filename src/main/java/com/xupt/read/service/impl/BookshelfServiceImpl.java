package com.xupt.read.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.mapper.BookshelfMapper;
import com.xupt.read.mapper.NoteMapper;
import com.xupt.read.model.Bookshelf;
import com.xupt.read.model.BookshelfExample;
import com.xupt.read.model.Note;
import com.xupt.read.model.NoteExample;
import com.xupt.read.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfServiceImpl implements BookshelfService {

    @Autowired
    private BookshelfMapper bookshelfMapper;

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public Integer addBookshelf(Bookshelf bookshelf) {
        return bookshelfMapper.insertSelective(bookshelf);
    }

    @Override
    public PageResult<Bookshelf> getByUserId(Integer userId, int offset, int size) {
        BookshelfExample example = new BookshelfExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.setOrderByClause("created_at desc");

        PageHelper.offsetPage(offset, size, true);
        List<Bookshelf> bookshelfList = bookshelfMapper.selectByExample(example);
        PageInfo<Bookshelf> pageInfo = new PageInfo<>(bookshelfList);
        bookshelfList = pageInfo.getList();
        return PageResult.create(pageInfo, bookshelfList);
    }

    @Override
    public List<Note> getNotes(Integer id) {
        NoteExample example = new NoteExample();
        example.createCriteria().andBookshelfIdEqualTo(id);
        example.setOrderByClause("created_at desc");
        return noteMapper.selectByExample(example);
    }
}
