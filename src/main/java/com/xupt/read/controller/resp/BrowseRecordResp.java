package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.BrowseRecord;
import lombok.Builder;

import java.util.List;

/**
 * 用户浏览记录请求实体类
 */
@Builder
public class BrowseRecordResp {

    private BookResp bookResp;

    private long time;

    public static BrowseRecordResp convert(List<Book> books, BrowseRecord browseRecord) {

        Book book = books.stream().filter(b -> browseRecord.getBookId().equals(b.getId())).findFirst().get();
        BookResp bookResp = BookResp.convert(book);
        return BrowseRecordResp.builder()
                .bookResp(bookResp)
                .time(browseRecord.getCreatedAt().getTime())
                .build();
    }
}
