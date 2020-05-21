package com.xupt.read.parseManger;

import lombok.Data;

import java.util.List;

/**
 * @description： 书籍的信息
 */
@Data
public class BookInfo {

    private Integer id;
    /**
     * 书籍名字
     */
    String bookName;
    /**
     * 图片名字
     */
    String imgName;
    /**
     * 图片地址
     */
    String imgPath;
    /**
     * 书籍简介
     */
    String bookInfo;
    /**
     * 书籍评论
     */
    List<String> bookComment;
    /**
     * 作者名字
     */
    String authorName;
    /**
     * 作者简介
     */
    String authorInfo;
    /**
     * 书籍链接
     */
    String bookLink;
    /**
     * 评分
     */
    private Double score;
    /**
     * 人气
     */
    Integer Popularity;
    /**
     * 出版社
     */
    String bookPublish;
    /**
     * 出版年份
     */
    String publishYear;

    /**
     * url
     */
    String bookUrl;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("imgName: ").append(imgName).append("\n");
        sb.append("imgPath: ").append(imgPath).append("\n");
        sb.append("bookName: ").append(bookName).append("\n");
        sb.append("authorName: ").append(authorName).append("\n");
        sb.append("bookPublish: ").append(bookPublish).append("\n");
        sb.append("publishYear: ").append(publishYear).append("\n");
        sb.append("bookLink: ").append(bookLink).append("\n");
        sb.append("bookInfo: ").append(bookInfo).append("\n");
        sb.append("authorInfo: ").append(authorInfo).append("\n");
        sb.append("bookComment: ").append("\n");

        for (int i = 1; i <= bookComment.size(); i++) {
            sb.append("短评"+i+"： ").append(bookComment.get(i-1)).append("\n");
        }

        return sb.toString();
    }
}
