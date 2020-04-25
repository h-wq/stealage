package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.Evaluate;
import com.xupt.read.model.User;
import lombok.Builder;

import java.util.List;

@Builder
public class EvaluateResp {

    private BookResp bookResp;

    private UserResp userResp;

    private String remarks;

    private long time;

    public static EvaluateResp convert(List<Book> books, List<User> users, Evaluate evaluate) {

        Book book = books.stream().filter(b -> evaluate.getBookId().equals(b.getId())).findFirst().get();
        User user = users.stream().filter(u -> evaluate.getUserId().equals(u.getId())).findFirst().get();
        BookResp bookResp = BookResp.convert(book);
        UserResp userResp = UserResp.convert(user);
        return EvaluateResp.builder()
                .bookResp(bookResp)
                .userResp(userResp)
                .time(evaluate.getCreatedAt().getTime())
                .build();
    }
}
