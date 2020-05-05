package com.xupt.read.model;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.book_id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private Integer bookId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.user_id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.created_at
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.remarks
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table evaluate
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.id
     *
     * @return the value of evaluate.id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.id
     *
     * @param id the value for evaluate.id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.book_id
     *
     * @return the value of evaluate.book_id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.book_id
     *
     * @param bookId the value for evaluate.book_id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.user_id
     *
     * @return the value of evaluate.user_id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.user_id
     *
     * @param userId the value for evaluate.user_id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.created_at
     *
     * @return the value of evaluate.created_at
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.created_at
     *
     * @param createdAt the value for evaluate.created_at
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.remarks
     *
     * @return the value of evaluate.remarks
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.remarks
     *
     * @param remarks the value for evaluate.remarks
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}