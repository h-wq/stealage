package com.xupt.read.controller.resp;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.List;

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

    private Integer chapterNum;

    private List<String> bookPath;

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

    private List<BookChapterResp> bookChapters;

    @Data
    @AllArgsConstructor
    private static class BookChapterResp {

        private int id;

        private String title;
    }

    public static BookInfoResp convert(Book book, BookType bookType) {
        BookInfoResp bookInfoResp = BookInfoResp.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .synopsis(book.getSynopsis())
                .score(book.getScore())
                .link(book.getLink())
                .chapterNum(book.getChapterNum() != null ? book.getChapterNum() : 0)
                .bookPath(JSONObject.parseArray(book.getBookPath(), String.class))
                .typeName(bookType == null ? "" : bookType.getName())
                .picture(book.getPicture())
                .popularity(book.getPopularity())
                .isNewest(book.getIsNewest())
                .isEnd(book.getIsEnd())
                .authorInfo(book.getAuthorInfo())
                .bookPublish(book.getBookPublish())
                .publishYear(book.getPublishYear())
                .build();

        if (!StringUtils.isEmpty(book.getChapterTitles())) {
            List<BookChapterResp> bookChapters = Lists.newArrayList();
            List<String> titles = JSONObject.parseArray(book.getChapterTitles(), String.class);
            for (int i = 0; i < titles.size(); i++) {
                BookChapterResp bookChapter = new BookChapterResp(i + 1, titles.get(i));
                bookChapters.add(bookChapter);
            }
            bookInfoResp.setBookChapters(bookChapters);
        }
        return bookInfoResp;
    }
}
