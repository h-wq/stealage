package com.xupt.stealage.model;

import java.io.Serializable;
import java.util.Date;

public class StealageType implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stealage_types.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stealage_types.name
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stealage_types.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stealage_types.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stealage_types.id
     *
     * @return the value of stealage_types.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stealage_types.id
     *
     * @param id the value for stealage_types.id
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stealage_types.name
     *
     * @return the value of stealage_types.name
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stealage_types.name
     *
     * @param name the value for stealage_types.name
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stealage_types.create_time
     *
     * @return the value of stealage_types.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stealage_types.create_time
     *
     * @param createTime the value for stealage_types.create_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stealage_types.update_time
     *
     * @return the value of stealage_types.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stealage_types.update_time
     *
     * @param updateTime the value for stealage_types.update_time
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}