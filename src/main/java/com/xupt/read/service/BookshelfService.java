package com.xupt.read.service;

import com.xupt.read.common.result.PageResult;
import com.xupt.read.model.Bookshelf;
import com.xupt.read.model.Note;

import java.util.List;

public interface BookshelfService {

    Integer addBookshelf(Bookshelf bookshelf);

    PageResult<Bookshelf> getByUserId(Integer userId, int offset, int size);

    List<Note> getNotes(Integer id);

    Integer deleteBookshelf(Integer id);

    Boolean isHave(Integer bookId, Integer userId);
}
