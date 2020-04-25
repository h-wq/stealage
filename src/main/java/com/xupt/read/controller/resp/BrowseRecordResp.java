package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.BrowseRecord;
import com.xupt.read.model.User;
import lombok.Builder;

import java.util.List;

@Builder
public class BrowseRecordResp {

    private UserResp userResp;

    private BookResp bookResp;

    private long time;

    public static BrowseRecordResp convert(List<User> users, List<Book> books, BrowseRecord browseRecord) {

        User user = users.stream().filter(u -> browseRecord.getUserId().equals(u.getId())).findFirst().get();
        Book book = books.stream().filter(b -> browseRecord.getBookId().equals(b.getId())).findFirst().get();
        UserResp userResp = UserResp.convert(user);
        BookResp bookResp = BookResp.convert(book);
        return BrowseRecordResp.builder()
                .userResp(userResp)
                .bookResp(bookResp)
                .time(browseRecord.getCreatedAt().getTime())
                .build();
    }
}
