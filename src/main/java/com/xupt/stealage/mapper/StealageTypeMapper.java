package com.xupt.stealage.mapper;

import com.xupt.stealage.model.StealageType;
import com.xupt.stealage.model.StealageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StealageTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    long countByExample(StealageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int deleteByExample(StealageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int insert(StealageType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int insertSelective(StealageType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    List<StealageType> selectByExample(StealageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    StealageType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int updateByExampleSelective(@Param("record") StealageType record, @Param("example") StealageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int updateByExample(@Param("record") StealageType record, @Param("example") StealageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int updateByPrimaryKeySelective(StealageType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage_types
     *
     * @mbg.generated Sun Dec 04 00:21:25 CST 2022
     */
    int updateByPrimaryKey(StealageType record);
}