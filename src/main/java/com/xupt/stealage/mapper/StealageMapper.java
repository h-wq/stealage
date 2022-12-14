package com.xupt.stealage.mapper;

import com.xupt.stealage.model.Stealage;
import com.xupt.stealage.model.StealageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StealageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    long countByExample(StealageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int deleteByExample(StealageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int insert(Stealage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int insertSelective(Stealage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    List<Stealage> selectByExample(StealageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    Stealage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByExampleSelective(@Param("record") Stealage record, @Param("example") StealageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByExample(@Param("record") Stealage record, @Param("example") StealageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByPrimaryKeySelective(Stealage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stealage
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByPrimaryKey(Stealage record);
}