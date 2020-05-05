package com.xupt.read.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.friend_ids
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private String friendIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.picture
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private String picture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.friend_ids
     *
     * @return the value of user.friend_ids
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public String getFriendIds() {
        return friendIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.friend_ids
     *
     * @param friendIds the value for user.friend_ids
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setFriendIds(String friendIds) {
        this.friendIds = friendIds == null ? null : friendIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.picture
     *
     * @return the value of user.picture
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.picture
     *
     * @param picture the value for user.picture
     *
     * @mbg.generated Sun May 03 17:46:42 CST 2020
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}