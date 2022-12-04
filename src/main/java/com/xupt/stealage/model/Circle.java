package com.xupt.stealage.model;

import java.io.Serializable;
import java.util.Date;

public class Circle implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.user_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.stealage_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer stealageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.pictures
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private String pictures;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.comment
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.coefficient
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer coefficient;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.location
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.is_delete
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Boolean isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circles.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table circles
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.id
     *
     * @return the value of circles.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.id
     *
     * @param id the value for circles.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.user_id
     *
     * @return the value of circles.user_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.user_id
     *
     * @param userId the value for circles.user_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.stealage_id
     *
     * @return the value of circles.stealage_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getStealageId() {
        return stealageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.stealage_id
     *
     * @param stealageId the value for circles.stealage_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setStealageId(Integer stealageId) {
        this.stealageId = stealageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.pictures
     *
     * @return the value of circles.pictures
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public String getPictures() {
        return pictures;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.pictures
     *
     * @param pictures the value for circles.pictures
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.comment
     *
     * @return the value of circles.comment
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.comment
     *
     * @param comment the value for circles.comment
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.coefficient
     *
     * @return the value of circles.coefficient
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getCoefficient() {
        return coefficient;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.coefficient
     *
     * @param coefficient the value for circles.coefficient
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.location
     *
     * @return the value of circles.location
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.location
     *
     * @param location the value for circles.location
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.is_delete
     *
     * @return the value of circles.is_delete
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.is_delete
     *
     * @param isDelete the value for circles.is_delete
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.create_time
     *
     * @return the value of circles.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.create_time
     *
     * @param createTime the value for circles.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circles.update_time
     *
     * @return the value of circles.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circles.update_time
     *
     * @param updateTime the value for circles.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}