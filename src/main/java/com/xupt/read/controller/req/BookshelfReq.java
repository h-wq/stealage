package com.xupt.read.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.read.model.Bookshelf;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 书架请求实体类
 */
@Data
public class BookshelfReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer user_id;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "book_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer book_id;

    public static Bookshelf convert(BookshelfReq req) {
        Bookshelf bookshelf = new Bookshelf();
        BeanUtils.copyProperties(req, bookshelf);
        return bookshelf;
    }
}
