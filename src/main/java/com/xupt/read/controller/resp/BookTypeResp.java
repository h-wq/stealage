package com.xupt.read.controller.resp;

import com.xupt.read.model.BookType;
import lombok.Builder;

@Builder
public class BookTypeResp {

    private Integer id;

    private String name;

    public static BookTypeResp convert(BookType bookType) {

        return BookTypeResp.builder()
                .id(bookType.getId())
                .name(bookType.getName())
                .build();
    }
}
