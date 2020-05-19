package com.xupt.read.mapper;

import com.xupt.read.model.Opinion;
import com.xupt.read.model.OpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpinionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    long countByExample(OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int deleteByExample(OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int insert(Opinion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int insertSelective(Opinion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    List<Opinion> selectByExample(OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    Opinion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int updateByExampleSelective(@Param("record") Opinion record, @Param("example") OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int updateByExample(@Param("record") Opinion record, @Param("example") OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int updateByPrimaryKeySelective(Opinion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinion
     *
     * @mbg.generated Wed May 20 01:20:08 CST 2020
     */
    int updateByPrimaryKey(Opinion record);
}