package com.xupt.read.model;

import java.io.Serializable;
import java.util.Date;

public class Opinion implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column opinion.id
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column opinion.user_id
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column opinion.content
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column opinion.is_solve
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    private Boolean isSolve;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column opinion.created_at
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    private Date createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table opinion
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column opinion.id
     *
     * @return the value of opinion.id
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column opinion.id
     *
     * @param id the value for opinion.id
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column opinion.user_id
     *
     * @return the value of opinion.user_id
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column opinion.user_id
     *
     * @param userId the value for opinion.user_id
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column opinion.content
     *
     * @return the value of opinion.content
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column opinion.content
     *
     * @param content the value for opinion.content
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column opinion.is_solve
     *
     * @return the value of opinion.is_solve
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public Boolean getIsSolve() {
        return isSolve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column opinion.is_solve
     *
     * @param isSolve the value for opinion.is_solve
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public void setIsSolve(Boolean isSolve) {
        this.isSolve = isSolve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column opinion.created_at
     *
     * @return the value of opinion.created_at
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column opinion.created_at
     *
     * @param createdAt the value for opinion.created_at
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}