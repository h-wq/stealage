package com.xupt.read.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.read.model.Book;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BookReq {

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @NotBlank
    private String synopsis;

    private Integer score;

    @NotBlank
    private String link;

    @NotBlank
    @Min(value = 1)
    @JsonProperty(value = "type_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer typeId;

    private Integer popularity = 0;

    @JsonProperty(value = "is_newest", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isNewest = false;

    @NotNull
    @JsonProperty(value = "is_end", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isEnd;

    public static Book convert(BookReq req, String path) {
        Book book = new Book();
        BeanUtils.copyProperties(req, book);
        book.setPicture(path);
        return book;
    }
}
