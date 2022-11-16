package com.xupt.read.mapper;

import com.xupt.read.model.Opinion;
import com.xupt.read.model.OpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpinionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    long countByExample(OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int deleteByExample(OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int insert(Opinion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int insertSelective(Opinion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    List<Opinion> selectByExample(OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    Opinion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByExampleSelective(@Param("record") Opinion record, @Param("example") OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByExample(@Param("record") Opinion record, @Param("example") OpinionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByPrimaryKeySelective(Opinion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table opinions
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByPrimaryKey(Opinion record);
}