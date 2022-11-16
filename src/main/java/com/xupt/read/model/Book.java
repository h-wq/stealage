package com.xupt.read.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.name
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.author
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.teacher_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer teacherId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.synopsis
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String synopsis;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.score
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Double score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.link
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String link;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.book_path
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String bookPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.type_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer typeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.picture
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.popularity
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer popularity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.author_info
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String authorInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.book_publish
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String bookPublish;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.publish_year
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String publishYear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.is_newest
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Boolean isNewest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.is_end
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Boolean isEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.create_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.update_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table books
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.id
     *
     * @return the value of books.id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.id
     *
     * @param id the value for books.id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.name
     *
     * @return the value of books.name
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.name
     *
     * @param name the value for books.name
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.author
     *
     * @return the value of books.author
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.author
     *
     * @param author the value for books.author
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.teacher_id
     *
     * @return the value of books.teacher_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.teacher_id
     *
     * @param teacherId the value for books.teacher_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.synopsis
     *
     * @return the value of books.synopsis
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.synopsis
     *
     * @param synopsis the value for books.synopsis
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.score
     *
     * @return the value of books.score
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Double getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.score
     *
     * @param score the value for books.score
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.link
     *
     * @return the value of books.link
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getLink() {
        return link;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.link
     *
     * @param link the value for books.link
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.book_path
     *
     * @return the value of books.book_path
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getBookPath() {
        return bookPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.book_path
     *
     * @param bookPath the value for books.book_path
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setBookPath(String bookPath) {
        this.bookPath = bookPath == null ? null : bookPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.type_id
     *
     * @return the value of books.type_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.type_id
     *
     * @param typeId the value for books.type_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.picture
     *
     * @return the value of books.picture
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.picture
     *
     * @param picture the value for books.picture
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.popularity
     *
     * @return the value of books.popularity
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getPopularity() {
        return popularity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.popularity
     *
     * @param popularity the value for books.popularity
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.author_info
     *
     * @return the value of books.author_info
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getAuthorInfo() {
        return authorInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.author_info
     *
     * @param authorInfo the value for books.author_info
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo == null ? null : authorInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.book_publish
     *
     * @return the value of books.book_publish
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getBookPublish() {
        return bookPublish;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.book_publish
     *
     * @param bookPublish the value for books.book_publish
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish == null ? null : bookPublish.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.publish_year
     *
     * @return the value of books.publish_year
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.publish_year
     *
     * @param publishYear the value for books.publish_year
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear == null ? null : publishYear.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.is_newest
     *
     * @return the value of books.is_newest
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Boolean getIsNewest() {
        return isNewest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.is_newest
     *
     * @param isNewest the value for books.is_newest
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setIsNewest(Boolean isNewest) {
        this.isNewest = isNewest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.is_end
     *
     * @return the value of books.is_end
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Boolean getIsEnd() {
        return isEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.is_end
     *
     * @param isEnd the value for books.is_end
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setIsEnd(Boolean isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.create_time
     *
     * @return the value of books.create_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.create_time
     *
     * @param createTime the value for books.create_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.update_time
     *
     * @return the value of books.update_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.update_time
     *
     * @param updateTime the value for books.update_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}