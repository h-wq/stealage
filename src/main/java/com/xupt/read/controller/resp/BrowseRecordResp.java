package com.xupt.read.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import com.xupt.read.model.BrowseRecord;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户浏览记录请求实体类
 */
@Builder
@Data
public class BrowseRecordResp {

    private BookResp bookResp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    public static BrowseRecordResp convert(List<Book> books, BrowseRecord browseRecord, List<BookType> bookTypes) {

        Book book = books.stream().filter(b -> browseRecord.getBookId().equals(b.getId())).findFirst().get();
        BookResp bookResp = BookResp.convert(book, bookTypes);
        return BrowseRecordResp.builder()
                .bookResp(bookResp)
                .time(browseRecord.getCreatedAt())
                .build();
    }
}
