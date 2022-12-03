package com.xupt.stealage.model;

import java.io.Serializable;
import java.util.Date;

public class CircleComment implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.circle_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer circleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.user_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.comment
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.is_delete
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Boolean isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle_comments.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table circle_comments
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.id
     *
     * @return the value of circle_comments.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.id
     *
     * @param id the value for circle_comments.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.circle_id
     *
     * @return the value of circle_comments.circle_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getCircleId() {
        return circleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.circle_id
     *
     * @param circleId the value for circle_comments.circle_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.user_id
     *
     * @return the value of circle_comments.user_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.user_id
     *
     * @param userId the value for circle_comments.user_id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.comment
     *
     * @return the value of circle_comments.comment
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.comment
     *
     * @param comment the value for circle_comments.comment
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.is_delete
     *
     * @return the value of circle_comments.is_delete
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.is_delete
     *
     * @param isDelete the value for circle_comments.is_delete
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.create_time
     *
     * @return the value of circle_comments.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.create_time
     *
     * @param createTime the value for circle_comments.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle_comments.update_time
     *
     * @return the value of circle_comments.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle_comments.update_time
     *
     * @param updateTime the value for circle_comments.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}