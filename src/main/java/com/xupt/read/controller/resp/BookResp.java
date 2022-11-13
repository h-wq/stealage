package com.xupt.read.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import com.xupt.read.model.Bookshelf;
import com.xupt.read.parseManger.BookInfo;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
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

    private String bookPublish;

    private String publishYear;

    /**
     * 书架id
     */
    private Integer bookshelfId;

    /**
     * 书架添加时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    public static BookResp convert(Book book, List<BookType> bookTypes) {

        BookType type = bookTypes.stream().filter(bookType -> book.getTypeId().equals(bookType.getId())).findFirst().orElse(null);
        return buildBookResp(book, type);
    }

    public static BookResp convert(List<Book> books, Bookshelf bookshelf, List<BookType> bookTypes) {

        Book book = books.stream().filter(b -> bookshelf.getBookId().equals(b.getId())).findFirst().get();
        BookType type = bookTypes.stream().filter(bookType -> book.getTypeId().equals(bookType.getId())).findFirst().orElse(null);

        BookResp bookResp = buildBookResp(book, type);
        bookResp.setBookshelfId(bookshelf.getId());
        bookResp.setAddTime(bookshelf.getCreateTime());
        return bookResp;
    }

    public static BookResp convert(BookInfo bookInfo) {

        return BookResp.builder()
                .id(bookInfo.getId())
                .name(bookInfo.getBookName())
                .author(bookInfo.getAuthorName())
                .synopsis(bookInfo.getBookInfo())
                .score(bookInfo.getScore())
                .link(bookInfo.getBookLink())
                .typeName(bookInfo.getBookType())
                .picture(bookInfo.getImgPath())
                .popularity(bookInfo.getPopularity())
                .isNewest(false)
                .isEnd(true)
                .bookPublish(bookInfo.getBookPublish())
                .publishYear(bookInfo.getPublishYear())
                .build();
    }

    private static BookResp buildBookResp(Book book, BookType type) {
        return BookResp.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .synopsis(book.getSynopsis())
                .score(book.getScore())
                .link(book.getLink())
                .typeName(type == null ? "" : type.getName())
                .picture(book.getPicture())
                .popularity(book.getPopularity())
                .isNewest(book.getIsNewest())
                .isEnd(book.getIsEnd())
                .bookPublish(book.getBookPublish())
                .publishYear(book.getPublishYear())
                .build();
    }
}
