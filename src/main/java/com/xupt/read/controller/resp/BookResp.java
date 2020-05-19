package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.Bookshelf;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 图书返回实体类
 */
@Builder
@Data
public class BookResp {

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

    private Integer typeId;

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

    /**
     * 书架id
     */
    private Integer bookshelfId;

    /**
     * 书架添加时间
     */
    private long addTime;

    private String authorInfo;

    private String bookPublish;

    private String publishYear;

    public static BookResp convert(Book book) {

        return BookResp.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .synopsis(book.getSynopsis())
                .score(book.getScore())
                .link(book.getLink())
                .typeId(book.getTypeId())
                .picture(book.getPicture())
                .popularity(book.getPopularity())
                .isNewest(book.getIsNewest())
                .isEnd(book.getIsEnd())
                .authorInfo(book.getAuthorInfo())
                .bookPublish(book.getBookPublish())
                .publishYear(book.getPublishYear())
                .build();
    }

    public static BookResp convert(List<Book> books, Bookshelf bookshelf) {

        Book book = books.stream().filter(b -> bookshelf.getBookId().equals(b.getId())).findFirst().get();
        return BookResp.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .synopsis(book.getSynopsis())
                .score(book.getScore())
                .link(book.getLink())
                .typeId(book.getTypeId())
                .picture(book.getPicture())
                .popularity(book.getPopularity())
                .isNewest(book.getIsNewest())
                .isEnd(book.getIsEnd())
                .authorInfo(book.getAuthorInfo())
                .bookPublish(book.getBookPublish())
                .publishYear(book.getPublishYear())
                .bookshelfId(bookshelf.getId())
                .addTime(bookshelf.getCreatedAt().getTime())
                .build();
    }
}
