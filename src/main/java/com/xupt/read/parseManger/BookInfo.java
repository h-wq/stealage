package com.xupt.read.parseManger;

import java.util.List;

/**
 * @description： 书籍的信息
 */
public class BookInfo {
    /**
     * 书籍名字
     */
    String bookName;
    /**
     * 图片名字
     */
    String imgName;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public List<String> getBookComment() {
        return bookComment;
    }

    public void setBookComment(List<String> bookComment) {
        this.bookComment = bookComment;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("imgName: ").append(imgName).append("\n");
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
