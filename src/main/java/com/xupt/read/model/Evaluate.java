package com.xupt.read.model;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluates.id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluates.book_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer bookId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluates.user_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluates.create_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluates.update_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluates.remarks
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table evaluates
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluates.id
     *
     * @return the value of evaluates.id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluates.id
     *
     * @param id the value for evaluates.id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluates.book_id
     *
     * @return the value of evaluates.book_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluates.book_id
     *
     * @param bookId the value for evaluates.book_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluates.user_id
     *
     * @return the value of evaluates.user_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluates.user_id
     *
     * @param userId the value for evaluates.user_id
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluates.create_time
     *
     * @return the value of evaluates.create_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluates.create_time
     *
     * @param createTime the value for evaluates.create_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluates.update_time
     *
     * @return the value of evaluates.update_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluates.update_time
     *
     * @param updateTime the value for evaluates.update_time
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluates.remarks
     *
     * @return the value of evaluates.remarks
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluates.remarks
     *
     * @param remarks the value for evaluates.remarks
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}