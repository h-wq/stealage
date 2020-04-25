package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.Bookshelf;
import lombok.Builder;

import java.util.List;

@Builder
public class BookResp {

    private Integer id;

    private String name;

    private String author;

    private String synopsis;

    private Integer score;

    private String link;

    private Integer typeId;

    private String picture;

    private Integer popularity;

    private Boolean isNewest;

    private Boolean isEnd;

    private Integer bookshelfId;

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
                .bookshelfId(bookshelf.getId())
                .build();
    }
}
