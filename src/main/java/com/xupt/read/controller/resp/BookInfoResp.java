package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import lombok.Builder;
import lombok.Data;

/**
 * 图书详情返回实体类
 */
@Builder
@Data
public class BookInfoResp {

    private Integer id;

    private String name;

    private String author;

    /**
     * 简介
     */
    private String synopsis;

    /**
     * 评分
     */
    private Double score;

    /**
     * 链接
     */
    private String link;

    private String bookPath;

    private String typeName;

    private String picture;

    /**
     * 人气
     */
    private Integer popularity;

    /**
     * 是否最新
     */
    private Boolean isNewest;

    /**
     * 是否完结
     */
    private Boolean isEnd;

    private String authorInfo;

    private String bookPublish;

    private String publishYear;

    public static BookInfoResp convert(Book book, BookType bookType) {

        return BookInfoResp.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .synopsis(book.getSynopsis())
                .score(book.getScore())
                .link(book.getLink())
                .bookPath(book.getBookPath())
                .typeName(bookType == null ? "" : bookType.getName())
                .picture(book.getPicture())
                .popularity(book.getPopularity())
                .isNewest(book.getIsNewest())
                .isEnd(book.getIsEnd())
                .authorInfo(book.getAuthorInfo())
                .bookPublish(book.getBookPublish())
                .publishYear(book.getPublishYear())
                .build();
    }
}
