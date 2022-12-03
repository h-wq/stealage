//package com.xupt.stealage.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.xupt.stealage.common.result.PageResult;
//import com.xupt.stealage.service.BookshelfService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookshelfServiceImpl implements BookshelfService {
//
//    @Autowired
//    private BookshelfMapper bookshelfMapper;
//
//    @Autowired
//    private NoteMapper noteMapper;
//
//    @Override
//    public Integer addBookshelf(Bookshelf bookshelf) {
//        return bookshelfMapper.insertSelective(bookshelf);
//    }
//
//    @Override
//    public PageResult<Bookshelf> getByUserId(Integer userId, int offset, int size) {
//        BookshelfExample example = new BookshelfExample();
//        example.createCriteria().andUserIdEqualTo(userId);
//        example.setOrderByClause("create_time desc");
//
//        PageHelper.offsetPage(offset, size, true);
//        List<Bookshelf> bookshelfList = bookshelfMapper.selectByExample(example);
//        PageInfo<Bookshelf> pageInfo = new PageInfo<>(bookshelfList);
//        bookshelfList = pageInfo.getList();
//        return PageResult.create(pageInfo, bookshelfList);
//    }
//
//    @Override
//    public List<Note> getNotes(Integer id) {
//        NoteExample example = new NoteExample();
//        example.createCriteria().andBookshelfIdEqualTo(id);
//        example.setOrderByClause("create_time desc");
//        return noteMapper.selectByExample(example);
//    }
//
//    @Override
//    public Integer deleteBookshelf(Integer id) {
//        return bookshelfMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public Boolean isHave(Integer bookId, Integer userId) {
//        BookshelfExample example = new BookshelfExample();
//        example.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
//        return bookshelfMapper.selectByExample(example).size() > 0;
//    }
//}
